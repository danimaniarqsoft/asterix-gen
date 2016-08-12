package com.danimaniarqsoft.asterix.validators;

import static com.danimaniarqsoft.asterix.validators.MessageCode.MODEL_PACKAGE_MISSING;
import static com.danimaniarqsoft.asterix.validators.MessageCode.NOT_MAVEN_PROJECT;
import static com.danimaniarqsoft.asterix.validators.MessageCode.PERSISTENCE_PACKAGE_MISSING;
import static com.danimaniarqsoft.asterix.validators.MessageCode.SERVICE_PACKAGE_MISSING;
import static com.danimaniarqsoft.asterix.validators.MessageCode.UTIL_PACKAGE_MISSING;
import static com.danimaniarqsoft.asterix.validators.MessageCode.WEB_PACKAGE_MISSING;

import java.util.ArrayList;

import com.danimaniarqsoft.asterix.exceptions.InvalidMessageCodeException;

public class MessageBuilder {

    private static final String LINE_SEPARATOR = System
            .getProperty("line.separator");

    private static String buildMessage(int option) {
        switch (option) {
        case NOT_MAVEN_PROJECT:
            return "El proyecto no es maven";
        case WEB_PACKAGE_MISSING:
            return "No existe la capa Web en el proyecto";
        case SERVICE_PACKAGE_MISSING:
            return "No existe la capa de servicios en el proyecto";
        case PERSISTENCE_PACKAGE_MISSING:
            return "No existe la capa de persistencia en el proyecto";
        case MODEL_PACKAGE_MISSING:
            return "No existe la capa de modelo en el proyecto";
        case UTIL_PACKAGE_MISSING:
            return "No existe la capa de Util";
        default:
            throw new InvalidMessageCodeException(
                    "La opcion del mensaje no existe");
        }
    }

    public static String createMessage(ArrayList<Integer> message) {
        StringBuilder messages = new StringBuilder();
        for (Integer mensaje : message) {
            messages.append(buildMessage(mensaje));
            messages.append(LINE_SEPARATOR);
        }
        return messages.toString();
    }
}
