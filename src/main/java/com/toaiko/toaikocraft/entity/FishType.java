package com.toaiko.toaikocraft.entity;

import com.toaiko.toaikocraft.client.model.FreshwaterAngelfishModel;
import com.toaiko.toaikocraft.client.model.OscarModel;
import net.minecraft.client.renderer.entity.model.EntityModel;

public enum FishType {
    FRESHWATER_ANGELFISH(0.3f, 0.4f, 2.5D, 1.0D, 3.5f, 0.6f,
        new FreshwaterAngelfishModel<>(), new String[]{
            "albino",
            "black",
            "blue_pinoy",
            "blushing",
            "chocolate",
            "fluorescent_green",
            "fluorescent_pink",
            "golden",
            "koi",
            "koi_marble",
            "leopard",
            "marble",
            "panda",
            "platinum",
            "red_cap",
            "red_devil",
            "smokey",
            "striped",
            "sunset"
    }),

    OSCAR(0.5f, 0.3f, 7.5d, 0.75d, 2.0f, 0.4f,
        new OscarModel<>(), new String[] {
            "albino_copper",
            "albino_copper_tiger",
            "albino_red",
            "albino_red_tiger",
            "black",
            "bumble_bee",
            "copper",
            "copper_tiger",
            "golden",
            "lemon",
            "lemon_tiger",
            "red",
            "red_tiger",
            "super_red",
            "wild"
    });

    private final float width;
    private final float height;
    private final double health;
    private final double speed;
    private final float wiggleAmp;
    private final float wiggleFreq;
    private final EntityModel<TOAIKOGroupFishEntity> model;
    private final String[] variants;

    FishType(float width, float height, double health, double speed, float wiggleAmp, float wiggleFreq, EntityModel<TOAIKOGroupFishEntity> model, String[] variants) {
        this.width = width;
        this.height = height;
        this.model = model;
        this.variants = variants;
        this.health = health;
        this.speed = speed;
        this.wiggleAmp = wiggleAmp;
        this.wiggleFreq = wiggleFreq;
    }
    public float getWidth() {
        return width;
    }
    public float getHeight() {
        return height;
    }
    public double getHealth() { return health; }
    public double getSwimSpeed() { return speed; }
    public float getWiggleAmp() { return wiggleAmp; }
    public float getWiggleFreq() { return wiggleFreq; }
    public String[] getVariants() {
        return variants;
    }
    public EntityModel<TOAIKOGroupFishEntity> getModel() {
        return this.model;
    }
}
