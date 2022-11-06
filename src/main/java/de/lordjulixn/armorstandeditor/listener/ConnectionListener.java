package de.lordjulixn.armorstandeditor.listener;

import de.lordjulixn.armorstandeditor.utils.ArmorStandEditor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class ConnectionListener implements Listener {

    /*
    ArmorStandEditor - @LordJulixn
    2022 - https://github.com/LordJulixn
     */

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        //
        Player player = event.getPlayer();
        if(ArmorStandEditor.getArmorStandEditor(player) == null) return;
        ArmorStandEditor editor = ArmorStandEditor.getArmorStandEditor(player);
        //
        if(editor.isInHotbar()) editor.giveHotbar(player);
        ArmorStandEditor.removeEditor(player);
        //
    }
    @EventHandler
    public void onDeath(PlayerDeathEvent event) {
        //
        Player player = (Player) event.getEntity();
        //
        if(ArmorStandEditor.getArmorStandEditor(player) == null) return;
        if(ArmorStandEditor.getArmorStandEditor(player).isInHotbar()) {
            ArmorStandEditor.getArmorStandEditor(player).giveHotbar(player);
        }
        //
        ArmorStandEditor.removeEditor(player);
        //
    }

}
