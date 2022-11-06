package de.lordjulixn.armorstandeditor.inventorys;

import de.lordjulixn.armorstandeditor.design.Design;
import de.lordjulixn.armorstandeditor.languages.Language;
import de.lordjulixn.armorstandeditor.main.Main;
import de.lordjulixn.armorstandeditor.utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

public class InventoryMenu extends InventoryOverlay {

    /*
    ArmorStandEditor - @LordJulixn
    2022 - https://github.com/LordJulixn
     */


    private Inventory inventory;

    public InventoryMenu() {
        //
        inventory = Bukkit.createInventory(null, 27, inventoryName(Main.getLanguage()));
        ItemStack glassPane = new ItemBuilder(Main.spacerMaterial).setDisplayName("§8").build();
        for(int i = 0; i < inventory.getSize(); i++) inventory.setItem(i, glassPane);
        //
        ItemStack itemPosition = new ItemBuilder(Material.ENDER_PEARL).setDisplayName(positionText(Main.getLanguage()))
                .setLore(positionLore(Main.getLanguage())).build();
        ItemStack itemSettings = new ItemBuilder(Material.MAP).setDisplayName(settingsText(Main.getLanguage()))
                .setLore(settingsLore(Main.getLanguage())).build();
        ItemStack itemSlots = new ItemBuilder(Material.SHIELD).setDisplayName(slotsText(Main.getLanguage()))
                .setLore(slotsLore(Main.getLanguage())).build();
        //
        inventory.setItem(11, itemPosition);
        inventory.setItem(13, itemSettings);
        inventory.setItem(15, itemSlots);
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
        if(language == Language.DEUTSCH) return "§7» §eEdit";
        return "§7» §eEdit";
        //
    }
    //
    public static String positionText(Language language) {
        //
        if(language == Language.DEUTSCH) return "§a§lVerstellung";
        return "§a§lMovement";
        //
    }
    public static ArrayList<String> positionLore(Language language) {
        //
        ArrayList<String> lore = new ArrayList<>();
        lore.add(Design.lorePlaceHolder);
        //
        if(language == language.DEUTSCH) {
            lore.add("§7Verändere die Stellung vom ArmorStand");
            return lore;
        }
        lore.add("§7Change the position of the ArmorStand");
        return lore;
        //
    }
    public static String settingsText(Language language) {
        //
        if(language == Language.DEUTSCH) return "§c§lEinstellungen";
        return "§c§lSettings";
        //
    }
    public static ArrayList<String> settingsLore(Language language) {
        //
        ArrayList<String> lore = new ArrayList<>();
        lore.add(Design.lorePlaceHolder);
        //
        if(language == language.DEUTSCH) {
            lore.add("§7Verändere die Eigenschaften");
            lore.add("§7vom ArmorStand");
            lore.add("§7Ändern durch Klicken");
            return lore;
        }
        lore.add("§7Change the settings of the ArmorStand");
        lore.add("§7Change by clicking");
        return lore;
        //
    }
    public static String slotsText(Language language) {
        //
        if(language == Language.DEUTSCH) return "§b§lSlots";
        return "§b§lSlots";
        //
    }
    public static ArrayList<String> slotsLore(Language language) {
        //
        ArrayList<String> lore = new ArrayList<>();
        lore.add(Design.lorePlaceHolder);
        //
        if(language == language.DEUTSCH) {
            lore.add("§7Verändere die Slots vom ArmorStand");
            lore.add("§7Items reinlegen mit Linksklick");
            return lore;
        }
        lore.add("§7Change the slots of the ArmorStand");
        lore.add("§7Insert items with leftclick");
        return lore;
        //
    }
    //
}
