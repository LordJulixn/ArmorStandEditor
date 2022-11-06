package de.lordjulixn.armorstandeditor.hotbars;

import de.lordjulixn.armorstandeditor.design.Design;
import de.lordjulixn.armorstandeditor.languages.Language;
import de.lordjulixn.armorstandeditor.main.Main;
import de.lordjulixn.armorstandeditor.utils.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class HotbarPositionMenu extends HotbarOverlay {

    /*
    ArmorStandEditor - @LordJulixn
    2022 - https://github.com/LordJulixn
     */

    @Override
    public void setHotbar(Player player) {
        //
        ItemStack item0 = new ItemBuilder(Material.YELLOW_STAINED_GLASS_PANE).setDisplayName(backToStepsText(Main.getLanguage())).build();
        ItemStack item2  = new ItemBuilder(Design.textureAxisX).setDisplayName(itemText(Main.getLanguage()))
                .setLore("§8Axis-X").build();
        ItemStack item3 = new ItemBuilder(Design.textureAxisY).setDisplayName(itemText(Main.getLanguage()))
                .setLore("§8Axis-Y").build();
        ItemStack item4 = new ItemBuilder(Design.textureAxisZ).setDisplayName(itemText(Main.getLanguage()))
                .setLore("§8Axis-Z").build();
        ItemStack item6 = new ItemBuilder(Design.textureAxisR).setDisplayName(itemText(Main.getLanguage()))
                .setLore("§8Axis-R").build();
        ItemStack item8 = new ItemBuilder(Material.RED_STAINED_GLASS_PANE).setDisplayName(closeText(Main.getLanguage())).build();
        //
        player.getInventory().setItem(0, item0);
        player.getInventory().setItem(2, item2);
        player.getInventory().setItem(3, item3);
        player.getInventory().setItem(4, item4);
        player.getInventory().setItem(6, item6);
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
    public static String itemText(Language language) {
        //
        if(language == Language.DEUTSCH) return "§7Linksklick §a+ §8┃ §c- §7Rechtsklick";
        return "§7Left click §a+ §8┃ §c- §7Right click";
        //
    }
    //

}
