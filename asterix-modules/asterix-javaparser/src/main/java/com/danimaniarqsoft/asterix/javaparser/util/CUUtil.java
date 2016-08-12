/**
 * Creado por: danimaniARQSOFT
 * Autor     : Daniel Pichardo	
 * Fecha     : Apr 19, 2014
 * Hora      : 3:14:37 PM
 * 
 */
package com.danimaniarqsoft.asterix.javaparser.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ParseException;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.ImportDeclaration;
import com.github.javaparser.ast.body.BodyDeclaration;
import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;

/**
 * Clase CUUtil, es empleada para llevar a cabo las tareas de manipulación de la
 * <a>CompilationUnit<a>. Entre las tareas principales se encuentran: Agregar
 * nuevos métodos, campos, imports, entre otros y la escritura y lectura de
 * archivos Java.
 * 
 * @author danimaniARQSOFT
 * 
 */

public class CUUtil {
	private static final Logger LOGGER = LoggerFactory.getLogger(CUUtil.class);

    /**
     * Construye la clase <a>CompilationUnit<a> a partir de una ruta determinada
     * en el la clase File
     * 
     * @param javaFileName
     * @return
     * @throws IOException
     */
    public static CompilationUnit readJavaFile(File javaFilePath)
            throws IOException {
        LOGGER.debug("Java File (Read) : " + javaFilePath.toString());
        FileInputStream in = new FileInputStream(javaFilePath);
        try {
            CompilationUnit cu = JavaParser.parse(in);
            return cu;
        } catch (ParseException e) {
            LOGGER.error("readJavaFile Error: ", e);
        } finally {
            FileUtil.close(in);
        }
        return null;
    }

    /**
     * Construye la clase <a>CompilationUnit<a> a partir de una ruta dentro de
     * la carpeta de recursos del sistema. Ej. /[NombreClase] . [NombreClase].
     * La primera buscara en el inicio del classpath, la otra buscara en la ruta
     * actual de ésta clase.
     * 
     * @param javaFileName
     * @return
     * @throws IOException
     */
    public static CompilationUnit readJavaFileFromResource(String javaFileName)
            throws IOException {
        return readJavaFile(new File(CUUtil.class.getResource(javaFileName)
                .getPath()));
    }

    /**
     * Escribre la <a>CompilationUnit<a> al archivo indicado en la variable
     * filePath.
     * 
     * @param filePath
     *            la ruta del archivo
     * @param cu
     *            la CompilationUnit
     * @throws IOException
     *             Indica que ocurrio una excepción de tipo I/O.
     */
    public static void writeCU(CompilationUnit cu, File filePath)
            throws IOException {
        LOGGER.debug("Escribiendo Archivo en:");
        LOGGER.debug(filePath.toString());
        LOGGER.debug(cu.toString());
        BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
        try {
            writer.write(cu.toString());
        } finally {
            FileUtil.close(writer);
        }
    }

    public static CUSet extractFieldsAndMethods(CompilationUnit cu) {
        List<ImportDeclaration> imports = extractImports(cu);
        List<BodyDeclaration> bodyMembers = extractBodyMembers(cu);
        List<FieldDeclaration> fields = new ArrayList<FieldDeclaration>();
        List<MethodDeclaration> methods = new ArrayList<MethodDeclaration>();

        fillFieldsAndMethods(bodyMembers, fields, methods);

        return new CUSet(imports, fields, methods);
    }

    private static void fillFieldsAndMethods(List<BodyDeclaration> bodyMembers,
            List<FieldDeclaration> fields, List<MethodDeclaration> methods) {
        for (BodyDeclaration member : bodyMembers) {
            if (member instanceof FieldDeclaration) {
                fields.add((FieldDeclaration) member);
            } else if (member instanceof MethodDeclaration) {
                methods.add((MethodDeclaration) member);
            }
        }
    }

    public static List<ImportDeclaration> extractImports(CompilationUnit cu) {
        if (cu.getImports() != null) {
            return cu.getImports();
        } else {
            cu.setImports(new ArrayList<ImportDeclaration>());
            return cu.getImports();
        }
    }

    public static List<BodyDeclaration> extractBodyMembers(CompilationUnit cu) {
        return cu.getTypes().get(0).getMembers() != null ? cu.getTypes().get(0)
                .getMembers() : new ArrayList<BodyDeclaration>();
    }

    public static String readPackageDeclaration(File beanPath) {
        try {
            CompilationUnit cu = readJavaFile(beanPath);
            return cu.getPackage().toString().replaceAll("package ", "")
                    .replaceAll(";", "").replaceAll("\n", "")
                    .replaceAll("\r", "");
        } catch (IOException e) {
            LOGGER.error("readPackageDeclaration", e);
        }
        return null;
    }
}
