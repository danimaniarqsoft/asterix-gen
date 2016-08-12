package com.danimaniarqsoft.asterix.converters;

import java.util.List;

import org.springframework.shell.core.Completion;
import org.springframework.shell.core.Converter;
import org.springframework.shell.core.MethodTarget;

import com.danimaniarqsoft.asterix.javaparser.core.context.BeanContext;

public abstract class JavaBeanAbstractConverter implements
        Converter<BeanContext> {

    @Override
    public boolean supports(Class<?> type, String optionContext) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public BeanContext convertFromText(String value, Class<?> targetType,
            String optionContext) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean getAllPossibleValues(List<Completion> completions,
            Class<?> targetType, String existingData, String optionContext,
            MethodTarget target) {
        // TODO Auto-generated method stub
        return false;
    }

}
