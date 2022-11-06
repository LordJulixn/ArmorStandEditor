package de.lordjulixn.armorstandeditor.inventorys;

import de.lordjulixn.armorstandeditor.design.Design;
import de.lordjulixn.armorstandeditor.languages.Language;
import de.lordjulixn.armorstandeditor.main.Main;
import de.lordjulixn.armorstandeditor.utils.ArmorStandEditor;
import de.lordjulixn.armorstandeditor.utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

public class InventoryPosition extends InventoryOverlay {

    /*
    ArmorStandEditor - @LordJulixn
    2022 - https://github.com/LordJulixn
     */


    private Inventory inventory;

    public InventoryPosition(Player player) {
        //
        inventory = Bukkit.createInventory(null, 45, inventoryName(Main.getLanguage()));
        //
        ItemStack spacer = new ItemBuilder(Main.spacerMaterial).setDisplayName("§8").build();
        for(int i = 0; i < inventory.getSize(); i++) inventory.setItem(i, spacer);
        //
        ItemStack plus3 = new ItemBuilder(Design.texturePlus).setDisplayName(add1()).build();
        ItemStack plus2 = new ItemBuilder(Design.texturePlus).setDisplayName(add01()).build();
        ItemStack plus1 = new ItemBuilder(Design.texturePlus).setDisplayName(add001()).build();
        ItemStack minus1 = new ItemBuilder(Design.textureMinus).setDisplayName(minus1()).build();
        ItemStack minus2 = new ItemBuilder(Design.textureMinus).setDisplayName(minus01()).build();
        ItemStack minus3 = new ItemBuilder(Design.textureMinus).setDisplayName(minus001()).build();
        //
        ArmorStandEditor editor = ArmorStandEditor.getArmorStandEditor(player);
        ItemStack steps = new ItemBuilder(Material.YELLOW_STAINED_GLASS_PANE).setDisplayName(stepsText(Main.getLanguage()))
                .setLore(loreSpacerText(Main.getLanguage()), "§e"+editor.getSteps()).build();
        //
        inventory.setItem(28, plus1);
        inventory.setItem(29, plus2);
        inventory.setItem(30, plus3);
        inventory.setItem(31, steps);
        inventory.setItem(32, minus1);
        inventory.setItem(33, minus2);
        inventory.setItem(34, minus3);
        //
        ItemStack itemAlignment = new ItemBuilder(Material.BEACON).setDisplayName(alignmentText(Main.getLanguage()))
                .setLore(alignmentLore(Main.getLanguage())).build();
        ItemStack itemPosition = new ItemBuilder(Material.END_PORTAL_FRAME).setDisplayName(positionText(Main.getLanguage()))
                .setLore(positionLore(Main.getLanguage())).build();
        //
        inventory.setItem(12, itemAlignment);
        inventory.setItem(14, itemPosition);
        //
        inventory.setItem(44, new ItemBuilder(Material.RED_STAINED_GLASS_PANE).setDisplayName(Design.backText(Main.getLanguage())).build());
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
        if(language == Language.DEUTSCH) return "§7» §8Edit §7» §aVerstellung";
        return "§7» §8Edit §7» §aMovement";
        //
    }
    //
    public static String stepsText(Language language) {
        //
        if(language == Language.DEUTSCH) return "§eSchritte";
        return "§eSteps";
        //
    }
    public static String loreSpacerText(Language language) {
        //
        if(language == Language.DEUTSCH) return "§7Größe Schritte§8:";
        return "§7Size of steps";
        //
    }
    public static String alignmentText(Language language) {
        //
        if(language == Language.DEUTSCH) return "§aAusrichtung";
        return "§aAlignment";
        //
    }
    public static ArrayList<String> alignmentLore(Language language) {
        //
        ArrayList<String> lore = new ArrayList<>();
        lore.add(Design.lorePlaceHolder);
        //
        if(language == language.DEUTSCH) {
            lore.add("§e1§8. §7Schritte auswählen");
            lore.add("§e2§8. §7Klicken");
            return lore;
        }
        lore.add("§e1§8. §7Select steps");
        lore.add("§e2§8. §7Click");
        return lore;
        //
    }
    public static String positionText(Language language) {
        //
        if(language == Language.DEUTSCH) return "§aPosition";
        return "§aPosition";
        //
    }
    public static ArrayList<String> positionLore(Language language) {
        //
        ArrayList<String> lore = new ArrayList<>();
        lore.add(Design.lorePlaceHolder);
        //
        if(language == language.DEUTSCH) {
            lore.add("§e1§8. §7Schritte auswählen");
            lore.add("§e2§8. §7Klicken");
            return lore;
        }
        lore.add("§e1§8. §7Select steps");
        lore.add("§e2§8. §7Click");
        return lore;
        //
    }
    public static String add1() {
        //
        return "§a+1";
        //
    }
    public static String add01() {
        //
        return "§a+0§8.§a1";
        //
    }
    public static String add001() {
        //
        return "§a+0§8.§a01";
        //
    }
    public static String minus1() {
        //
        return "§c-1";
        //
    }
    public static String minus01() {
        //
        return "§c-0§8.§c1";
        //
    }
    public static String minus001() {
        //
        return "§c-0§8.§c01";
        //
    }
    //

}
