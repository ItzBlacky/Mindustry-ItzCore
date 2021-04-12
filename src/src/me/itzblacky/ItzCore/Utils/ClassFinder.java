package me.itzblacky.ItzCore.Utils;

import me.itzblacky.ItzCore.ItzCore;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class ClassFinder {
    public static List<Class<?>> find(String packagePath) {
        List<Class<?>> classes = new ArrayList<>();
        try {
            JarFile jar = new JarFile(new File(ItzCore.class.getProtectionDomain().getCodeSource().getLocation()
                    .toURI()));
            for (Enumeration<JarEntry> entries = jar.entries(); entries.hasMoreElements(); ) {
                JarEntry entry = entries.nextElement();
                String file = entry.getName();

                if(!file.endsWith(".class")) continue;
                if(!file.startsWith(packagePath.replace('.', '/'))) continue;

                String classname = file.replace('/', '.').substring(0, file.length() - 6);

                try {
                    Class<?> c = Class.forName(classname);
                    classes.add(c);
                } catch (Throwable e) {
                    System.out.println("WARNING: failed to instantiate " + classname + " from " + file);
                }
            }
        } catch (IOException | URISyntaxException io) {
            io.printStackTrace();
        }
        return classes;
    }
    public static List<Class<?>> findInterface(String packagePath) {
        List<Class<?>> classes = find(packagePath);
        List<Class<?>> toReturn = new ArrayList<>();
        for(Class<?> clas : classes) {
            if(clas.isInterface()) toReturn.add(clas);
        }
        return toReturn;
    }
}
