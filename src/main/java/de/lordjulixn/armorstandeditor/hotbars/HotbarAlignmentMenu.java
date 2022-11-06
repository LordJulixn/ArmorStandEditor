package de.lordjulixn.armorstandeditor.hotbars;

import de.lordjulixn.armorstandeditor.languages.Language;
import de.lordjulixn.armorstandeditor.main.Main;
import de.lordjulixn.armorstandeditor.utils.ArmorStandEditor;
import de.lordjulixn.armorstandeditor.utils.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class HotbarAlignmentMenu extends HotbarOverlay {

    /*
    ArmorStandEditor - @LordJulixn
    2022 - https://github.com/LordJulixn
     */

    @Override
    public void setHotbar(Player player) {
        //
        ItemStack item0 = new ItemBuilder(Material.YELLOW_STAINED_GLASS_PANE).setDisplayName(backToStepsText(Main.getLanguage())).build();
        ItemStack item2 = new ItemBuilder(Material.SKELETON_SKULL).setDisplayName(headText(Main.getLanguage())).build();
        ItemStack item3 = new ItemBuilder(Material.IRON_CHESTPLATE).setDisplayName(chestText(Main.getLanguage())).build();
        ItemStack item4 = new ItemBuilder(Material.STICK).setDisplayName(leftArmText(Main.getLanguage())).build();
        ItemStack item5 = new ItemBuilder(Material.STICK).setDisplayName(rightArmText(Main.getLanguage())).build();
        ItemStack item6 = new ItemBuilder(Material.IRON_LEGGINGS).setDisplayName(leftLegText(Main.getLanguage())).build();
        ItemStack item7 = new ItemBuilder(Material.IRON_LEGGINGS).setDisplayName(rightLegText(Main.getLanguage())).build();
        ItemStack item8 = new ItemBuilder(Material.RED_STAINED_GLASS_PANE).setDisplayName(closeText(Main.getLanguage())).build();
        //
        if(ArmorStandEditor.getArmorStandEditor(player) == null) return;
        ArmorStandEditor editor = ArmorStandEditor.getArmorStandEditor(player);
        //
        player.getInventory().setItem(0, item0);
        player.getInventory().setItem((editor.getArmorStand().hasArms()) ? 2 : 4, item2);
        player.getInventory().setItem((editor.getArmorStand().hasArms()) ? 3 : 5, item3);
        if(editor.getArmorStand().hasArms()) {
            player.getInventory().setItem(4, item4);
            player.getInventory().setItem(5, item5);
        }
        player.getInventory().setItem(6, item6);
        player.getInventory().setItem(7, item7);
        player.getInventory().setItem(8, item8);
        //
    }

    //
    public static String closeText(Language language) {
        //
        if(language == Language.DEUTSCH) return "§7Linksklick §cMenü §8┃ §cSchließen §7Rechtsklick";
        return "§7Left click §cMenu §8┃ §cClose §7Right click";
        //
    }
    public static String backToStepsText(Language language) {
        //
        if(language == Language.DEUTSCH) return "§eSchritte setzen";
        return "§eSet steps";
        //
    }
    //
    public static String headText(Language language) {
        //
        if(language == Language.DEUTSCH) return "§bKopf";
        return "§bHead";
        //
    }
    public static String chestText(Language language) {
        //
        if(language == Language.DEUTSCH) return "§bBrust";
        return "§bChest";
        //
    }
    public static String leftLegText(Language language) {
        //
        if(language == Language.DEUTSCH) return "§bLinkes Bein";
        return "§bLeft leg";
        //
    }
    public static String rightLegText(Language language) {
        //
        if(language == Language.DEUTSCH) return "§bRechtes Bein";
        return "§bRight leg";
        //
    }
    public static String leftArmText(Language language) {
        //
        if(language == Language.DEUTSCH) return "§bLinker Arm";
        return "§bLeft arm";
        //
    }
    public static String rightArmText(Language language) {
        //
        if(language == Language.DEUTSCH) return "§bRechter Arm";
        return "§bRight arm";
        //
    }
    //

}
