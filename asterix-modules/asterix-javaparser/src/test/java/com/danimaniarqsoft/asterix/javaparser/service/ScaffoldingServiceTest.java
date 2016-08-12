/**
 * Creado por: danimaniARQSOFT
 * Autor     : Daniel Pichardo	
 * Fecha     : Apr 25, 2014
 * Hora      : 11:37:10 PM
 * 
 */
package com.danimaniarqsoft.asterix.javaparser.service;

import java.io.File;
import java.io.IOException;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.testng.annotations.Test;

import com.danimaniarqsoft.asterix.javaparser.core.ScaffoldingService;
import com.danimaniarqsoft.asterix.javaparser.factory.field.JavaFieldFactory;
import com.danimaniarqsoft.asterix.javaparser.util.AbstractTest;
import com.github.javaparser.ParseException;
import com.github.javaparser.ast.CompilationUnit;

/**
 * La Class JavaFileContextService. Esta clase es la interfaz principal del
 * módulo de asterix-javaparser
 * 
 * @author Daniel Pichardo
 */
@Slf4j
@Service
public class ScaffoldingServiceTest extends AbstractTest {

    @Autowired
    private ScaffoldingService service;

    @Test
    public void main() throws ParseException, IOException {
        CompilationUnit cu = service.parseJavaFile(new File(
                ScaffoldingServiceTest.class.getResource("/Usuario.java")
                        .getPath()));
    }
}
