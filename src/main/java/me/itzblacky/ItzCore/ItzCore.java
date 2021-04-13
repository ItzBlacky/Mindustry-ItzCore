package me.itzblacky.ItzCore;


import arc.Events;
import me.itzblacky.ItzCore.Utils.ClassFinder;
import mindustry.Vars;

import mindustry.game.EventType;
import mindustry.mod.Mod;
import mindustry.mod.Mods;
import mindustry.mod.Plugin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ItzCore extends Plugin {

    private Map<Class<?>, Mod> apiProviders;
    private List<Class<?>> providerType;

    @Override
    public void init() {
        apiProviders = new HashMap<>();
        providerType = ClassFinder.findInterface("me.itzblacky.ItzCore.DependencyInterface");

        Events.on(EventType.ServerLoadEvent.class, event -> {
            Mods mods = Vars.mods;
            for (Mods.LoadedMod mod : mods.list()) {
                for (Class<?> clas : providerType) {
                    if (!clas.isAssignableFrom(mod.main.getClass())) continue;

                    apiProviders.put(clas, mod.main);
                }
            }
        });
    }
    public <T> T getProvider(Class<T> provider) {
        Class<?> clazz = null;
        for(Class<?> clas : providerType)
            clazz = clas.getCanonicalName().equals(provider.getCanonicalName()) && clazz == null ? clas : null;
        return (T) clazz.cast(apiProviders.get(clazz));
    }

}
