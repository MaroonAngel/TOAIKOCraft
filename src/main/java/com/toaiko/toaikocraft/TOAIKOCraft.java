package com.toaiko.toaikocraft;

import com.toaiko.toaikocraft.entity.FreshwaterAngelfishEntity;
import com.toaiko.toaikocraft.entity.TOAIKOGroupFishEntity;
import com.toaiko.toaikocraft.init.TOAIKOEntityTypes;
import com.toaiko.toaikocraft.init.TOAIKOFishInit;
import com.toaiko.toaikocraft.init.TOAIKOItems;
import com.toaiko.toaikocraft.item.TOAIKOFishBucketItem;
import com.toaiko.toaikocraft.item.TOAIKOFishItem;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.*;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("toaikocraft")
public class TOAIKOCraft
{
    // Directly reference a log4j logger.
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "toaikocraft";
    public static final ItemGroup TAB = new ItemGroup("toaikocraftTab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(TOAIKOItems.FRESHWATER_ANGELFISH.get());
        }
    };

    public TOAIKOCraft() {
        final IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        eventBus.addListener(this::setup);
        eventBus.addListener(this::enqueueIMC);
        eventBus.addListener(this::processIMC);
        eventBus.addListener(this::doClientStuff);

        TOAIKOEntityTypes.ENTITY_TYPES.register(eventBus);
        TOAIKOItems.ITEMS.register(eventBus);


        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        LOGGER.info("TOAIKOCraft: Initializing...");
        DeferredWorkQueue.runLater(() -> {
            //GlobalEntityTypeAttributes.put(TOAIKOEntityTypes.FRESHWATER_ANGELFISH.get(), FreshwaterAngelfishEntity.setCustomAttributes().build());
            //GlobalEntityTypeAttributes.put(TOAIKOEntityTypes.OSCAR.get(), OscarEntity.setCustomAttributes().build());
            //for (EntityType<TOAIKOGroupFishEntity> entity : TOAIKOFishInit.fishEntities) {

            //}
            // just get it from fishinit and for each the list
        });
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        // do something that can only be done on the client
        //LOGGER.info("Got game settings {}", event.getMinecraftSupplier().get().options);
    }

    private void enqueueIMC(final InterModEnqueueEvent event)
    {
        //GlobalEntityTypeAttributes.put(ModEntityTypes.FRESHWATER_ANGELFISH.get(), FreshwaterAngelfishEntity.setCustomAttributes().build());
        //GlobalEntityTypeAttributes.put(ModEntityTypes.OSCAR.get(), OscarEntity.setCustomAttributes().build());
        // some example code to dispatch IMC to another mod
        //InterModComms.sendTo("examplemod", "helloworld", () -> { LOGGER.info("Hello world from the MDK"); return "Hello world";});
    }

    private void processIMC(final InterModProcessEvent event)
    {
        // some example code to receive and process InterModComms from other mods
        //LOGGER.info("Got IMC {}", event.getIMCStream().
        //        map(m->m.getMessageSupplier().get()).
        //        collect(Collectors.toList()));
    }
    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {
        // do something when the server starts
        //LOGGER.info("HELLO from server starting");
    }

    // You can use EventBusSubscriber to automatically subscribe events on the contained class (this is subscribing to the MOD
    // Event bus for receiving Registry Events)
    @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent) {
            // register a new block here
            //LOGGER.info("HELLO from Register Block");
        }
    }
}
