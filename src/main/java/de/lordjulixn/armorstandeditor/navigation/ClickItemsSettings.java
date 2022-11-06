package de.lordjulixn.armorstandeditor.navigation;

import de.lordjulixn.armorstandeditor.design.Design;
import de.lordjulixn.armorstandeditor.inventorys.InventoryMenu;
import de.lordjulixn.armorstandeditor.inventorys.InventorySettingsN;
import de.lordjulixn.armorstandeditor.inventorys.InventorySettingsY;
import de.lordjulixn.armorstandeditor.languages.Messages;
import de.lordjulixn.armorstandeditor.main.Main;
import de.lordjulixn.armorstandeditor.utils.ArmorStandEditor;
import de.lordjulixn.armorstandeditor.utils.InventoryManager;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ClickItemsSettings {

    /*
    ArmorStandEditor - @LordJulixn
    2022 - https://github.com/LordJulixn
     */

    public void execute(Player player, InventoryClickEvent event) {
        //
        ItemStack item = event.getCurrentItem();
        if(event.getSlot() == 40) {
            return;
        }
        event.setCancelled(true);
        //
        if(!ClickItems.isPluginItem(item)) return;
        //
        ArmorStand armorStand = ArmorStandEditor.getArmorStandEditor(player).getArmorStand();
        if(armorStand == null || armorStand.isDead()) return;
        //
        if(item.getItemMeta().getDisplayName().equals(InventorySettingsN.nameVisible(Main.getLanguage()))) {
            armorStand.setVisible(!armorStand.isVisible());
            updateItem(item, armorStand.isVisible());
            return;
        }
        if(item.getItemMeta().getDisplayName().equals(InventorySettingsN.nameInvulnerable(Main.getLanguage()))) {
            armorStand.setInvulnerable(!armorStand.isInvulnerable());
            updateItem(item, armorStand.isInvulnerable());
            return;
        }
        if(item.getItemMeta().getDisplayName().equals(InventorySettingsN.nameBasePlate(Main.getLanguage()))) {
            armorStand.setBasePlate(!armorStand.hasBasePlate());
            updateItem(item, armorStand.hasBasePlate());
            return;
        }
        if(item.getItemMeta().getDisplayName().equals(InventorySettingsN.nameGravity(Main.getLanguage()))) {
            armorStand.setGravity(!armorStand.hasGravity());
            updateItem(item, armorStand.hasGravity());
            return;
        }
        if(item.getItemMeta().getDisplayName().equals(InventorySettingsN.nameArms(Main.getLanguage()))) {
            armorStand.setArms(!armorStand.hasArms());
            updateItem(item, armorStand.hasArms());
            return;
        }
        if(item.getItemMeta().getDisplayName().equals(InventorySettingsN.nameSmall(Main.getLanguage()))) {
            armorStand.setSmall(!armorStand.isSmall());
            updateItem(item, armorStand.isSmall());
            return;
        }
        if(item.getItemMeta().getDisplayName().equals(InventorySettingsN.nameCustomName(Main.getLanguage()))) {
            armorStand.setCustomNameVisible(!armorStand.isCustomNameVisible());
            //
            if(armorStand.isCustomNameVisible()) InventoryManager.openInventory(player, new InventorySettingsY(armorStand));
            else InventoryManager.openInventory(player, new InventorySettingsN(armorStand));
            //
            return;
        }
        if(item.getItemMeta().getDisplayName().equals(Design.backText(Main.getLanguage()))) {
            InventoryManager.openInventory(player, new InventoryMenu());
            return;
        }
        if(item.getItemMeta().getDisplayName().equals(InventorySettingsY.customNameText(Main.getLanguage()))) {
            //
            ItemStack paper = event.getInventory().getItem(40);
            if(paper == null) {
                //
                armorStand.setCustomName("Armor Stand");
                player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 0.1F, 1);
                return;
                //
            }
            if(!paper.hasItemMeta() || paper.getType() != Material.PAPER) {
                //
                player.sendMessage(Messages.wrongCustomNameItem(Main.getLanguage()));
                return;
                //
            }
            //
            armorStand.setCustomName(paper.getItemMeta().getDisplayName().replaceAll("&", "§"));
            event.getInventory().setItem(40, null);
            player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 0.1F, 1);
            return;
            //
        }
        //
    }
    private void updateItem(ItemStack item, boolean newValue) {
        //
        ItemMeta meta = item.getItemMeta();
        if(newValue) meta.setLore(Design.toggleLoreTrue(Main.getLanguage()));
        else meta.setLore(Design.toggleLoreFalse(Main.getLanguage()));
        item.setItemMeta(meta);
        //
    }

}
