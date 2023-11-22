package framework.utils;

import java.io.File;

public class FileOperations {
    private static final String DiretorioBase = System.getProperty("user.dir")
            + File.separator + "src"
            + File.separator + "main";

    public static final String DiretorioMain = DiretorioBase + File.separator + "java";

    public static final String DiretorioResources = DiretorioBase + File.separator + "resources";
}
