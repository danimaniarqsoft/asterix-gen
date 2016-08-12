package com.danimaniarqsoft.asterix.faces.factory;

import org.springframework.stereotype.Component;

import com.danimaniarqsoft.asterix.domain.AsterixContext;
import com.danimaniarqsoft.asterix.domain.FacesComponente;
import com.danimaniarqsoft.asterix.javaparser.util.NamingConvention;

@Component
public class FacesComponentFactory {

    public FacesComponente buildFacesComponent(AsterixContext context) {
        switch (context.getTypeOfComponent()) {
        case SELECT_ONE_MENU_SIMPLE:
            return createSelectOneMenuSimple(context);
        default:
            throw new UnsupportedOperationException("Operación no implementada");
        }
    }

    private FacesComponente createSelectOneMenuSimple(AsterixContext context) {
        FacesComponente component = new FacesComponente();
        component.setTypeOfComponent(context.getTypeOfComponent());
        component.setId(context.getDomainElement().getBeanInvocationFormat()
                + "SelectOneMenuId");
        component.setModelSelected(context.getMbTarget()
                .getBeanInvocationFormat()
                + "."
                + context.getDomainElement().getBeanInvocationFormat()
                + NamingConvention.PROPERTY_SELECTED);
        component.setModelList(context.getMbTarget().getBeanInvocationFormat()
                + "." + context.getDomainElement().getBeanInvocationFormat()
                + NamingConvention.PROPERTY_LIST);
        return component;
    }
}
