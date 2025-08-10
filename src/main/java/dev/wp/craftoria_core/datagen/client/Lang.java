package dev.wp.craftoria_core.datagen.client;

import dev.wp.craftoria_core.Craftoria;
import net.neoforged.neoforge.common.data.LanguageProvider;
import net.neoforged.neoforge.data.event.GatherDataEvent;

public final class Lang extends LanguageProvider {
    public Lang(GatherDataEvent event) {
        super(event.getGenerator().getPackOutput(), Craftoria.ID, "en_us");
    }

    private static String key(String path) {
        return Craftoria.ID + "." + path;
    }

    @Override
    protected void addTranslations() {
        this.add(key("config.mixin_toggles"), "Mixin Toggles");
        this.add(key("config.disable_search_tab_autofocus"), "Disable Search Tab Autofocus");
        this.add(key("config.suppress_unknown_packet_id"), "Suppress Unknown Packet ID Errors");
    }
}
