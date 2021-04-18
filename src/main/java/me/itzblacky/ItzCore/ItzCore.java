package me.itzblacky.ItzCore;


import arc.Events;
import arc.util.CommandHandler;
import arc.util.Log;
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
                    Log.info("ItzCore: Found provider " + mod.name + " for feature " + clas.getSimpleName());
                    apiProviders.put(clas, mod.main);
                }
            }
        });
        Log.info("ItzCore: No feature provider found.");
    }

    @Override
    public void registerServerCommands(CommandHandler handler) {
        handler.register("itzcoretest", "test ItzCore", args -> {
           for(Map.Entry<Class<?>, Mod> entry : apiProviders.entrySet()) {
               Log.info("Found provider: " + entry.getKey().getCanonicalName() + " .. " + entry.getValue().getClass().getCanonicalName());
           }
           for(Class<?> claz : providerType) {
               Log.info("Provider type: " + claz.getCanonicalName());
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
