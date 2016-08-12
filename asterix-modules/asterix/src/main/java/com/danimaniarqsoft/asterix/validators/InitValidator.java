package com.danimaniarqsoft.asterix.validators;

import java.io.File;

public class InitValidator {
    public static File POM_FILE;
    public static File ROOT_DIR;

    static {
        ROOT_DIR = new File(System.getProperty("user.dir"));
        POM_FILE = new File(ROOT_DIR, "pom.xml");
    }

    public static boolean isMavenProject() {
        return POM_FILE.exists();
    }
}
