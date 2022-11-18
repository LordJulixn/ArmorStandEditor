package de.lordjulixn.armorstandeditor.main;

import de.lordjulixn.armorstandeditor.commands.CMD_ArmorStandEditor;
import de.lordjulixn.armorstandeditor.commands.Tab_ArmorStandEditor;
import de.lordjulixn.armorstandeditor.languages.Language;
import de.lordjulixn.armorstandeditor.languages.Messages;
import de.lordjulixn.armorstandeditor.listener.*;
import de.lordjulixn.armorstandeditor.navigation.ClickItems;
import de.lordjulixn.armorstandeditor.utils.ArmorStandEditor;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    /*
    ArmorStandEditor - @LordJulixn
    2022 - https://github.com/LordJulixn
     */

    public static String prefix = "§8[§bASE§8] §7";
    public static Material spacerMaterial = Material.GRAY_STAINED_GLASS_PANE;
    private static Main plugin;
    private static Language currentLanguage = Language.DEUTSCH;

    @Override
    public void onEnable() {
        //
        plugin = this;
        Files.init(this);
        Files.updateLanguage();
        //
        Bukkit.getConsoleSender().sendMessage("§8§m------------------------------");
        Bukkit.getConsoleSender().sendMessage("");
        Bukkit.getConsoleSender().sendMessage(" _____                        _____  _                _  _____    _  _  _             ");
        Bukkit.getConsoleSender().sendMessage("|  _  | ___  _____  ___  ___ |   __|| |_  ___  ___  _| ||   __| _| ||_|| |_  ___  ___ ");
        Bukkit.getConsoleSender().sendMessage("|     ||  _||     || . ||  _||__   ||  _|| .'||   || . ||   __|| . || ||  _|| . ||  _|");
        Bukkit.getConsoleSender().sendMessage("|__|__||_|  |_|_|_||___||_|  |_____||_|  |__,||_|_||___||_____||___||_||_|  |___||_|  ");
        Bukkit.getConsoleSender().sendMessage("");
        //
        if(!Files.getConfig().getString("ConfigVersion").equals(getDescription().getVersion())) {
            String currentVersion = getDescription().getVersion();
            String configVersion = Files.getConfig().getString("ConfigVersion");
            Bukkit.getConsoleSender().sendMessage(Messages.getConsoleWrongVersionMessage1(currentLanguage, currentVersion, configVersion));
            Bukkit.getConsoleSender().sendMessage(Messages.getConsoleWrongVersionMessage2(currentLanguage));
            Bukkit.getConsoleSender().sendMessage("");
            Bukkit.getConsoleSender().sendMessage("§8§m------------------------------");
            Bukkit.getPluginManager().disablePlugin(this);
            return;
        }
        //
        initPlugin();
        //
        Bukkit.getConsoleSender().sendMessage(Messages.getConsoleEnableMessage1(currentLanguage));
        Bukkit.getConsoleSender().sendMessage(Messages.getConsoleEnableMessage2(currentLanguage));
        Bukkit.getConsoleSender().sendMessage(Messages.getConsoleEnableMessage3(currentLanguage));
        Bukkit.getConsoleSender().sendMessage("");
        Bukkit.getConsoleSender().sendMessage("§8§m------------------------------");
        //
    }

    @Override
    public void onDisable() {
        //
        for(ArmorStandEditor editor : ArmorStandEditor.getAllEditors()) {
            if(editor.isInHotbar()) editor.giveHotbar(editor.getPlayer());
        }
        //
        for(ArmorStandEditor editor : ArmorStandEditor.getAllEditors()) editor.getPlayer().closeInventory();
        //
        Bukkit.getConsoleSender().sendMessage("§8§m------------------------------");
        Bukkit.getConsoleSender().sendMessage("");
        Bukkit.getConsoleSender().sendMessage(Messages.getConsoleDisableMessage1(currentLanguage));
        Bukkit.getConsoleSender().sendMessage("");
        Bukkit.getConsoleSender().sendMessage("§8§m------------------------------");
        //
    }

    private void initPlugin() {
        //
        PluginManager manager = Bukkit.getPluginManager();
        //
        manager.registerEvents(new InteractEntityListener(), this);
        manager.registerEvents(new EntityDamageListener(), this);
        manager.registerEvents(new InteractListener(), this);
        manager.registerEvents(new InventoryCloseListener(), this);
        manager.registerEvents(new ConnectionListener(), this);
        manager.registerEvents(new ClickItems(), this);
        manager.registerEvents(new ItemsListener(), this);
        //
        getCommand("ArmorStandEditor").setExecutor(new CMD_ArmorStandEditor());
        getCommand("ArmorStandEditor").setTabCompleter(new Tab_ArmorStandEditor());
        //
    }


    public static Main getPlugin() {
        //
        return plugin;
        //
    }
    public static Language getLanguage() {
        //
        return currentLanguage;
        //
    }
    public static void setLanguage(Language newLanguage) {
        //
        currentLanguage = newLanguage;
        //
    }

}
