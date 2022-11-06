package de.lordjulixn.armorstandeditor.utils;

import de.lordjulixn.armorstandeditor.inventorys.InventoryOverlay;
import org.bukkit.entity.Player;

import java.util.HashMap;

public class InventoryManager {

    /*
    ArmorStandEditor - @LordJulixn
    2022 - https://github.com/LordJulixn
     */

    private static HashMap<Player, InventoryOverlay> currentInventorys = new HashMap<>();

    //
    public static void setInventory(Player player, InventoryOverlay inventory) {
        //
        removeInventory(player);
        currentInventorys.put(player, inventory);
        //
    }
    public static void removeInventory(Player player) {
        //
        currentInventorys.remove(player);
        //
    }
    public static boolean hasOpenInventory(Player player) {
        //
        return currentInventorys.containsKey(player);
        //
    }
    public static boolean checkOpenInv(Player player, String inventoryName) {
        //
        if(!currentInventorys.containsKey(player)) return false;
        if(!hasOpenInventory(player)) return false;
        InventoryOverlay openInv = currentInventorys.get(player);
        if(openInv.getInventoryName().equals(inventoryName)) return true;
        return false;
        //
    }
    public static void openInventory(Player player, InventoryOverlay inventoryOverlay) {
        //
        player.openInventory(inventoryOverlay.getInventory());
        setInventory(player, inventoryOverlay);
        //
    }
    //

}
