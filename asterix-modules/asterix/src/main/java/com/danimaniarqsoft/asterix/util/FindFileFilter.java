/**
 * Creado por: danimaniARQSOFT
 * Autor     : Daniel Pichardo	
 * Fecha     : Apr 11, 2014
 * Hora      : 10:30:22 PM
 * 
 */
package com.danimaniarqsoft.asterix.util;

import java.io.File;
import java.io.FilenameFilter;

/**
 * La Clase FileNameFilter. Filtra en un directorio sólo los archivos que se
 * pasen en el parámetro targetWord
 *
 * @author Daniel Pichardo
 */
public class FindFileFilter implements FilenameFilter {

    private String targetWord;

    /**
     * Crea una instancia de file name filter.
     *
     * @param targetWord
     *            the target word
     */
    public FindFileFilter(String targetWord) {
        this.targetWord = targetWord.trim();
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.io.FilenameFilter#accept(java.io.File, java.lang.String)
     */
    @Override
    public boolean accept(File dir, String name) {
        // return name.replace(".java", "").equalsIgnoreCase(targetWord);
        return name.equalsIgnoreCase(targetWord);
    }
}
