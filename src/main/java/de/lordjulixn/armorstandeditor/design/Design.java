package de.lordjulixn.armorstandeditor.design;

import de.lordjulixn.armorstandeditor.languages.Language;

import java.util.ArrayList;

public class Design {

    /*
    ArmorStandEditor - @LordJulixn
    2022 - https://github.com/LordJulixn
     */

    public static String lorePlaceHolder = "§8§m----------";

    public static String texturePlus = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0" +
            "L3RleHR1cmUvNWZmMzE0MzFkNjQ1ODdmZjZlZjk4YzA2NzU4MTA2ODFmOGMxM2JmOTZmNTFkOWNiMDdlZDc4NTJiMmZmZDEifX19";
    public static String textureMinus = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV" +
            "0L3RleHR1cmUvNGU0YjhiOGQyMzYyYzg2NGUwNjIzMDE0ODdkOTRkMzI3MmE2YjU3MGFmYmY4MGMyYzViMTQ4Yzk1NDU3OWQ0NiJ9fX0=";
    public static String textureAxisX = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV" +
            "0L3RleHR1cmUvNWE2Nzg3YmEzMjU2NGU3YzJmM2EwY2U2NDQ5OGVjYmIyM2I4OTg0NWU1YTY2YjVjZWM3NzM2ZjcyOWVkMzcifX19";
    public static String textureAxisY = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubm" +
            "V0L3RleHR1cmUvYzUyZmIzODhlMzMyMTJhMjQ3OGI1ZTE1YTk2ZjI3YWNhNmM2MmFjNzE5ZTFlNWY4N2ExY2YwZGU3YjE1ZTkxOCJ9fX0=";
    public static String textureAxisZ = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0" +
            "L3RleHR1cmUvOTA1ODJiOWI1ZDk3OTc0YjExNDYxZDYzZWNlZDg1ZjQzOGEzZWVmNWRjMzI3OWY5YzQ3ZTFlMzhlYTU0YWU4ZCJ9fX0=";
    public static String textureAxisR = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0" +
            "L3RleHR1cmUvYTVjZWQ5OTMxYWNlMjNhZmMzNTEzNzEzNzliZjA1YzYzNWFkMTg2OTQzYmMxMzY0NzRlNGU1MTU2YzRjMzcifX19";

    //
    public static String backText(Language language) {
        //
        if(language == Language.DEUTSCH) return "§cZurück ➦";
        return "§cBack ➦";
        //
    }
    //
    public static ArrayList<String> toggleLoreTrue(Language language) {
        //
        ArrayList<String> lore = new ArrayList<>();
        lore.add(lorePlaceHolder);
        if(language == Language.DEUTSCH) {
            lore.add("§7➡ §aAktiviert");
            lore.add("   §8Deaktiviert");
            return lore;
        }
        lore.add("§7➡ §aEnabled");
        lore.add("   §8Disabled");
        return lore;
        //
    }
    public static ArrayList<String> toggleLoreFalse(Language language) {
        //
        ArrayList<String> lore = new ArrayList<>();
        lore.add(lorePlaceHolder);
        if(language == Language.DEUTSCH) {
            lore.add("   §8Aktiviert");
            lore.add("§7➡ §cDeaktiviert");
            return lore;
        }
        lore.add("   §8Enabled");
        lore.add("§7➡ §cDisabled");
        return lore;
        //
    }
    //


}
