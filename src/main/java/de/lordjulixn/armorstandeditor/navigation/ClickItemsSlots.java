package de.lordjulixn.armorstandeditor.navigation;

import de.lordjulixn.armorstandeditor.design.Design;
import de.lordjulixn.armorstandeditor.inventorys.InventoryMenu;
import de.lordjulixn.armorstandeditor.main.Main;
import de.lordjulixn.armorstandeditor.utils.InventoryManager;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;

public class ClickItemsSlots {

    /*
    ArmorStandEditor - @LordJulixn
    2022 - https://github.com/LordJulixn
     */

    private HashMap<Integer, EquipmentSlot> itemSlots;

    public ClickItemsSlots() {
        //
        itemSlots = new HashMap<>();
        itemSlots.put(10, EquipmentSlot.HEAD);
        itemSlots.put(11, EquipmentSlot.CHEST);
        itemSlots.put(12, EquipmentSlot.LEGS);
        itemSlots.put(13, EquipmentSlot.FEET);
        itemSlots.put(15, EquipmentSlot.HAND);
        itemSlots.put(16, EquipmentSlot.OFF_HAND);
        //
    }

    public void execute(Player player, InventoryClickEvent event) {
        //
        ItemStack item = event.getCurrentItem();
        //
        if(itemSlots.containsKey(event.getSlot())) return;
        event.setCancelled(true);
        if(item == null) return;
        //
        if(item.getItemMeta().getDisplayName().equals(Design.backText(Main.getLanguage()))) {
            InventoryManager.openInventory(player, new InventoryMenu());
            return;
        }
        //
    }
    public HashMap<Integer, EquipmentSlot> getItemSlots() {
        //
        return itemSlots;
        //
    }

}
