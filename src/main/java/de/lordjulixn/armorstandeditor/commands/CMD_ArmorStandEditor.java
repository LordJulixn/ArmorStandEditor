package de.lordjulixn.armorstandeditor.commands;

import de.lordjulixn.armorstandeditor.languages.Language;
import de.lordjulixn.armorstandeditor.languages.Messages;
import de.lordjulixn.armorstandeditor.main.Files;
import de.lordjulixn.armorstandeditor.main.Main;
import de.lordjulixn.armorstandeditor.utils.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CMD_ArmorStandEditor implements CommandExecutor {

    /*
    ArmorStandEditor - @LordJulixn
    2022 - https://github.com/LordJulixn
     */

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        //
        if(!command.getName().equalsIgnoreCase("ArmorStandEditor")) return false;
        if(!(sender instanceof Player)) return false;
        Player player = (Player) sender;
        if(!player.hasPermission(Files.getConfig().getString("PermissionGetItem"))) {
            player.sendMessage(Messages.noPermissionsMessage(Main.getLanguage()));
            return false;
        }
        //
        if(args.length != 1) {
            player.sendMessage(usageMessage(Main.getLanguage()));
            return false;
        }
        //
        Material material = Material.STONE;
        for(Material materials : Material.values()) if(materials.toString().equalsIgnoreCase(Files.getConfig().getString("Item.Type"))) material = materials;
        ItemBuilder builder = new ItemBuilder(material);
        if(Files.getConfig().getBoolean("Item.RequireDisplayname")) builder.setDisplayName(Files.getConfig().getString("Item.Displayname").replaceAll("&", "§"));
        if(Files.getConfig().getBoolean("Item.RequireLore")) builder.setLore(Files.getConfig().getString("Item.Lore").replaceAll("&", "§"));
        //
        player.getInventory().addItem(builder.build());
        //
        return false;
    }
    private static String usageMessage(Language language) {
        //
        if(language == Language.DEUTSCH) return Main.prefix+" §7Benutze §a/ArmorStandEditor §8<§aGetItem§8>§7!";
        return Main.prefix+" §7Use §a/ArmorStandEditor §8<§aGetItem§8>§7!";
        //
    }

}
