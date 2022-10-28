package com.toaiko.aquarism.util;

import com.toaiko.aquarism.Aquarism;
import com.toaiko.aquarism.client.render.FreshwaterAngelfishRenderer;
import com.toaiko.aquarism.init.ModEntityType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = Aquarism.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEventBusSubscriber {
    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        RenderingRegistry.registerEntityRenderingHandler(ModEntityType.FRESHWATER_ANGELFISH.get(), FreshwaterAngelfishRenderer::new);
    }
}
