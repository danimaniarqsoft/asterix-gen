package com.danimaniarqsoft.asterix.util;

import java.io.IOException;

import com.danimaniarqsoft.asterix.domain.AsterixContext;
import com.danimaniarqsoft.asterix.domain.JavaConstantClassTarget;
import com.danimaniarqsoft.asterix.domain.ManagedBeanElement;
import com.danimaniarqsoft.asterix.domain.DomainElement;
import com.danimaniarqsoft.asterix.faces.templates.TypeOfComponent;
import com.danimaniarqsoft.asterix.javaparser.core.context.JavaFileContext;

/**
 * AsterixContextFactory, es una clase que se encarga de encapsular la
 * complejidad de la construcción de contextos del tipo AsterixContext
 * 
 * @author Daniel Pichardo
 *
 */
public class AsterixContextFactory {

    public static AsterixContext buildSelectOneMenuSimpleContext(
            ManagedBeanElement managedBeanTarget, DomainElement modelTarget)
            throws IOException {

        AsterixContext context = new AsterixContext(managedBeanTarget,
                modelTarget);
        context.setJavaFileContext(new JavaFileContext(managedBeanTarget
                .getJavaFilePath()));
        context.setTypeOfComponent(TypeOfComponent.SELECT_ONE_MENU_SIMPLE);
        return context;
    }

    public static AsterixContext buildJavaToJavascriptContext(
            JavaConstantClassTarget javaConstantClassTarget) throws IOException {
        AsterixContext context = new AsterixContext(javaConstantClassTarget);
        context.setJavaFileContext(new JavaFileContext(javaConstantClassTarget
                .getJavaFilePath()));
        context.setTypeOfComponent(TypeOfComponent.JAVA_TO_JAVASCRIPT);
        return context;
    }

    public static AsterixContext buildScaffoldingContext(
            DomainElement domainElement) {
        AsterixContext context = new AsterixContext(domainElement);
        return context;
    }
}
