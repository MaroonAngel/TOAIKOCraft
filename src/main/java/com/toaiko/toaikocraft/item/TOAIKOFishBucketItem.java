package com.toaiko.toaikocraft.item;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.fish.TropicalFishEntity;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.FishBucketItem;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.text.IFormattableTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.List;

public class TOAIKOFishBucketItem extends FishBucketItem {
    public TOAIKOFishBucketItem(EntityType<?> fish, Fluid fluid, Properties properties) {
        super(fish, fluid, properties);
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void appendHoverText(ItemStack bucket, @Nullable World world, List<ITextComponent> lore, ITooltipFlag flag) {
        CompoundNBT compoundnbt = bucket.getTag();
        if (compoundnbt != null && compoundnbt.contains("BucketVariantTag", 8)) {
            String variant = compoundnbt.getString("BucketVariantTag");
            String test = "entity.toaikocraft." + bucket.getItem().getRegistryName().toString().split(":")[1].replace("_bucket", "." + variant);

            TextFormatting[] atextformatting = new TextFormatting[]{TextFormatting.ITALIC, TextFormatting.GRAY};

            lore.add((new TranslationTextComponent(test)).withStyle(atextformatting));
        }
    }
}
