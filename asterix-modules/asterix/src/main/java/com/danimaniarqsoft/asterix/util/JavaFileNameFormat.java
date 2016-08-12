package com.danimaniarqsoft.asterix.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.danimaniarqsoft.asterix.core.operations.AbstractCommandOperation;

import lombok.extern.slf4j.Slf4j;

public class JavaFileNameFormat {
	private static final Logger LOGGER = LoggerFactory.getLogger(JavaFileNameFormat.class);

    /**
     * Covierte un string con formato JavaFile.java a javaFile
     * 
     * @param javaFileName
     * @return String javaFileName con formato camelcase
     */
    public static String convertToBeanInvoking(String javaFileName) {
        return javaFileName.replaceFirst(javaFileName.charAt(0) + "",
                (javaFileName.charAt(0) + "").toLowerCase()).replaceAll(
                ".java", "");
    }

    /**
     * Convierte javaFileName.java a JavaFileName
     * 
     * @param javaFileName
     * @return String
     */
    public static String convertToJavaType(String javaFileName) {
        return javaFileName.replaceAll(".java", "");
    }

    public static void main(String... args) {
        LOGGER.info(convertToBeanInvoking("Usuario.java"));
        LOGGER.info(convertToJavaType("Usuario.java"));
    }
}
