package com.toaiko.toaikocraft.init;

import com.toaiko.toaikocraft.entity.FishType;
import com.toaiko.toaikocraft.entity.FreshwaterAngelfishEntity;
import com.toaiko.toaikocraft.entity.TOAIKOGroupFishEntity;
import com.toaiko.toaikocraft.item.TOAIKOFishBucketItem;
import com.toaiko.toaikocraft.item.TOAIKOFishItem;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.CatEntity;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.FishBucketItem;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import com.toaiko.toaikocraft.TOAIKOCraft;

import java.util.ArrayList;
import java.util.function.Supplier;

public class TOAIKOItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, TOAIKOCraft.MOD_ID);

    // Fish
    public static final RegistryObject<Item> OSCAR = registerFish(FishType.OSCAR);
    public static final RegistryObject<Item> FRESHWATER_ANGELFISH = registerFish(FishType.FRESHWATER_ANGELFISH);

    public static RegistryObject<Item> registerFish(FishType type) {
        String name = type.name().toLowerCase();

        // Have Fish Init Create new fish entity & register
        EntityType fishEntity = TOAIKOFishInit.registerFish(type);

        // Register Fish Item
        RegistryObject<Item> rawFish = ITEMS.register(name, TOAIKOFishItem::new);

        // Register Spawn Egg
        ITEMS.register(name + "_spawn_egg", () -> new ForgeSpawnEggItem(() -> fishEntity, 0xFFFFFF, 0xFFFFFF, new Item.Properties().tab(TOAIKOCraft.TAB)));

        // Create & register Bucket
        TOAIKOFishBucketItem fishBucket = new TOAIKOFishBucketItem(fishEntity, Fluids.WATER, (new Item.Properties()).stacksTo(1).tab(TOAIKOCraft.TAB));
        ITEMS.register(type.name().toLowerCase() + "_bucket", () -> fishBucket);
        TOAIKOGroupFishEntity.BUCKETS.put(fishEntity, fishBucket);

        ArrayList<Ingredient.IItemList> test = new ArrayList<Ingredient.IItemList>();

        //Ingredient tempt_ingredients = CatEntity.TEMPT_INGREDIENT;
        //CatEntity.TEMPT_INGREDIENT = Ingredient.merge(tempt_ingredients, Ingredient.of(rawFish.get().getDefaultInstance()));

        return rawFish;
    }
}
