package de.lordjulixn.armorstandeditor.inventorys;

import de.lordjulixn.armorstandeditor.design.Design;
import de.lordjulixn.armorstandeditor.languages.Language;
import de.lordjulixn.armorstandeditor.main.Main;
import de.lordjulixn.armorstandeditor.utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.ArmorStand;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

public class InventorySettingsN extends InventoryOverlay {

    /*
    ArmorStandEditor - @LordJulixn
    2022 - https://github.com/LordJulixn
     */


    private Inventory inventory;

    public InventorySettingsN(ArmorStand armorStand) {
        //
        inventory = Bukkit.createInventory(null, 27, inventoryName(Main.getLanguage()));
        //
        ItemStack spacer = new ItemBuilder(Main.spacerMaterial).setDisplayName("§8").build();
        for(int i = 0; i < inventory.getSize(); i++) inventory.setItem(i, spacer);
        //
        ItemStack itemVisible = new ItemBuilder(Material.ENDER_EYE).setDisplayName(nameVisible(Main.getLanguage()))
                .setLore(getLoreByValue(armorStand.isVisible(), Main.getLanguage())).build();
        ItemStack itemInvulnerable = new ItemBuilder(Material.TOTEM_OF_UNDYING).setDisplayName(nameInvulnerable(Main.getLanguage()))
                .setLore(getLoreByValue(armorStand.isInvulnerable(), Main.getLanguage())).build();
        ItemStack itemBasePlate = new ItemBuilder(Material.SMOOTH_STONE_SLAB).setDisplayName(nameBasePlate(Main.getLanguage()))
                .setLore(getLoreByValue(armorStand.hasBasePlate(), Main.getLanguage())).build();
        ItemStack itemGravity = new ItemBuilder(Material.FIREWORK_ROCKET).setDisplayName(nameGravity(Main.getLanguage()))
                .setLore(getLoreByValue(armorStand.hasGravity(), Main.getLanguage())).build();
        ItemStack itemArms = new ItemBuilder(Material.STICK).setDisplayName(nameArms(Main.getLanguage()))
                .setLore(getLoreByValue(armorStand.hasArms(), Main.getLanguage())).build();
        ItemStack itemSmall = new ItemBuilder(Material.FEATHER).setDisplayName(nameSmall(Main.getLanguage()))
                .setLore(getLoreByValue(armorStand.isSmall(), Main.getLanguage())).build();
        ItemStack itemCustomName = new ItemBuilder(Material.NAME_TAG).setDisplayName(nameCustomName(Main.getLanguage()))
                .setLore(getLoreByValue(armorStand.isCustomNameVisible(), Main.getLanguage())).build();
        //
        inventory.setItem(10, itemVisible);
        inventory.setItem(11, itemInvulnerable);
        inventory.setItem(12, itemBasePlate);
        inventory.setItem(13, itemGravity);
        inventory.setItem(14, itemArms);
        inventory.setItem(15, itemSmall);
        inventory.setItem(16, itemCustomName);
        //
        inventory.setItem(26, new ItemBuilder(Material.RED_STAINED_GLASS_PANE).setDisplayName(Design.backText(Main.getLanguage())).build());
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
    private ArrayList<String> getLoreByValue(boolean value, Language language) {
        if(value) return Design.toggleLoreTrue(language);
        return Design.toggleLoreFalse(language);
    }
    //

    //
    public static String inventoryName(Language language) {
        //
        return InventorySettingsY.inventoryName(language);
        //
    }
    //
    public static String nameVisible(Language language) {
        //
        if(language == Language.DEUTSCH) return "§bSichtbarkeit";
        return "§bVisible";
        //
    }
    public static String nameInvulnerable(Language language) {
        //
        if(language == Language.DEUTSCH) return "§eUnsterblich";
        return "§eInvulnerable";
        //
    }
    public static String nameBasePlate(Language language) {
        //
        if(language == Language.DEUTSCH) return "§7BasePlate";
        return "§7BasePlate";
        //
    }
    public static String nameGravity(Language language) {
        //
        if(language == Language.DEUTSCH) return "§5Gravitation";
        return "§5Gravity";
        //
    }
    public static String nameArms(Language language) {
        //
        if(language == Language.DEUTSCH) return "§3Arme";
        return "§3Arms";
        //
    }
    public static String nameSmall(Language language) {
        //
        if(language == Language.DEUTSCH) return "§6Klein";
        return "§6Small";
        //
    }
    public static String nameCustomName(Language language) {
        //
        if(language == Language.DEUTSCH) return "§aCustomName";
        return "§aCustomName";
        //
    }
    //

}
