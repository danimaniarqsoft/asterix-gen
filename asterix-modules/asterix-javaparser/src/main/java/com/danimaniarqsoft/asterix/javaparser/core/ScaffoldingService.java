/**
 * Creado por: danimaniARQSOFT
 * Autor     : Daniel Pichardo	
 * Fecha     : Apr 25, 2014
 * Hora      : 11:37:10 PM
 * 
 */
package com.danimaniarqsoft.asterix.javaparser.core;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.danimaniarqsoft.asterix.javaparser.factory.JavaMemberFactory;
import com.danimaniarqsoft.asterix.javaparser.util.CUUtil;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

/**
 * La Class JavaFileContextService. Esta clase es la interfaz principal del
 * módulo de asterix-javaparser
 * 
 * @author Daniel Pichardo
 */
@Service
public class ScaffoldingService {
	private static final Logger LOGGER = LoggerFactory.getLogger(ScaffoldingService.class);

    @Autowired
    @Qualifier("javaFieldFactory")
    private JavaMemberFactory fieldFactory;
    @Autowired
    @Qualifier("javaMethodFactory")
    private JavaMemberFactory methodFactory;

    /**
     * 
     * @param javaFile
     * @param context
     * @return String con la representación del archivo java a JavaScript
     */
    public CompilationUnit parseJavaFile(File modelElementFile) {
        try {
            return CUUtil.readJavaFile(modelElementFile);
        } catch (Exception e) {
            LOGGER.info("No fué posible leer el archivo", e);
            return null;
        }
    }
    
    /**
     * 
     * @param javaFile
     * @param context
     * @return String con la representación del archivo java a JavaScript
     */
    public <T> void createCrudPage(CompilationUnit cu, VoidVisitorAdapter<T> visitor, T context) {
        visitor.visit(cu, context);
    }
}
