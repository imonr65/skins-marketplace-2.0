package com.marketplace.catalog.models.items.enums;

import lombok.Getter;

@Getter
public enum SkinModel {

    ZEUS_X27("Zeus x27", ItemCategory.EQUIPMENT),

    // Pistols
    CZ75_AUTO("CZ75-Auto", ItemCategory.PISTOLS),
    DESERT_EAGLE("Desert Eagle", ItemCategory.PISTOLS),
    DUAL_BERETTAS("Dual Berettas", ItemCategory.PISTOLS),
    FIVE_SEVEN("Five-SeveN", ItemCategory.PISTOLS),
    GLOCK_18("Glock-18", ItemCategory.PISTOLS),
    P2000("P2000", ItemCategory.PISTOLS),
    P250("P250", ItemCategory.PISTOLS),
    R8_REVOLVER("R8 Revolver", ItemCategory.PISTOLS),
    TEC_9("TEC-9", ItemCategory.PISTOLS),
    USP_S("USP-S", ItemCategory.PISTOLS),

    // Rifles
    AK_47("AK-47", ItemCategory.RIFLES),
    AUG("AUG", ItemCategory.RIFLES),
    FAMAS("FAMAS", ItemCategory.RIFLES),
    GALIL_AR("Galil AR", ItemCategory.RIFLES),
    M4A1_S("M4A1-S", ItemCategory.RIFLES),
    M4A4("M4A4", ItemCategory.RIFLES),
    SG_553("SG 553", ItemCategory.RIFLES),

    // Sniper Rifles
    AWP("AWP", ItemCategory.SNIPER_RIFLE),
    G3SG1("G3SG1", ItemCategory.SNIPER_RIFLE),
    SCAR_20("SCAR-20", ItemCategory.SNIPER_RIFLE),
    SSG_08("SSG 08", ItemCategory.SNIPER_RIFLE),

    // SMGs
    MAC_10("MAC-10", ItemCategory.SMGS),
    MP5_SD("MP5-SD", ItemCategory.SMGS),
    MP7("MP7", ItemCategory.SMGS),
    MP9("MP9", ItemCategory.SMGS),
    P90("P90", ItemCategory.SMGS),
    PP_BIZON("PP-Bizon", ItemCategory.SMGS),
    UMP_45("UMP-45", ItemCategory.SMGS),

    // Heavy
    M249("M249", ItemCategory.HEAVY),
    NEGEV("Negev", ItemCategory.HEAVY),

    // Shotguns
    MAG_7("MAG-7", ItemCategory.SHOTGUN),
    NOVA("Nova", ItemCategory.SHOTGUN),
    SAWED_OFF("Sawed-Off", ItemCategory.SHOTGUN),
    XM1014("XM1014", ItemCategory.SHOTGUN),

    // Knives
    BAYONET("Bayonet", ItemCategory.KNIVES),
    BOWIE_KNIFE("Bowie Knife", ItemCategory.KNIVES),
    BUTTERFLY_KNIFE("Butterfly Knife", ItemCategory.KNIVES),
    CLASSIC_KNIFE("Classic Knife", ItemCategory.KNIVES),
    FALCHION_KNIFE("Falchion Knife", ItemCategory.KNIVES),
    FLIP_KNIFE("Flip Knife", ItemCategory.KNIVES),
    GUT_KNIFE("Gut Knife", ItemCategory.KNIVES),
    HUNTSMAN_KNIFE("Huntsman Knife", ItemCategory.KNIVES),
    KARAMBIT("Karambit", ItemCategory.KNIVES),
    KUKRI_KNIFE("Kukri Knife", ItemCategory.KNIVES),
    M9_BAYONET("M9 Bayonet", ItemCategory.KNIVES),
    NAVAJA_KNIFE("Navaja Knife", ItemCategory.KNIVES),
    NOMAD_KNIFE("Nomad Knife", ItemCategory.KNIVES),
    PARACORD_KNIFE("Paracord Knife", ItemCategory.KNIVES),
    SHADOW_DAGGERS("Shadow Daggers", ItemCategory.KNIVES),
    SKELETON_KNIFE("Skeleton Knife", ItemCategory.KNIVES),
    STILETTO_KNIFE("Stiletto Knife", ItemCategory.KNIVES),
    SURVIVAL_KNIFE("Survival Knife", ItemCategory.KNIVES),
    TALON_KNIFE("Talon Knife", ItemCategory.KNIVES),
    URSUS_KNIFE("Ursus Knife", ItemCategory.KNIVES),

    BLOODHOUND_GLOVES("Bloodhound Gloves", ItemCategory.GLOVES),
    BROKEN_FANG_GLOVES("Broken Fang Gloves", ItemCategory.GLOVES),
    DRIVER_GLOVES("Driver Gloves", ItemCategory.GLOVES),
    HAND_WRAPS("Hand Wraps", ItemCategory.GLOVES),
    HYDRA_GLOVES("Hydra Gloves", ItemCategory.GLOVES),
    MOTO_GLOVES("Moto Gloves", ItemCategory.GLOVES),
    SPECIALIST_GLOVES("Specialist Gloves", ItemCategory.GLOVES),
    SPORT_GLOVES("Sport Gloves", ItemCategory.GLOVES);

    private final String displayName;
    private final ItemCategory itemCategory;

    SkinModel(String displayName, ItemCategory itemCategory) {
        this.displayName = displayName;
        this.itemCategory = itemCategory;
    }
}
