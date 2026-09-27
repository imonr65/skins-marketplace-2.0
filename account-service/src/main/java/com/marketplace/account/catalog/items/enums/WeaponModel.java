package com.marketplace.account.catalog.items.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
public enum WeaponModel {

    // Pistols
    CZ75_AUTO("CZ75-Auto", ItemType.PISTOL),
    DESERT_EAGLE("Desert Eagle", ItemType.PISTOL),
    DUAL_BERETTAS("Dual Berettas", ItemType.PISTOL),
    FIVE_SEVEN("Five-SeveN", ItemType.PISTOL),
    GLOCK_18("Glock-18", ItemType.PISTOL),
    P2000("P2000", ItemType.PISTOL),
    P250("P250", ItemType.PISTOL),
    R8_REVOLVER("R8 Revolver", ItemType.PISTOL),
    TEC_9("TEC-9", ItemType.PISTOL),
    USP_S("USP-S", ItemType.PISTOL),

    // Rifles
    AK_47("AK-47", ItemType.RIFLE),
    AUG("AUG", ItemType.RIFLE),
    FAMAS("FAMAS", ItemType.RIFLE),
    GALIL_AR("Galil AR", ItemType.RIFLE),
    M4A1_S("M4A1-S", ItemType.RIFLE),
    M4A4("M4A4", ItemType.RIFLE),
    SG_553("SG 553", ItemType.RIFLE),

    // Sniper Rifles
    AWP("AWP", ItemType.SNIPER_RIFLE),
    G3SG1("G3SG1", ItemType.SNIPER_RIFLE),
    SCAR_20("SCAR-20", ItemType.SNIPER_RIFLE),
    SSG_08("SSG 08", ItemType.SNIPER_RIFLE),

    // SMGs
    MAC_10("MAC-10", ItemType.SMG),
    MP5_SD("MP5-SD", ItemType.SMG),
    MP7("MP7", ItemType.SMG),
    MP9("MP9", ItemType.SMG),
    P90("P90", ItemType.SMG),
    PP_BIZON("PP-Bizon", ItemType.SMG),
    UMP_45("UMP-45", ItemType.SMG),

    // Heavy
    M249("M249", ItemType.HEAVY),
    NEGEV("Negev", ItemType.HEAVY),

    // Shotguns
    MAG_7("MAG-7", ItemType.SHOTGUN),
    NOVA("Nova", ItemType.SHOTGUN),
    SAWED_OFF("Sawed-Off", ItemType.SHOTGUN),
    XM1014("XM1014", ItemType.SHOTGUN),

    // Knives
    BAYONET("Bayonet", ItemType.KNIFE),
    BOWIE_KNIFE("Bowie Knife", ItemType.KNIFE),
    BUTTERFLY_KNIFE("Butterfly Knife", ItemType.KNIFE),
    CLASSIC_KNIFE("Classic Knife", ItemType.KNIFE),
    FALCHION_KNIFE("Falchion Knife", ItemType.KNIFE),
    FLIP_KNIFE("Flip Knife", ItemType.KNIFE),
    GUT_KNIFE("Gut Knife", ItemType.KNIFE),
    HUNTSMAN_KNIFE("Huntsman Knife", ItemType.KNIFE),
    KARAMBIT("Karambit", ItemType.KNIFE),
    KUKRI_KNIFE("Kukri Knife", ItemType.KNIFE),
    M9_BAYONET("M9 Bayonet", ItemType.KNIFE),
    NAVAJA_KNIFE("Navaja Knife", ItemType.KNIFE),
    NOMAD_KNIFE("Nomad Knife", ItemType.KNIFE),
    PARACORD_KNIFE("Paracord Knife", ItemType.KNIFE),
    SHADOW_DAGGERS("Shadow Daggers", ItemType.KNIFE),
    SKELETON_KNIFE("Skeleton Knife", ItemType.KNIFE),
    STILETTO_KNIFE("Stiletto Knife", ItemType.KNIFE),
    SURVIVAL_KNIFE("Survival Knife", ItemType.KNIFE),
    TALON_KNIFE("Talon Knife", ItemType.KNIFE),
    URSUS_KNIFE("Ursus Knife", ItemType.KNIFE);

    private final String displayName;
    private final ItemType itemType;

    WeaponModel(String displayName, ItemType itemType) {
        this.displayName = displayName;
        this.itemType = itemType;
    }
}
