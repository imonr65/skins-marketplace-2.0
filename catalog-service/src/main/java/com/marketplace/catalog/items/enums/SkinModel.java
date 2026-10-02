package com.marketplace.catalog.items.enums;

import com.marketplace.account.catalog.models.items.enums.rarities.RarityScope;
import lombok.Getter;

@Getter
public enum SkinModel {

    // Pistols
    CZ75_AUTO("CZ75-Auto", ItemCategory.PISTOL),
    DESERT_EAGLE("Desert Eagle", ItemCategory.PISTOL),
    DUAL_BERETTAS("Dual Berettas", ItemCategory.PISTOL),
    FIVE_SEVEN("Five-SeveN", ItemCategory.PISTOL),
    GLOCK_18("Glock-18", ItemCategory.PISTOL),
    P2000("P2000", ItemCategory.PISTOL),
    P250("P250", ItemCategory.PISTOL),
    R8_REVOLVER("R8 Revolver", ItemCategory.PISTOL),
    TEC_9("TEC-9", ItemCategory.PISTOL),
    USP_S("USP-S", ItemCategory.PISTOL),

    // Rifles
    AK_47("AK-47", ItemCategory.RIFLE),
    AUG("AUG", ItemCategory.RIFLE),
    FAMAS("FAMAS", ItemCategory.RIFLE),
    GALIL_AR("Galil AR", ItemCategory.RIFLE),
    M4A1_S("M4A1-S", ItemCategory.RIFLE),
    M4A4("M4A4", ItemCategory.RIFLE),
    SG_553("SG 553", ItemCategory.RIFLE),

    // Sniper Rifles
    AWP("AWP", ItemCategory.SNIPER_RIFLE),
    G3SG1("G3SG1", ItemCategory.SNIPER_RIFLE),
    SCAR_20("SCAR-20", ItemCategory.SNIPER_RIFLE),
    SSG_08("SSG 08", ItemCategory.SNIPER_RIFLE),

    // SMGs
    MAC_10("MAC-10", ItemCategory.SMG),
    MP5_SD("MP5-SD", ItemCategory.SMG),
    MP7("MP7", ItemCategory.SMG),
    MP9("MP9", ItemCategory.SMG),
    P90("P90", ItemCategory.SMG),
    PP_BIZON("PP-Bizon", ItemCategory.SMG),
    UMP_45("UMP-45", ItemCategory.SMG),

    // Heavy
    M249("M249", ItemCategory.HEAVY),
    NEGEV("Negev", ItemCategory.HEAVY),

    // Shotguns
    MAG_7("MAG-7", ItemCategory.SHOTGUN),
    NOVA("Nova", ItemCategory.SHOTGUN),
    SAWED_OFF("Sawed-Off", ItemCategory.SHOTGUN),
    XM1014("XM1014", ItemCategory.SHOTGUN),

    // Knives
    BAYONET("Bayonet", ItemCategory.KNIFE),
    BOWIE_KNIFE("Bowie Knife", ItemCategory.KNIFE),
    BUTTERFLY_KNIFE("Butterfly Knife", ItemCategory.KNIFE),
    CLASSIC_KNIFE("Classic Knife", ItemCategory.KNIFE),
    FALCHION_KNIFE("Falchion Knife", ItemCategory.KNIFE),
    FLIP_KNIFE("Flip Knife", ItemCategory.KNIFE),
    GUT_KNIFE("Gut Knife", ItemCategory.KNIFE),
    HUNTSMAN_KNIFE("Huntsman Knife", ItemCategory.KNIFE),
    KARAMBIT("Karambit", ItemCategory.KNIFE),
    KUKRI_KNIFE("Kukri Knife", ItemCategory.KNIFE),
    M9_BAYONET("M9 Bayonet", ItemCategory.KNIFE),
    NAVAJA_KNIFE("Navaja Knife", ItemCategory.KNIFE),
    NOMAD_KNIFE("Nomad Knife", ItemCategory.KNIFE),
    PARACORD_KNIFE("Paracord Knife", ItemCategory.KNIFE),
    SHADOW_DAGGERS("Shadow Daggers", ItemCategory.KNIFE),
    SKELETON_KNIFE("Skeleton Knife", ItemCategory.KNIFE),
    STILETTO_KNIFE("Stiletto Knife", ItemCategory.KNIFE),
    SURVIVAL_KNIFE("Survival Knife", ItemCategory.KNIFE),
    TALON_KNIFE("Talon Knife", ItemCategory.KNIFE),
    URSUS_KNIFE("Ursus Knife", ItemCategory.KNIFE),

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
