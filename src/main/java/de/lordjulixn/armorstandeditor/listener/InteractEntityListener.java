package de.lordjulixn.armorstandeditor.listener;

import de.lordjulixn.armorstandeditor.inventorys.InventoryMenu;
import de.lordjulixn.armorstandeditor.languages.Messages;
import de.lordjulixn.armorstandeditor.main.Files;
import de.lordjulixn.armorstandeditor.main.Main;
import de.lordjulixn.armorstandeditor.utils.ArmorStandEditor;
import de.lordjulixn.armorstandeditor.utils.InventoryManager;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.inventory.ItemStack;

public class InteractEntityListener implements Listener {

    /*
    ArmorStandEditor - @LordJulixn
    2022 - https://github.com/LordJulixn
     */

    @EventHandler
    public void onInteract(PlayerInteractAtEntityEvent event) {
        //
        Player player = event.getPlayer();
        if(ArmorStandEditor.getArmorStandEditor(player) != null) {
            if(ArmorStandEditor.getArmorStandEditor(player).isInHotbar()) {
                event.setCancelled(true);
                return;
            }
        }
        //
        if(event.getRightClicked() instanceof ArmorStand) {
            ArmorStand stand = (ArmorStand) event.getRightClicked();
            ItemStack item = player.getItemInHand();
            if(ArmorStandEditor.armorStandInUse(stand)) {
                event.setCancelled(true);
                player.sendMessage(Messages.armorStandInUseInteractMessage(Main.getLanguage()));
            }
            //
            Material requiredMaterial = Material.STONE;
            for(Material materials : Material.values()) if(Files.getConfig().getString("Item.Type").equalsIgnoreCase(materials.toString())) requiredMaterial = materials;
            if(item.getType() != requiredMaterial) return;
            if(Files.getConfig().getBoolean("Item.RequireDisplayname") && !item.hasItemMeta()) return;
            if(Files.getConfig().getBoolean("Item.RequireDisplayname") && !item.getItemMeta().getDisplayName().equals(Files.getConfig().getString("Item.Displayname").replace("&", "§")))
                return;
            if(Files.getConfig().getBoolean("Item.RequireLore") && !item.hasItemMeta()) return;
            if(Files.getConfig().getBoolean("Item.RequireLore") && item.getItemMeta().getLore() == null) return;
            if(Files.getConfig().getBoolean("Item.RequireLore") && !item.getItemMeta().getLore().toString().equals("["+Files.getConfig().getString("Item.Lore").replaceAll("&", "§")+"]")) return;
            if(Files.getConfig().getBoolean("RequirePermission") && !player.hasPermission(Files.getConfig().getString("PermissionUsage"))) {
                player.sendMessage(Messages.noPermissionsMessage(Main.getLanguage()));
                return;
            }
            //
            if(!ArmorStandEditor.armorStandInUse(stand)) {
                //
                player.playSound(player.getLocation(), Sound.UI_BUTTON_CLICK, 1, 1);
                //
                new ArmorStandEditor(player, stand);
                InventoryManager.openInventory(player, new InventoryMenu());
                event.setCancelled(true);
                //
                if(!Files.getConfig().getBoolean("Item.SingleUse")) return;
                //
                if(item.getAmount() == 1) {
                    item.setAmount(0);
                    return;
                }
                item.setAmount((item.getAmount()-1));
                //
            } else player.sendMessage(Messages.armorStandInUseMessage(Main.getLanguage()));
        }
        //
    }

}
