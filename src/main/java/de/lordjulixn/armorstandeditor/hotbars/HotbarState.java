package de.lordjulixn.armorstandeditor.hotbars;

import org.bukkit.entity.Player;

public enum HotbarState {

    /*
    ArmorStandEditor - @LordJulixn
    2022 - https://github.com/LordJulixn
     */

    POSITIONMENU(new HotbarPositionMenu()),
    ALIGNMENTMENU(new HotbarAlignmentMenu()),
    HEAD(new HotbarAlignmentSegment()),
    CHEST(new HotbarAlignmentSegment()),
    LEFTARM(new HotbarAlignmentSegment()),
    RIGHTARM(new HotbarAlignmentSegment()),
    LEFTLEG(new HotbarAlignmentSegment()),
    RIGHTLEG(new HotbarAlignmentSegment());

    //
    private final HotbarOverlay hotbar;
    //
    HotbarState(HotbarOverlay hotbar) {
        //
        this.hotbar = hotbar;
        //
    }
    public void setHotbar(Player player) {
        //
        for(int i = 0; i < 9; i++) player.getInventory().setItem(i, null);
        hotbar.setHotbar(player);
        //
    }
    //

}
