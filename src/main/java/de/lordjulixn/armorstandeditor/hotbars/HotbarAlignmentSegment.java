package de.lordjulixn.armorstandeditor.hotbars;

import de.lordjulixn.armorstandeditor.design.Design;
import de.lordjulixn.armorstandeditor.languages.Language;
import de.lordjulixn.armorstandeditor.main.Main;
import de.lordjulixn.armorstandeditor.utils.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class HotbarAlignmentSegment extends HotbarOverlay {

    /*
    ArmorStandEditor - @LordJulixn
    2022 - https://github.com/LordJulixn
     */

    @Override
    public void setHotbar(Player player) {
        //
        ItemStack item0 = new ItemBuilder(Material.GREEN_STAINED_GLASS_PANE).setDisplayName(resetText(Main.getLanguage())).build();
        ItemStack item3 = new ItemBuilder(Design.textureAxisX).setDisplayName(itemText(Main.getLanguage()))
                .setLore("§8Axis-X").build();
        ItemStack item4 = new ItemBuilder(Design.textureAxisY).setDisplayName(itemText(Main.getLanguage()))
                .setLore("§8Axis-Y").build();
        ItemStack item5 = new ItemBuilder(Design.textureAxisZ).setDisplayName(itemText(Main.getLanguage()))
                .setLore("§8Axis-Z").build();
        ItemStack item8 = new ItemBuilder(Material.RED_STAINED_GLASS_PANE).setDisplayName(closeText(Main.getLanguage())).build();
        //
        player.getInventory().setItem(0, item0);
        player.getInventory().setItem(3, item3);
        player.getInventory().setItem(4, item4);
        player.getInventory().setItem(5, item5);
        player.getInventory().setItem(8, item8);
        //
    }

    //
    public static String closeText(Language language) {
        //
        if(language == Language.DEUTSCH) return "§7Linksklick §cZurück §8┃ §cSchließen §7Rechtsklick";
        return "§7Left click §cBack §8┃ §cClose §7Right click";
        //
    }
    public static String resetText(Language language) {
        //
        if(language == Language.DEUTSCH) return "§aZurücksetzen";
        return "§aReset";
        //
    }
    public static String itemText(Language language) {
        //
        if(language == Language.DEUTSCH) return "§7Linksklick §a+ §8┃ §c- §7Rechtsklick";
        return "§7Left click §a+ §8┃ §c- §7Right click";
        //
    }
    //

}
