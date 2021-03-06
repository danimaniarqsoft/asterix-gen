package com.danimaniarqsoft.asterix.core.operations;

import com.github.javaparser.ParseException;

import java.io.File;
import java.io.FileNotFoundException;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danimaniarqsoft.asterix.domain.AsterixContext;
import com.danimaniarqsoft.asterix.domain.DomainElement;
import com.danimaniarqsoft.asterix.javaparser.core.JavaFileContextService;
import com.danimaniarqsoft.asterix.javaparser.core.context.FieldType;
import com.danimaniarqsoft.asterix.javaparser.core.context.JavaFileContext;
import com.danimaniarqsoft.asterix.javaparser.util.NamingConvention;
import com.danimaniarqsoft.asterix.javaparser.util.PropertyBeanSet;

@Slf4j
@Service
public class SelectOneMenuOperation extends AbstractCommandOperation {

    @Autowired
    private JavaFileContextService javaFileContextService;

    @Override
    protected void parseWebLayer(AsterixContext context)
            throws FileNotFoundException, ParseException {
        super.parseWebLayer(context);
        // ok localizar archivo java
        File javaMBFile = this.mavenProject.getWebPath();
        DomainElement model = context.getDomainElement();
        JavaFileContext pContext = context.getJavaFileContext();
        // ok creamos getter y setter de la propiedad de model
        PropertyBeanSet beanSelected = javaFileContextService
                .createPropertyBeanSet(model,
                        NamingConvention.PROPERTY_SELECTED, FieldType.PROPERTY);
        pContext.addPropertyBeanSet(beanSelected,
                NamingConvention.PROPERTY_LIST);

        PropertyBeanSet beanList = javaFileContextService
                .createPropertyBeanSet(model, NamingConvention.PROPERTY_LIST,
                        FieldType.LIST);
        pContext.addPropertyBeanSet(beanList, NamingConvention.PROPERTY_LIST);
        // ok escribimos el JavaFileContext en un archivo
        javaFileContextService.writeJavaFileContextToJavaFile(new File(
                javaMBFile, context.getMbTarget().getFileName()), pContext);
    }
}
