package de.lordjulixn.armorstandeditor.languages;

import de.lordjulixn.armorstandeditor.main.Main;

public class Messages {

    /*
    ArmorStandEditor - @LordJulixn
    2022 - https://github.com/LordJulixn
     */

    public static String getConsoleEnableMessage1(Language language) {
        if(language == Language.DEUTSCH) return "§8[§bArmorstandEditor§8] §7Das Plugin wurde §aaktiviert§7!";
        return "§8[§bArmorstandEditor§8] §7The plugin is now §aactive§7!";
    }
    public static String getConsoleEnableMessage2(Language language) {
        if(language == Language.DEUTSCH) return "§8[§bArmorstandEditor§8] §7Programmiert von§8: §eLordJulixn";
        return "§8[§bArmorstandEditor§8] §7Coded by§8: §eLordJulixn";
    }
    public static String getConsoleEnableMessage3(Language language) {
        if(language == Language.DEUTSCH) return "§8[§bArmorstandEditor§8] §7Aktuelle Version§8: §e"+
                Main.getPlugin().getDescription().getVersion();
        return "§8[§bArmorstandEditor§8] §7Current version§8: §e"+
                Main.getPlugin().getDescription().getVersion();
    }
    public static String getConsoleDisableMessage1(Language language) {
        if(language == Language.DEUTSCH) return "§8[§bArmorStandEditor§8] §7Das Plugin wurde §cdeaktiviert§7!";
        return "§8[§bArmorStandEditor§8] §7The plugin is now §coffline§7!";
    }

    public static String noPermissionsMessage(Language language) {
        if(language == Language.DEUTSCH) return Main.prefix+"Dazu hast du §ckeine Rechte§7!";
        return Main.prefix+"You are missing the §crights §7to do that!";
    }

    public static String armorStandInUseMessage(Language language) {
        if(language == Language.DEUTSCH) return Main.prefix+"Der ArmorStand wird §cbereits bearbeitet§7!";
        return Main.prefix+"This ArmorStand is already being §cedited§7!";
    }
    public static String armorStandInUseInteractMessage(Language language) {
        if(language == Language.DEUTSCH) return Main.prefix+"Der ArmorStand wird §cgerade bearbeitet§7!";
        return Main.prefix+"This ArmorStand is currently getting §cedited§7!";
    }
    public static String wrongCustomNameItem(Language language) {
        if(language == Language.DEUTSCH) return Main.prefix+"Bitte benutze ein §ebenanntes Papier§7!";
        return Main.prefix+"Please use a §enamed paper§7!";
    }

}
