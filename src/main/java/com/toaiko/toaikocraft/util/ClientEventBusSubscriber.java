package com.toaiko.toaikocraft.util;

import com.toaiko.toaikocraft.TOAIKOCraft;
import com.toaiko.toaikocraft.client.render.TOAIKOGroupFishRenderer;
import com.toaiko.toaikocraft.init.TOAIKOFishInit;
import net.minecraft.entity.EntityType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = TOAIKOCraft.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEventBusSubscriber {

    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        //RenderingRegistry.registerEntityRenderingHandler(TOAIKOEntityTypes.FRESHWATER_ANGELFISH.get(), FreshwaterAngelfishRenderer::new);
        //RenderingRegistry.registerEntityRenderingHandler(TOAIKOEntityTypes.OSCAR.get(), OscarRenderer::new);
        for (EntityType fish : TOAIKOFishInit.fishEntities) {
            RenderingRegistry.registerEntityRenderingHandler(fish, TOAIKOGroupFishRenderer::new);
        }
    }
}
