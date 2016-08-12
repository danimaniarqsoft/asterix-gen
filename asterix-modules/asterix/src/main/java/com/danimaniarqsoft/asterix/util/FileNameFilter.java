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

import com.danimaniarqsoft.asterix.util.filters.EndtFilterStrategy;
import com.danimaniarqsoft.asterix.util.filters.ExactFilterStrategy;
import com.danimaniarqsoft.asterix.util.filters.StartFilterStrategy;

/**
 * La Clase FileNameFilter. Filtra en un directorio sólo los archivos que se
 * pasen en el parámetro targetWord
 * 
 * @author Daniel Pichardo
 */
public class FileNameFilter implements FilenameFilter {

    private FilterStrategy filter;

    private String targetWord;

    /**
     * Crea una instancia de file name filter.
     * 
     * @param targetWord
     *            the target word
     */
    public FileNameFilter(String targetWord, FilterType filterType) {
        filter = getFilterStrategy(filterType);
        this.targetWord = targetWord.trim().toLowerCase();
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.io.FilenameFilter#accept(java.io.File, java.lang.String)
     */
    @Override
    public boolean accept(File dir, String name) {
        return filter.doFilter(dir, name, targetWord);
    }

    private FilterStrategy getFilterStrategy(FilterType filterType) {
        switch (filterType) {
        case START_WITH:
            return new StartFilterStrategy();
        case END_WITH:
            return new EndtFilterStrategy();
        case EXACT:
            return new ExactFilterStrategy();
        default:
            throw new IllegalArgumentException("Tipo de filtro no soportado");
        }
    }
}
