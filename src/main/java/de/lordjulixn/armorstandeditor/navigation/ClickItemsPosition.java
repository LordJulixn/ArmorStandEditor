package de.lordjulixn.armorstandeditor.navigation;

import de.lordjulixn.armorstandeditor.design.Design;
import de.lordjulixn.armorstandeditor.hotbars.HotbarState;
import de.lordjulixn.armorstandeditor.inventorys.InventoryMenu;
import de.lordjulixn.armorstandeditor.inventorys.InventoryPosition;
import de.lordjulixn.armorstandeditor.main.Main;
import de.lordjulixn.armorstandeditor.utils.ArmorStandEditor;
import de.lordjulixn.armorstandeditor.utils.InventoryManager;
import de.lordjulixn.armorstandeditor.utils.ItemBuilder;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class ClickItemsPosition {

    /*
    ArmorStandEditor - @LordJulixn
    2022 - https://github.com/LordJulixn
     */

    public void execute(Player player, InventoryClickEvent event) {
        //
        event.setCancelled(true);
        //
        ItemStack item = event.getCurrentItem();
        if(!ClickItems.isPluginItem(item)) return;
        if(ArmorStandEditor.getArmorStandEditor(player) == null) return;
        //
        ArmorStandEditor editor = ArmorStandEditor.getArmorStandEditor(player);
        if(editor == null) return;
        //
        if(item.getItemMeta().getDisplayName().equals(InventoryPosition.alignmentText(Main.getLanguage()))) {
            //
            player.closeInventory();
            editor.saveHotbar(HotbarState.ALIGNMENTMENU);
            //
        }
        if(item.getItemMeta().getDisplayName().equals(InventoryPosition.positionText(Main.getLanguage()))) {
            //
            player.closeInventory();
            editor.saveHotbar(HotbarState.POSITIONMENU);
            //
        }
        //
        if(item.getItemMeta().getDisplayName().equals(InventoryPosition.add1())) {
            editor.addSteps(1);
            updateStepsItem(player, event);
        }
        if(item.getItemMeta().getDisplayName().equals(InventoryPosition.add01())) {
            editor.addSteps(0.1);
            updateStepsItem(player, event);
        }
        if(item.getItemMeta().getDisplayName().equals(InventoryPosition.add001())) {
           editor.addSteps(0.01);
            updateStepsItem(player, event);
        }
        if(item.getItemMeta().getDisplayName().equals(InventoryPosition.minus1())) {
            if(editor.getSteps() <= 1) {
                editor.setSteps(0.01);
                updateStepsItem(player, event);
                return;
            }
            editor.addSteps(-1);
            updateStepsItem(player, event);
        }
        if(item.getItemMeta().getDisplayName().equals(InventoryPosition.minus01())) {
            if(editor.getSteps() <= 0.1) {
                editor.setSteps(0.01);
                updateStepsItem(player, event);
                return;
            }
            editor.addSteps(-0.1);
            updateStepsItem(player, event);
        }
        if(item.getItemMeta().getDisplayName().equals(InventoryPosition.minus001())) {
            if(editor.getSteps() <= 0.01) return;
            editor.addSteps(-0.01);
            updateStepsItem(player, event);
        }
        //
        if(item.getItemMeta().getDisplayName().equals(Design.backText(Main.getLanguage()))) {
            InventoryManager.openInventory(player, new InventoryMenu());
            editor.resetSteps();
            return;
        }
        //
    }
    private void updateStepsItem(Player player, InventoryClickEvent event) {
        //
        ItemStack item = event.getInventory().getItem(31);
        if(item == null) return;
        ArmorStandEditor editor = ArmorStandEditor.getArmorStandEditor(player);
        item.setItemMeta(new ItemBuilder(item).setLore(InventoryPosition.loreSpacerText(Main.getLanguage()), "§e"+editor.getSteps()).build().getItemMeta());
        //
    }

}
