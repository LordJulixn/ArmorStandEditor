package de.lordjulixn.armorstandeditor.listener;

import de.lordjulixn.armorstandeditor.inventorys.InventorySettingsY;
import de.lordjulixn.armorstandeditor.inventorys.InventorySlots;
import de.lordjulixn.armorstandeditor.main.Main;
import de.lordjulixn.armorstandeditor.navigation.ClickItemsSlots;
import de.lordjulixn.armorstandeditor.utils.ArmorStandEditor;
import de.lordjulixn.armorstandeditor.utils.InventoryManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.EquipmentSlot;

import java.util.HashMap;

public class InventoryCloseListener implements Listener {

    /*
    ArmorStandEditor - @LordJulixn
    2022 - https://github.com/LordJulixn
     */

    @EventHandler
    public void onClose(InventoryCloseEvent event) {
        //
        Player player = (Player) event.getPlayer();
        //
        if(InventoryManager.checkOpenInv(player, InventorySettingsY.inventoryName(Main.getLanguage()))) {
            if(event.getInventory().getSize() > 27) {
                if(event.getInventory().getItem(40) != null) player.getInventory().addItem(event.getInventory().getItem(40));
            }
        }
        //
        if(InventoryManager.checkOpenInv(player, InventorySlots.inventoryName(Main.getLanguage()))) {
            //
            HashMap<Integer, EquipmentSlot> itemSlots = new ClickItemsSlots().getItemSlots();
            //
            if(ArmorStandEditor.getArmorStandEditor(player) == null) return;
            if(ArmorStandEditor.getArmorStandEditor(player).getArmorStand() == null) return;
            ArmorStand armorStand = ArmorStandEditor.getArmorStandEditor(player).getArmorStand();
            //
            for(int i : itemSlots.keySet()) {
                if(event.getInventory().getItem(i) != null) {
                    armorStand.getEquipment().setItem(itemSlots.get(i), event.getInventory().getItem(i));
                } else armorStand.getEquipment().setItem(itemSlots.get(i), null);
            }
            //
        }
        //
        InventoryManager.removeInventory(player);
        //
        Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), () -> {
            if(!InventoryManager.hasOpenInventory(player)) {
                if(ArmorStandEditor.getArmorStandEditor(player) != null) {
                    if(!ArmorStandEditor.getArmorStandEditor(player).isInHotbar()) {
                        ArmorStandEditor.removeEditor(player);
                    }
                }
            }
        }, 1);
        //
    }

}
