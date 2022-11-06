package de.lordjulixn.armorstandeditor.listener;

import de.lordjulixn.armorstandeditor.utils.ArmorStandEditor;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class EntityDamageListener implements Listener {

    /*
    ArmorStandEditor - @LordJulixn
    2022 - https://github.com/LordJulixn
     */

    @EventHandler
    public void onDamage(EntityDamageEvent event) {
        //
        if(event.getEntity() instanceof ArmorStand) {
            ArmorStand armorStand = (ArmorStand) event.getEntity();
            if(!ArmorStandEditor.armorStandInUse(armorStand)) return;
            event.setDamage(0);
        }
        //
        if(event.getEntity() instanceof Player) {
            //
            Player player = (Player) event.getEntity();
            //
            if(ArmorStandEditor.getArmorStandEditor(player) == null) return;
            //
            if(event.getFinalDamage() >= player.getHealth()) {
                ArmorStandEditor.getArmorStandEditor(player).giveHotbar(player);
                ArmorStandEditor.removeEditor(player);
            }
            //
        }
        //
    }

}
