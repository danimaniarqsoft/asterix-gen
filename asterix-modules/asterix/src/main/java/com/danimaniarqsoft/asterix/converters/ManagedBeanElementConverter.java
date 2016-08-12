package com.danimaniarqsoft.asterix.converters;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.core.Completion;
import org.springframework.shell.core.Converter;
import org.springframework.shell.core.MethodTarget;
import org.springframework.stereotype.Component;

import com.danimaniarqsoft.asterix.core.LayerInspector;
import com.danimaniarqsoft.asterix.domain.ManagedBeanElement;
import com.danimaniarqsoft.asterix.maven.MavenProject;
import com.danimaniarqsoft.asterix.util.FilterType;
import com.danimaniarqsoft.asterix.util.JavaFileNameFormat;

@Component
public class ManagedBeanElementConverter implements
        Converter<ManagedBeanElement> {

    @Autowired
    private LayerInspector layerInspector;

    @Autowired
    protected MavenProject mavenProject;

    @Override
    public ManagedBeanElement convertFromText(final String value,
            final Class<?> requiredType, final String optionContext) {
        ManagedBeanElement target = new ManagedBeanElement();
        target.setBeanInvocationFormat(JavaFileNameFormat
                .convertToBeanInvoking(value));
        target.setFileName(value);
        target.setJavaFilePath(new File(mavenProject.getWebPath(), value));
        return target;
    }

    @Override
    public boolean getAllPossibleValues(final List<Completion> completions,
            final Class<?> requiredType, final String existingData,
            final String optionContext, final MethodTarget target) {

        String[] modelList = layerInspector.listAllManagedBeanClass(".java",
                FilterType.END_WITH);
        for (String file : modelList) {
            completions.add(new Completion(file));
        }
        return false;
    }

    @Override
    public boolean supports(final Class<?> requiredType,
            final String optionContext) {
        return ManagedBeanElement.class.isAssignableFrom(requiredType);
    }
}
