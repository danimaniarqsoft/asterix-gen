/**
 * Creado por: danimaniARQSOFT
 * Autor     : Daniel Pichardo	
 * Fecha     : Apr 11, 2014
 * Hora      : 9:22:14 PM
 * 
 */
package com.danimaniarqsoft.asterix.core;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danimaniarqsoft.asterix.maven.MavenProject;
import com.danimaniarqsoft.asterix.util.FileNameFilter;
import com.danimaniarqsoft.asterix.util.FilterType;

/**
 * La clase Layer Inspector tiene por objetivo, verificar que los componentes
 * que se encuentran en las capas de exposition, service, model y persistence
 * estan bien formadas.
 * 
 * @author Daniel Pichardo
 */
@Service
public class LayerInspector {

    @Autowired
    private MavenProject mavenProject;

    public String listWebClasses() {
        return formatFileList(mavenProject.getWebPath().list());
    }

    public String listServiceClasses() {
        return null;
    }

    public String listPersistenceClasses() {
        return null;
    }

    public String listModelClasses(String filter, FilterType filterType) {
        return formatFileList(mavenProject.getModelPath().list(
                new FileNameFilter(filter, filterType)));
    }

    public String[] listAllModelClass(String filter, FilterType filterType) {
        String[] modelList = mavenProject.getModelPath().list(
                new FileNameFilter(filter, filterType));
        Arrays.sort(modelList);
        return modelList;
    }

    public String[] listAllManagedBeanClass(String filter, FilterType filterType) {
        String[] modelList = mavenProject.getWebPath().list(
                new FileNameFilter(filter, filterType));
        Arrays.sort(modelList);
        return modelList;
    }

    public String[] listAllJavaConstantsClass(String filter,
            FilterType filterType) {
        String[] modelList = mavenProject.getUtilPath().list(
                new FileNameFilter(filter, filterType));
        Arrays.sort(modelList);
        return modelList;
    }

    private String formatFileList(String[] filesList) {
        Arrays.sort(filesList);
        StringBuilder sb = new StringBuilder();
        for (String file : filesList) {
            sb.append(file).append("\n");
        }
        return sb.toString();
    }
}
