package de.lordjulixn.armorstandeditor.inventorys;

import de.lordjulixn.armorstandeditor.design.Design;
import de.lordjulixn.armorstandeditor.languages.Language;
import de.lordjulixn.armorstandeditor.main.Main;
import de.lordjulixn.armorstandeditor.utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.ArmorStand;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;

public class InventorySlots extends InventoryOverlay {

    /*
    ArmorStandEditor - @LordJulixn
    2022 - https://github.com/LordJulixn
     */


    private Inventory inventory;
    private HashMap<EquipmentSlot, Integer> itemSlots;

    public InventorySlots(ArmorStand armorStand) {
        //
        inventory = Bukkit.createInventory(null, 18, inventoryName(Main.getLanguage()));
        ItemStack spacerItem = new ItemBuilder(Main.spacerMaterial).setDisplayName("§8").build();
        for(int i = 0; i < 9; i++) inventory.setItem(i, spacerItem);
        inventory.setItem(9, spacerItem); inventory.setItem(14, spacerItem);
        //
        ItemStack itemHelmet = new ItemBuilder(Material.LEATHER_HELMET).setDisplayName(nameHelmet(Main.getLanguage())).build();
        ItemStack itemChestplate = new ItemBuilder(Material.LEATHER_CHESTPLATE).setDisplayName(nameChestplate(Main.getLanguage())).build();
        ItemStack itemLeggings = new ItemBuilder(Material.LEATHER_LEGGINGS).setDisplayName(nameLeggings(Main.getLanguage())).build();
        ItemStack itemBoots = new ItemBuilder(Material.LEATHER_BOOTS).setDisplayName(nameBoots(Main.getLanguage())).build();
        ItemStack itemLeftHand = new ItemBuilder(Material.IRON_SWORD).setDisplayName(nameLeftHand(Main.getLanguage())).build();
        ItemStack itemRightHand = new ItemBuilder(Material.IRON_PICKAXE).setDisplayName(nameRightHand(Main.getLanguage())).build();
        //
        inventory.setItem(1, itemHelmet); inventory.setItem(2, itemChestplate);
        inventory.setItem(3, itemLeggings); inventory.setItem(4, itemBoots);
        inventory.setItem(6, itemLeftHand); inventory.setItem(7, itemRightHand);
        //
        inventory.setItem(17, new ItemBuilder(Material.RED_STAINED_GLASS_PANE).setDisplayName(Design.backText(Main.getLanguage())).build());
        //
        itemSlots = new HashMap<>();
        itemSlots.put(EquipmentSlot.HEAD, 10);
        itemSlots.put(EquipmentSlot.CHEST, 11);
        itemSlots.put(EquipmentSlot.LEGS, 12);
        itemSlots.put(EquipmentSlot.FEET, 13);
        itemSlots.put(EquipmentSlot.HAND, 15);
        itemSlots.put(EquipmentSlot.OFF_HAND, 16);
        //
        for(EquipmentSlot eSlot : itemSlots.keySet()) {
            if(armorStand.getEquipment().getItem(eSlot) != null) inventory.setItem(itemSlots.get(eSlot), armorStand.getEquipment().getItem(eSlot));
        }
        //
    }
    //
    @Override
    public String getInventoryName() {
        //
        return inventoryName(Main.getLanguage());
        //
    }
    @Override
    public Inventory getInventory() {
        //
        return inventory;
        //
    }
    //

    //
    public static String inventoryName(Language language) {
        //
        if(language == Language.DEUTSCH) return "§7» §8Edit §7» §bSlots";
        return "§7» §8Edit §7» §bSlots";
        //
    }
    //
    public static String nameHelmet(Language language) {
        //
        if(language == Language.DEUTSCH) return "§7Helm";
        return "§7Helmet";
        //
    }
    public static String nameChestplate(Language language) {
        //
        if(language == Language.DEUTSCH) return "§7Brustplatte";
        return "§7Chestplate";
        //
    }
    public static String nameLeggings(Language language) {
        //
        if(language == Language.DEUTSCH) return "§7Hose";
        return "§7Leggings";
        //
    }
    public static String nameBoots(Language language) {
        //
        if(language == Language.DEUTSCH) return "§7Schuhe";
        return "§7Boots";
        //
    }
    public static String nameLeftHand(Language language) {
        //
        if(language == Language.DEUTSCH) return "§7Linke Hand";
        return "§7Left hand";
        //
    }
    public static String nameRightHand(Language language) {
        //
        if(language == Language.DEUTSCH) return "§7Rechte Hand";
        return "§7Right hand";
        //
    }
    //

}
