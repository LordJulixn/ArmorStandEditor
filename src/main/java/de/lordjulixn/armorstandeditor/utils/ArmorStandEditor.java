package de.lordjulixn.armorstandeditor.utils;

import de.lordjulixn.armorstandeditor.hotbars.HotbarState;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.HashMap;

public class ArmorStandEditor {

    /*
    ArmorStandEditor - @LordJulixn
    2022 - https://github.com/LordJulixn
     */

    private static HashMap<Player, ArmorStandEditor> editors = new HashMap<>();

    //
    private final Player player;
    private ArmorStand armorStand;
    private double steps;
    private ItemStack[] hotbarItemsSave;
    private boolean isInHotbar;
    private HotbarState hotbarState;
    //
    public ArmorStandEditor(Player player, ArmorStand armorStand) {
        //
        this.player = player;
        this.armorStand = armorStand;
        editors.remove(player);
        editors.put(player, this);
        this.steps = 1;
        hotbarItemsSave = new ItemStack[9];
        isInHotbar = false;
        hotbarState = null;
        //
    }
    public Player getPlayer() {
        //
        return player;
        //
    }
    public ArmorStand getArmorStand() {
        //
        return armorStand;
        //
    }
    //
    public double getSteps() {
        //
        return steps;
        //
    }
    public void setSteps(double newSteps) {
        //
        this.steps = newSteps;
        //
    }
    public void addSteps(double add) {
        //
        double newSteps = (steps+add)*100;
        double steps = (Math.ceil(newSteps))/100;
        this.steps = steps;
        //
    }
    public void resetSteps() {
        //
        this.steps = 1;
        //
    }
    //
    public void saveHotbar(HotbarState state) {
        //
        isInHotbar = true;
        //
        if(hotbarState != null) {
            for(int i = 0; i < 9; i++) player.getInventory().setItem(i, null);
            state.setHotbar(player);
            hotbarState = state;
            return;
        }
        //
        hotbarState = state;
        //
        for(int i = 0; i < 9; i++) {
            //
            if(player.getInventory().getItem(i) != null) {
                hotbarItemsSave[i] = player.getInventory().getItem(i);
                player.getInventory().setItem(i, null);
            }
            //
        }
        state.setHotbar(player);
        //
    }
    public void giveHotbar(Player player) {
        //
        isInHotbar = false;
        hotbarState = null;
        //
        for(int i = 0; i < 9; i++) {
            player.getInventory().setItem(i, null);
            if(hotbarItemsSave[i] != null) {
                player.getInventory().setItem(i, hotbarItemsSave[i]);
            }
        }
        hotbarItemsSave = new ItemStack[9];
        //
    }
    public void setInHotbar(boolean state) {
        //
        this.isInHotbar = state;
        //
    }
    public boolean isInHotbar() {
        //
        return isInHotbar;
        //
    }
    public void setHotbarState(HotbarState newState) {
        //
        this.hotbarState = newState;
        //
    }
    public HotbarState getHotbarState() {
        //
        return hotbarState;
        //
    }
    //

    //
    public static void removeEditor(Player player) {
        //
        editors.remove(player);
        //
    }
    public static ArmorStandEditor getArmorStandEditor(Player player) {
        //
        return editors.getOrDefault(player, null);
        //
    }
    public static ArrayList<ArmorStandEditor> getAllEditors() {
        //
        ArrayList<ArmorStandEditor> editorsList = new ArrayList<>();
        editorsList.addAll(editors.values());
        return editorsList;
        //
    }
    public static boolean armorStandInUse(ArmorStand stand) {
        //
        for(ArmorStandEditor editor : getAllEditors()) {
            if(editor.getArmorStand() == stand) return true;
        }
        return false;
        //
    }
    //

}
