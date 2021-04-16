package me.itzblacky.ItzCore.Utils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class Utils {

    public static boolean copy(InputStream source, String destination) {
        boolean success = true;
        File dir = new File(new File(destination).getParentFile().getAbsolutePath());
        if (!dir.exists()) {
            dir.mkdir();
        }
        try {
            Files.copy(source, Paths.get(destination), StandardCopyOption.REPLACE_EXISTING);
            source.close();
        } catch (IOException ex) {
            ex.printStackTrace();
            success = false;
        }
        return success;
    }
}
