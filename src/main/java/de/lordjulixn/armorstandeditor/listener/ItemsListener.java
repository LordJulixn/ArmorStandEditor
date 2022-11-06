package de.lordjulixn.armorstandeditor.listener;

import de.lordjulixn.armorstandeditor.utils.ArmorStandEditor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;

public class ItemsListener implements Listener {

    /*
    ArmorStandEditor - @LordJulixn
    2022 - https://github.com/LordJulixn
     */

    @EventHandler
    public void onDrop(PlayerDropItemEvent event) {
        //
        Player player = event.getPlayer();
        //
        if(ArmorStandEditor.getArmorStandEditor(player) != null) if(ArmorStandEditor.getArmorStandEditor(player).isInHotbar()) event.setCancelled(true);
        //
    }
    @EventHandler
    public void onPickUp(PlayerPickupItemEvent event) {
        //
        Player player = event.getPlayer();
        //
        if(ArmorStandEditor.getArmorStandEditor(player) != null) if(ArmorStandEditor.getArmorStandEditor(player).isInHotbar()) event.setCancelled(true);
        //
    }
    @EventHandler
    public void onSwap(PlayerSwapHandItemsEvent event) {
        //
        Player player = event.getPlayer();
        //
        if(ArmorStandEditor.getArmorStandEditor(player) != null) if(ArmorStandEditor.getArmorStandEditor(player).isInHotbar()) event.setCancelled(true);
        //
    }

}
