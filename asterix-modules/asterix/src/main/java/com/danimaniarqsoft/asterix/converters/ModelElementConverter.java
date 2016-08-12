package com.danimaniarqsoft.asterix.converters;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.core.Completion;
import org.springframework.shell.core.Converter;
import org.springframework.shell.core.MethodTarget;
import org.springframework.stereotype.Component;

import com.danimaniarqsoft.asterix.core.LayerInspector;
import com.danimaniarqsoft.asterix.domain.DomainElement;
import com.danimaniarqsoft.asterix.javaparser.util.CUUtil;
import com.danimaniarqsoft.asterix.maven.MavenProject;
import com.danimaniarqsoft.asterix.util.FilterType;
import com.danimaniarqsoft.asterix.util.JavaFileNameFormat;

@Component
public class ModelElementConverter implements Converter<DomainElement> {

    @Autowired
    private LayerInspector layerInspector;

    @Autowired
    protected MavenProject mavenProject;

    @Override
    public DomainElement convertFromText(final String javaFileNameWithExtension,
            final Class<?> requiredType, final String optionContext) {
        DomainElement modelElement = new DomainElement();
        modelElement.setBeanInvocationFormat(JavaFileNameFormat
                .convertToBeanInvoking(javaFileNameWithExtension));
        modelElement.setFileName(javaFileNameWithExtension);
        modelElement.setJavaType(JavaFileNameFormat
                .convertToJavaType(javaFileNameWithExtension));
        modelElement.setJavaFilePath(new File(mavenProject.getModelPath(),
                javaFileNameWithExtension));
        String packageDeclaration = CUUtil.readPackageDeclaration(modelElement
                .getJavaFilePath());
        modelElement.setImportDeclaration(packageDeclaration + "."
                + modelElement.getJavaType());
        return modelElement;
    }

    @Override
    public boolean getAllPossibleValues(final List<Completion> completions,
            final Class<?> requiredType, final String existingData,
            final String optionContext, final MethodTarget target) {

        String[] modelList = layerInspector.listAllModelClass(".java",
                FilterType.END_WITH);
        for (String file : modelList) {
            completions.add(new Completion(file));
        }
        return false;
    }

    @Override
    public boolean supports(final Class<?> requiredType,
            final String optionContext) {
        return DomainElement.class.isAssignableFrom(requiredType);
    }
}
