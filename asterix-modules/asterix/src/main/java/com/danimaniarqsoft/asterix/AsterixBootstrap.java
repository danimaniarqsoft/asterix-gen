package com.danimaniarqsoft.asterix;

import java.io.IOException;

import org.springframework.shell.Bootstrap;

import com.danimaniarqsoft.asterix.util.AsterixUtils;
import com.danimaniarqsoft.asterix.validators.InitValidator;

/**
 * Driver para cargar a "Asterix"
 * 
 * @author Daniel Pichardo
 * 
 */

public class AsterixBootstrap {

    /**
     * Método principal que inicializa la aplicación para Asterix
     * 
     * @param args
     * @throws IOException
     */

    public static void main(String[] args) throws IOException {
        AsterixUtils.clearConsole();
        if (InitValidator.isMavenProject()) {
            Bootstrap.main(args);
        } else {
            System.out
                    .println("Al parecer está intentado correr a Asterix fuera de un proyecto Maven. Por favor, verifíque que Asterix está bajo un proyecto Maven");
        }
    }
}
