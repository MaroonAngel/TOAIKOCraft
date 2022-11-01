package com.toaiko.toaikocraft.util;

import com.toaiko.toaikocraft.TOAIKOCraft;
import com.toaiko.toaikocraft.client.render.FreshwaterAngelfishRenderer;
import com.toaiko.toaikocraft.client.render.OscarRenderer;
import com.toaiko.toaikocraft.entities.OscarEntity;
import com.toaiko.toaikocraft.init.ModEntityType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = TOAIKOCraft.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEventBusSubscriber {

    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        RenderingRegistry.registerEntityRenderingHandler(ModEntityType.OSCAR.get(), OscarRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntityType.FRESHWATER_ANGELFISH.get(), FreshwaterAngelfishRenderer::new);
    }
}
