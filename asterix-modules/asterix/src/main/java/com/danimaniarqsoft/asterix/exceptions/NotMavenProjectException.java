/**
 * Creado por: danimaniARQSOFT
 * Autor     : Daniel Pichardo	
 * Fecha     : Apr 7, 2014
 * Hora      : 10:41:00 PM
 * 
 */
package com.danimaniarqsoft.asterix.exceptions;

/**
 * La Clase NotMavenProjctException.
 *
 * @author Daniel Pichardo
 */
public class NotMavenProjectException extends IllegalStateException {
    private static final long serialVersionUID = 1L;

    /**
     * Construye un objeto de <code>NotMavenProjectException</code> con un
     * mensaje detallado.
     *
     * @param mensaje
     *            the mensaje
     */
    public NotMavenProjectException(String mensaje) {
        super(mensaje);
    }
}
