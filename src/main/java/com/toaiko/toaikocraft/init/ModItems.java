package com.toaiko.toaikocraft.init;

import net.minecraft.item.Item;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import com.toaiko.toaikocraft.TOAIKOCraft;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, TOAIKOCraft.MOD_ID);

    // Eggs
    public static final RegistryObject<ForgeSpawnEggItem> FRESHWATER_ANGELFISH_SPAWN_EGG = ITEMS.register("freshwater_angelfish_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityType.FRESHWATER_ANGELFISH, 0xFFFFFF, 0xFFFFFF, new Item.Properties().tab(TOAIKOCraft.TAB)));

    // Buckets
    //public static final RegistryObject<FishBucketItem> FRESHWATER_ANGELFISH_BUCKET = ITEMS.register("freshwater_angelfish_bucket",
    //        () -> new FishBucketItem(ModEntityType.FRESHWATER_ANGELFISH, Fluids.WATER, (new Item.Properties()).stacksTo(1).tab(TOAIKOCraft.TAB)));
}
