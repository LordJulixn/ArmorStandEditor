package de.lordjulixn.armorstandeditor.main;

import de.lordjulixn.armorstandeditor.languages.Language;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

public class Files {

    /*
    ArmorStandEditor - @LordJulixn
    2022 - https://github.com/LordJulixn
     */

    private static File configFile;
    private static YamlConfiguration config;

    public static void init(Main plugin) {
        //
        configFile = new File("plugins/ArmorStandEditor", "Config.yml");
        if(!configFile.exists()) plugin.saveResource("Config.yml", false);
        config = YamlConfiguration.loadConfiguration(configFile);
        //
    }
    public static YamlConfiguration getConfig() {
        //
        return config;
        //
    }

    public static void updateLanguage() {
        //
        String languageSet = getConfig().getString("Language");
        for(Language language : Language.values()) if(language.toString().equalsIgnoreCase(languageSet)) Main.setLanguage(language);
        //
    }

}
