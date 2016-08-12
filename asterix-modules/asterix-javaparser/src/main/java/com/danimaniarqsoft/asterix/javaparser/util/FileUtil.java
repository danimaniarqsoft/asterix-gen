package com.danimaniarqsoft.asterix.javaparser.util;

import java.io.Closeable;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class FileUtil {
	private static final Logger LOGGER = LoggerFactory.getLogger(FileUtil.class);

    public static void close(Closeable e) {
        if (e != null) {
            try {
                e.close();
            } catch (IOException e1) {
                LOGGER.error("El recurso ya fue cerrado: ", e);
            }
        }
    }

}
