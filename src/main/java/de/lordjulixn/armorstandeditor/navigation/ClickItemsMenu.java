package de.lordjulixn.armorstandeditor.navigation;

import de.lordjulixn.armorstandeditor.inventorys.*;
import de.lordjulixn.armorstandeditor.main.Main;
import de.lordjulixn.armorstandeditor.utils.ArmorStandEditor;
import de.lordjulixn.armorstandeditor.utils.InventoryManager;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class ClickItemsMenu {

    /*
    ArmorStandEditor - @LordJulixn
    2022 - https://github.com/LordJulixn
     */

    public void execute(Player player, InventoryClickEvent event) {
        //
        event.setCancelled(true);
        //
        ItemStack item = event.getCurrentItem();
        if(!ClickItems.isPluginItem(item)) return;
        //
        if(item.getItemMeta().getDisplayName().equals(InventoryMenu.settingsText(Main.getLanguage()))) {
            //
            ArmorStand armorStand = ArmorStandEditor.getArmorStandEditor(player).getArmorStand();
            if(armorStand.isCustomNameVisible()) {
                InventoryManager.openInventory(player, new InventorySettingsY(armorStand));
            } else InventoryManager.openInventory(player, new InventorySettingsN(armorStand));
            return;
            //
        }
        if(item.getItemMeta().getDisplayName().equals(InventoryMenu.slotsText(Main.getLanguage()))) {
            //
            InventoryManager.openInventory(player, new InventorySlots(ArmorStandEditor.getArmorStandEditor(player).getArmorStand()));
            return;
            //
        }
        if(item.getItemMeta().getDisplayName().equals(InventoryMenu.positionText(Main.getLanguage()))) {
            //
            InventoryManager.openInventory(player, new InventoryPosition(player));
            return;
            //
        }
        //
    }

}
