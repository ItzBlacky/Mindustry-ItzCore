package me.itzblacky.ItzCore;


import arc.Events;
import me.itzblacky.ItzCore.Utils.ClassFinder;
import me.itzblacky.ItzCore.Utils.Config;
import mindustry.Vars;

import mindustry.game.EventType;
import mindustry.mod.Mod;
import mindustry.mod.Mods;
import mindustry.mod.Plugin;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
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
    @SuppressWarnings("unchecked")
    public <T> T getProvider(Class<T> provider) throws ClassCastException {
        Class<?> clazz = null;
        for(Class<?> clas : providerType)
            clazz = clas.getCanonicalName().equals(provider.getCanonicalName()) && clazz == null ? clas : null;
        return clazz != null ? (T) clazz.cast(apiProviders.get(clazz)) : null;
    }
    /* Not in Use
    private static Config loadConfig(String path) {
        Config config = null;
        try {
            InputStream stream = new FileInputStream(path);
            Yaml yaml = new Yaml(new Constructor(Config.class));
            config = yaml.load(stream);
            stream.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
        return config;
    }*/
}
