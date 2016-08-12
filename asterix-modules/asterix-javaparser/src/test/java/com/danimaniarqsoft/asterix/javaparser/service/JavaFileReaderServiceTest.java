package com.danimaniarqsoft.asterix.javaparser.service;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.danimaniarqsoft.asterix.javaparser.util.CUUtil;
import com.github.javaparser.ParseException;
import com.github.javaparser.ast.CompilationUnit;

public class JavaFileReaderServiceTest {

    private String varType;
    private String varName;

    @BeforeClass
    public void init() {
        this.varType = "Usuario";
        this.varName = "usuarioList";
    }

    @Test
    public void main() throws ParseException, IOException {
        CompilationUnit cu = CUUtil.readJavaFileFromResource("/Usuario.java");
    }
}