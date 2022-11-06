package de.lordjulixn.armorstandeditor.navigation;

import de.lordjulixn.armorstandeditor.inventorys.*;
import de.lordjulixn.armorstandeditor.main.Main;
import de.lordjulixn.armorstandeditor.utils.ArmorStandEditor;
import de.lordjulixn.armorstandeditor.utils.InventoryManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class ClickItems implements Listener {

    /*
    ArmorStandEditor - @LordJulixn
    2022 - https://github.com/LordJulixn
     */

    @EventHandler
    public void onClick(InventoryClickEvent event) {
        //
        if(!(event.getWhoClicked() instanceof Player)) return;
        Player player = (Player) event.getWhoClicked();
        //
        if(ArmorStandEditor.getArmorStandEditor(player) != null && ArmorStandEditor.getArmorStandEditor(player).isInHotbar()) {
            event.setCancelled(true);
            return;
        }
        //
        if(!InventoryManager.hasOpenInventory(player)) return;
        if(event.getAction() == InventoryAction.MOVE_TO_OTHER_INVENTORY && !InventoryManager.checkOpenInv(player, InventorySlots.inventoryName(Main.getLanguage()))) {
            event.setCancelled(true);
            return;
        }
        if(event.getClickedInventory() == player.getOpenInventory().getBottomInventory()) return;
        //
        if(InventoryManager.checkOpenInv(player, InventoryMenu.inventoryName(Main.getLanguage()))) {
            new ClickItemsMenu().execute(player, event);
            return;
        }
        if(InventoryManager.checkOpenInv(player, InventorySettingsN.inventoryName(Main.getLanguage()))) {
            new ClickItemsSettings().execute(player, event);
            return;
        }
        if(InventoryManager.checkOpenInv(player, InventorySettingsY.inventoryName(Main.getLanguage()))) {
            new ClickItemsSettings().execute(player, event);
            return;
        }
        if(InventoryManager.checkOpenInv(player, InventorySlots.inventoryName(Main.getLanguage()))) {
            new ClickItemsSlots().execute(player, event);
            return;
        }
        if(InventoryManager.checkOpenInv(player, InventoryPosition.inventoryName(Main.getLanguage()))) {
            new ClickItemsPosition().execute(player, event);
            return;
        }
        //
    }
    public static boolean isPluginItem(ItemStack itemStack) {
        //
        if(itemStack == null) return false;
        if(!itemStack.hasItemMeta()) return false;
        if(!itemStack.getItemMeta().hasDisplayName()) return false;
        return true;
        //
    }

}
