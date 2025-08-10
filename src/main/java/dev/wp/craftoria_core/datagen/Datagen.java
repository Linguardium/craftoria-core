package dev.wp.craftoria_core.datagen;

import dev.wp.craftoria_core.Craftoria;
import dev.wp.craftoria_core.datagen.client.DatagenClient;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;

@EventBusSubscriber(modid = Craftoria.ID, bus = EventBusSubscriber.Bus.MOD)
public final class Datagen {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DatagenClient.configure(event);
    }
}
