package de.lordjulixn.armorstandeditor.listener;

import de.lordjulixn.armorstandeditor.hotbars.HotbarAlignmentMenu;
import de.lordjulixn.armorstandeditor.hotbars.HotbarPositionMenu;
import de.lordjulixn.armorstandeditor.hotbars.HotbarAlignmentSegment;
import de.lordjulixn.armorstandeditor.hotbars.HotbarState;
import de.lordjulixn.armorstandeditor.inventorys.InventoryMenu;
import de.lordjulixn.armorstandeditor.inventorys.InventoryPosition;
import de.lordjulixn.armorstandeditor.languages.Language;
import de.lordjulixn.armorstandeditor.main.Files;
import de.lordjulixn.armorstandeditor.main.Main;
import de.lordjulixn.armorstandeditor.utils.ArmorStandEditor;
import de.lordjulixn.armorstandeditor.utils.InventoryManager;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.EulerAngle;

public class InteractListener implements Listener {

    /*
    ArmorStandEditor - @LordJulixn
    2022 - https://github.com/LordJulixn
     */

    private enum ClickType {

        LEFTCLICK, RIGHTCLICK

    }

    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        //
        Player player = event.getPlayer();
        //
        if(ArmorStandEditor.getArmorStandEditor(player) == null) return;
        ArmorStandEditor editor = ArmorStandEditor.getArmorStandEditor(player);
        //
        if(!editor.isInHotbar() || editor.getHotbarState() == null) return;
        event.setCancelled(true);
        //
        ItemStack item = event.getItem();
        if(item == null) return;
        if(!item.hasItemMeta()) return;
        if(!item.getItemMeta().hasDisplayName()) return;
        //
        if(editor.getHotbarState() == HotbarState.ALIGNMENTMENU) {
            //
            if(item.getItemMeta().getDisplayName().equals(HotbarAlignmentMenu.backToStepsText(Main.getLanguage()))) {
                //
                editor.giveHotbar(player);
                InventoryManager.openInventory(player, new InventoryPosition(player));
                //
            }
            if(item.getItemMeta().getDisplayName().equals(HotbarAlignmentMenu.closeText(Main.getLanguage()))) {
                //
                editor.giveHotbar(player);
                if(getClickType(event) == ClickType.LEFTCLICK) {
                    InventoryManager.openInventory(player, new InventoryMenu());
                    return;
                }
                if(getClickType(event) == ClickType.RIGHTCLICK) {
                    ArmorStandEditor.removeEditor(player);
                    return;
                }
                //
            }
            //
            if(item.getItemMeta().getDisplayName().equals(HotbarAlignmentMenu.headText(Main.getLanguage()))) {
                editor.saveHotbar(HotbarState.HEAD);
                return;
            }
            if(item.getItemMeta().getDisplayName().equals(HotbarAlignmentMenu.chestText(Main.getLanguage()))){
                editor.saveHotbar(HotbarState.CHEST);
                return;
            }
            if(item.getItemMeta().getDisplayName().equals(HotbarAlignmentMenu.leftArmText(Main.getLanguage()))) {
                editor.saveHotbar(HotbarState.LEFTARM);
                return;
            }
            if(item.getItemMeta().getDisplayName().equals(HotbarAlignmentMenu.rightArmText(Main.getLanguage()))) {
                editor.saveHotbar(HotbarState.RIGHTARM);
                return;
            }
            if(item.getItemMeta().getDisplayName().equals(HotbarAlignmentMenu.leftLegText(Main.getLanguage()))) {
                editor.saveHotbar(HotbarState.LEFTLEG);
                return;
            }
            if(item.getItemMeta().getDisplayName().equals(HotbarAlignmentMenu.rightLegText(Main.getLanguage()))) {
                editor.saveHotbar(HotbarState.RIGHTLEG);
                return;
            }
            //
        }
        if(editor.getHotbarState() == HotbarState.POSITIONMENU) {
            //
            if(item.getItemMeta().getDisplayName().equals(HotbarPositionMenu.backToStepsText(Main.getLanguage()))) {
                //
                editor.giveHotbar(player);
                InventoryManager.openInventory(player, new InventoryPosition(player));
                //
            }
            if(item.getItemMeta().getDisplayName().equals(HotbarPositionMenu.closeText(Main.getLanguage()))) {
                //
                editor.giveHotbar(player);
                if(getClickType(event) == ClickType.LEFTCLICK) {
                    InventoryManager.openInventory(player, new InventoryMenu());
                    return;
                }
                if(getClickType(event) == ClickType.RIGHTCLICK) {
                    ArmorStandEditor.removeEditor(player);
                    return;
                }
                //
            }
            if(item.getItemMeta().getLore() == null) return;
            double steps = editor.getSteps();
            if(item.getItemMeta().getLore().toString().equals("[§8Axis-X]")) {
                editor.getArmorStand().teleport(editor.getArmorStand().getLocation().add((getClickType(event) == ClickType.LEFTCLICK) ? steps : -steps, 0, 0));
                if(!Files.getConfig().getBoolean("ActionbarValues")) return;
                player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(actionbarText(Main.getLanguage(), editor.getArmorStand().getLocation().getX())));
                return;
            }
            if(item.getItemMeta().getLore().toString().equals("[§8Axis-Y]")) {
                editor.getArmorStand().teleport(editor.getArmorStand().getLocation().add(0, (getClickType(event) == ClickType.LEFTCLICK) ? steps : -steps, 0));
                if(!Files.getConfig().getBoolean("ActionbarValues")) return;
                player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(actionbarText(Main.getLanguage(), editor.getArmorStand().getLocation().getY())));
                return;
            }
            if(item.getItemMeta().getLore().toString().equals("[§8Axis-Z]")) {
                editor.getArmorStand().teleport(editor.getArmorStand().getLocation().add(0, 0, (getClickType(event) == ClickType.LEFTCLICK) ? steps : -steps));
                if(!Files.getConfig().getBoolean("ActionbarValues")) return;
                player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(actionbarText(Main.getLanguage(), editor.getArmorStand().getLocation().getZ())));
                return;
            }
            if(item.getItemMeta().getLore().toString().equals("[§8Axis-R]")) {
                double newValue = editor.getArmorStand().getLocation().getYaw();
                newValue = (getClickType(event) == ClickType.LEFTCLICK) ? newValue+steps : newValue-steps;
                editor.getArmorStand().setRotation((float) newValue, editor.getArmorStand().getLocation().getPitch());
                if(!Files.getConfig().getBoolean("ActionbarValues")) return;
                player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(actionbarText(Main.getLanguage(), editor.getArmorStand().getLocation().getYaw())));
                return;
            }
            //
        }
        //
        if(item.getItemMeta().getDisplayName().equals(HotbarAlignmentSegment.closeText(Main.getLanguage()))) {
            //
            if(getClickType(event) == ClickType.LEFTCLICK) {
                editor.saveHotbar(HotbarState.ALIGNMENTMENU);
                return;
            }
            if(getClickType(event) == ClickType.RIGHTCLICK) {
                editor.giveHotbar(player);
                ArmorStandEditor.removeEditor(player);
                return;
            }
            //
        }
        if(item.getItemMeta().getDisplayName().equals(HotbarAlignmentSegment.resetText(Main.getLanguage()))) {
            //
            resetSegment(editor.getArmorStand(), editor.getHotbarState());
            return;
            //
        }
        //
        if(item.getItemMeta().getLore() == null) return;
        ArmorStand armorStand = editor.getArmorStand();
        //
        if(item.getItemMeta().getLore().toString().equals("[§8Axis-X]")) {
            //
            double newValue = 0;
            //
            switch (editor.getHotbarState()) {
                case HEAD -> {
                    newValue = Math.toDegrees(armorStand.getHeadPose().getX());
                    newValue = (getClickType(event) == ClickType.LEFTCLICK) ? newValue + editor.getSteps() : newValue - editor.getSteps();
                    armorStand.setHeadPose(armorStand.getHeadPose().setX(Math.toRadians(newValue)));
                }
                case CHEST -> {
                    newValue = Math.toDegrees(armorStand.getBodyPose().getX());
                    newValue = (getClickType(event) == ClickType.LEFTCLICK) ? newValue + editor.getSteps() : newValue - editor.getSteps();
                    armorStand.setBodyPose(armorStand.getBodyPose().setX(Math.toRadians(newValue)));
                }
                case LEFTARM -> {
                    newValue = Math.toDegrees(armorStand.getLeftArmPose().getX());
                    newValue = (getClickType(event) == ClickType.LEFTCLICK) ? newValue + editor.getSteps() : newValue - editor.getSteps();
                    armorStand.setLeftArmPose(armorStand.getLeftArmPose().setX(Math.toRadians(newValue)));
                }
                case RIGHTARM -> {
                    newValue = Math.toDegrees(armorStand.getRightArmPose().getX());
                    newValue = (getClickType(event) == ClickType.LEFTCLICK) ? newValue + editor.getSteps() : newValue - editor.getSteps();
                    armorStand.setRightArmPose(armorStand.getRightArmPose().setX(Math.toRadians(newValue)));
                }
                case LEFTLEG -> {
                    newValue = Math.toDegrees(armorStand.getLeftLegPose().getX());
                    newValue = (getClickType(event) == ClickType.LEFTCLICK) ? newValue + editor.getSteps() : newValue - editor.getSteps();
                    armorStand.setLeftLegPose(armorStand.getLeftLegPose().setX(Math.toRadians(newValue)));
                }
                case RIGHTLEG -> {
                    newValue = Math.toDegrees(armorStand.getRightLegPose().getX());
                    newValue = (getClickType(event) == ClickType.LEFTCLICK) ? newValue + editor.getSteps() : newValue - editor.getSteps();
                    armorStand.setRightLegPose(armorStand.getRightLegPose().setX(Math.toRadians(newValue)));
                }
            }
            //
            if(!Files.getConfig().getBoolean("ActionbarValues")) return;
            //
            newValue = (Math.ceil((newValue*100)))/100;
            player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(actionbarText(Main.getLanguage(), newValue)));
            return;
            //
        }
        if(item.getItemMeta().getLore().toString().equals("[§8Axis-Y]")) {
            //
            double newValue = 0;
            //
            switch (editor.getHotbarState()) {
                case HEAD -> {
                    newValue = Math.toDegrees(armorStand.getHeadPose().getY());
                    newValue = (getClickType(event) == ClickType.LEFTCLICK) ? newValue + editor.getSteps() : newValue - editor.getSteps();
                    armorStand.setHeadPose(armorStand.getHeadPose().setY(Math.toRadians(newValue)));
                }
                case CHEST -> {
                    newValue = Math.toDegrees(armorStand.getBodyPose().getY());
                    newValue = (getClickType(event) == ClickType.LEFTCLICK) ? newValue + editor.getSteps() : newValue - editor.getSteps();
                    armorStand.setBodyPose(armorStand.getBodyPose().setY(Math.toRadians(newValue)));
                }
                case LEFTARM -> {
                    newValue = Math.toDegrees(armorStand.getLeftArmPose().getY());
                    newValue = (getClickType(event) == ClickType.LEFTCLICK) ? newValue + editor.getSteps() : newValue - editor.getSteps();
                    armorStand.setLeftArmPose(armorStand.getLeftArmPose().setY(Math.toRadians(newValue)));
                }
                case RIGHTARM -> {
                    newValue = Math.toDegrees(armorStand.getRightArmPose().getY());
                    newValue = (getClickType(event) == ClickType.LEFTCLICK) ? newValue + editor.getSteps() : newValue - editor.getSteps();
                    armorStand.setRightArmPose(armorStand.getRightArmPose().setY(Math.toRadians(newValue)));
                }
                case LEFTLEG -> {
                    newValue = Math.toDegrees(armorStand.getLeftLegPose().getY());
                    newValue = (getClickType(event) == ClickType.LEFTCLICK) ? newValue + editor.getSteps() : newValue - editor.getSteps();
                    armorStand.setLeftLegPose(armorStand.getLeftLegPose().setY(Math.toRadians(newValue)));
                }
                case RIGHTLEG -> {
                    newValue = Math.toDegrees(armorStand.getRightLegPose().getY());
                    newValue = (getClickType(event) == ClickType.LEFTCLICK) ? newValue + editor.getSteps() : newValue - editor.getSteps();
                    armorStand.setRightLegPose(armorStand.getRightLegPose().setY(Math.toRadians(newValue)));
                }
            }
            //
            if(!Files.getConfig().getBoolean("ActionbarValues")) return;
            //
            newValue = (Math.ceil((newValue*100)))/100;
            player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(actionbarText(Main.getLanguage(), newValue)));
            return;
            //
        }
        if(item.getItemMeta().getLore().toString().equals("[§8Axis-Z]")) {
            //
            double newValue = 0;
            //
            switch (editor.getHotbarState()) {
                case HEAD -> {
                    newValue = Math.toDegrees(armorStand.getHeadPose().getZ());
                    newValue = (getClickType(event) == ClickType.LEFTCLICK) ? newValue + editor.getSteps() : newValue - editor.getSteps();
                    armorStand.setHeadPose(armorStand.getHeadPose().setZ(Math.toRadians(newValue)));
                }
                case CHEST -> {
                    newValue = Math.toDegrees(armorStand.getBodyPose().getZ());
                    newValue = (getClickType(event) == ClickType.LEFTCLICK) ? newValue + editor.getSteps() : newValue - editor.getSteps();
                    armorStand.setBodyPose(armorStand.getBodyPose().setZ(Math.toRadians(newValue)));
                }
                case LEFTARM -> {
                    newValue = Math.toDegrees(armorStand.getLeftArmPose().getZ());
                    newValue = (getClickType(event) == ClickType.LEFTCLICK) ? newValue + editor.getSteps() : newValue - editor.getSteps();
                    armorStand.setLeftArmPose(armorStand.getLeftArmPose().setZ(Math.toRadians(newValue)));
                }
                case RIGHTARM -> {
                    newValue = Math.toDegrees(armorStand.getRightArmPose().getZ());
                    newValue = (getClickType(event) == ClickType.LEFTCLICK) ? newValue + editor.getSteps() : newValue - editor.getSteps();
                    armorStand.setRightArmPose(armorStand.getRightArmPose().setZ(Math.toRadians(newValue)));
                }
                case LEFTLEG -> {
                    newValue = Math.toDegrees(armorStand.getLeftLegPose().getZ());
                    newValue = (getClickType(event) == ClickType.LEFTCLICK) ? newValue + editor.getSteps() : newValue - editor.getSteps();
                    armorStand.setLeftLegPose(armorStand.getLeftLegPose().setZ(Math.toRadians(newValue)));
                }
                case RIGHTLEG -> {
                    newValue = Math.toDegrees(armorStand.getRightLegPose().getZ());
                    newValue = (getClickType(event) == ClickType.LEFTCLICK) ? newValue + editor.getSteps() : newValue - editor.getSteps();
                    armorStand.setRightLegPose(armorStand.getRightLegPose().setZ(Math.toRadians(newValue)));
                }
            }
            //
            if(!Files.getConfig().getBoolean("ActionbarValues")) return;
            //
            newValue = (Math.ceil((newValue*100)))/100;
            player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(actionbarText(Main.getLanguage(), newValue)));
            //
        }
        //
    }

    private ClickType getClickType(PlayerInteractEvent event) {
        //
        if(event.getAction() == Action.LEFT_CLICK_AIR || event.getAction() == Action.LEFT_CLICK_BLOCK) return ClickType.LEFTCLICK;
        if(event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) return ClickType.RIGHTCLICK;
        return null;
        //
    }
    private void resetSegment(ArmorStand armorStand, HotbarState state) {
        //
        switch(state) {
            case HEAD -> armorStand.setHeadPose(new EulerAngle(0, 0, 0));
            case CHEST -> armorStand.setBodyPose(new EulerAngle(0, 0, 0));
            case LEFTARM -> armorStand.setLeftArmPose(new EulerAngle(0, 0, 0));
            case RIGHTARM -> armorStand.setRightArmPose(new EulerAngle(0, 0, 0));
            case LEFTLEG -> armorStand.setLeftLegPose(new EulerAngle(0, 0, 0));
            case RIGHTLEG -> armorStand.setRightLegPose(new EulerAngle(0, 0, 0));
        }
        //
    }
    public static String actionbarText(Language language, double value) {
        //
        if(language == Language.DEUTSCH) return "§7Wert§8: §e"+value;
        return "§7Value§8: §e"+value;
        //
    }

}
