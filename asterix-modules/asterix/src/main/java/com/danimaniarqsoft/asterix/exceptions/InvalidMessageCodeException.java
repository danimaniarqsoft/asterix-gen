/**
 * Creado por: danimaniARQSOFT
 * Autor     : Daniel Pichardo	
 * Fecha     : Apr 7, 2014
 * Hora      : 10:41:00 PM
 * 
 */
package com.danimaniarqsoft.asterix.exceptions;

/**
 * La Class InvalidMessageCodeException.
 *
 * @author Daniel Pichardo
 */
public class InvalidMessageCodeException extends IllegalArgumentException {
    private static final long serialVersionUID = 1L;

    /**
     * Construye un objeto de <code>InvalidMessageCodeException</code> con un
     * mensaje detallado.
     *
     * @param mensaje
     *            the mensaje
     */
    public InvalidMessageCodeException(String mensaje) {
        super(mensaje);
    }
}
