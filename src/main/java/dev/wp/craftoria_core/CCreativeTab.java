package dev.wp.craftoria_core;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.Comparator;
import java.util.function.Supplier;

public class CCreativeTab {
//    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Craftoria.ID);

//    public static final Supplier<CreativeModeTab> CREATIVE_TAB = CREATIVE_MODE_TABS.register(Craftoria.ID, () -> CreativeModeTab.builder()
//            .title(Component.translatable("itemGroup.%s.%s".formatted(Craftoria.ID, Craftoria.ID)))
//            .icon(CItems.LOGO::toStack)
//            .displayItems((parameters, output) -> {
//                CItems.ITEMS.getEntries().stream()
//                        .sorted(Comparator.comparing(entry -> entry.get().getDescriptionId()))
//                        .forEach(entry -> output.accept(entry.get()));
//            })
//            .build());

    public static void init(IEventBus bus) {
//        CREATIVE_MODE_TABS.register(bus);
    }
}
