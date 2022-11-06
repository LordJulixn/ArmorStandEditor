package de.lordjulixn.armorstandeditor.commands;

import de.lordjulixn.armorstandeditor.main.Files;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class Tab_ArmorStandEditor implements TabCompleter {

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        //
        ArrayList<String> completer = new ArrayList<>();
        if(args.length != 1) return completer;
        if(!(sender instanceof Player)) return completer;
        Player player = (Player) sender;
        if(!player.hasPermission(Files.getConfig().getString("PermissionGetItem"))) return completer;
        completer.add("GetItem");
        return completer;
        //
    }

}
