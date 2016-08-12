package com.danimaniarqsoft.asterix.util;

import static org.fusesource.jansi.Ansi.ansi;
import com.github.javaparser.ParseException;

import java.io.FileNotFoundException;

import lombok.extern.slf4j.Slf4j;

import org.fusesource.jansi.AnsiConsole;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.danimaniarqsoft.asterix.core.operations.AbstractCommandOperation;
import com.danimaniarqsoft.asterix.domain.AsterixContext;

@Slf4j
public class AsterixUtils {
	private static final Logger LOGGER = LoggerFactory.getLogger(AsterixUtils.class);

    private AsterixUtils(){
    }

    public static void clearConsole() {
        try {
            String os = System.getProperty("os.name").toLowerCase();
            if (os.contains("windows")) {
                LOGGER.debug("corriendo en Windows");
                Runtime.getRuntime().exec("cls");
            } else {
                LOGGER.debug("corriendo en Linux");
                Runtime.getRuntime().exec("clear");
            }
        } catch (Exception e) {
            LOGGER.error("clearConsole: ", e);
        }
        AnsiConsole.out().println(ansi().eraseScreen().cursor(0, 0));
    }

    public static String processCommand(AbstractCommandOperation operation,
            AsterixContext context) {
        try {
            return operation.processCommand(context);
        } catch (FileNotFoundException | ParseException e) {
            LOGGER.error("processCommand : ", e);
        }
        return "El comando no existe";
    }
}
