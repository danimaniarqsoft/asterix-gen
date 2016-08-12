package com.danimaniarqsoft.asterix.converters;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.core.Completion;
import org.springframework.shell.core.Converter;
import org.springframework.shell.core.MethodTarget;
import org.springframework.stereotype.Component;

import com.danimaniarqsoft.asterix.core.LayerInspector;
import com.danimaniarqsoft.asterix.domain.JavaConstantClassTarget;
import com.danimaniarqsoft.asterix.javaparser.util.CUUtil;
import com.danimaniarqsoft.asterix.maven.MavenProject;
import com.danimaniarqsoft.asterix.util.FilterType;
import com.danimaniarqsoft.asterix.util.JavaFileNameFormat;

@Component
public class JavaConstantClassTargetConverter implements
        Converter<JavaConstantClassTarget> {

    @Autowired
    private LayerInspector layerInspector;

    @Autowired
    protected MavenProject mavenProject;

    @Override
    public boolean supports(Class<?> requiredType, String optionContext) {
        return JavaConstantClassTarget.class.isAssignableFrom(requiredType);
    }

    @Override
    public JavaConstantClassTarget convertFromText(String value,
            Class<?> targetType, String optionContext) {
        JavaConstantClassTarget target = new JavaConstantClassTarget();
        target.setBeanInvocationFormat(JavaFileNameFormat
                .convertToBeanInvoking(value));
        target.setFileName(value);
        target.setJavaType(JavaFileNameFormat.convertToJavaType(value));
        target.setJavaFilePath(new File(mavenProject.getUtilPath(), value));
        String packageDeclaration = CUUtil.readPackageDeclaration(target
                .getJavaFilePath());
        target.setImportDeclaration(packageDeclaration + "."
                + target.getJavaType());
        return target;
    }

    @Override
    public boolean getAllPossibleValues(List<Completion> completions,
            Class<?> targetType, String existingData, String optionContext,
            MethodTarget target) {
        String[] modelList = layerInspector.listAllJavaConstantsClass(".java",
                FilterType.END_WITH);
        for (String file : modelList) {
            completions.add(new Completion(file));
        }
        return false;
    }
}
