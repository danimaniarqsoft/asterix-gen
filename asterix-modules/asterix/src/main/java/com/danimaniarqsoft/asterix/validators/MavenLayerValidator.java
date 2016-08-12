package com.danimaniarqsoft.asterix.validators;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.danimaniarqsoft.asterix.maven.MavenProject;

@Component
public class MavenLayerValidator {

    @Autowired
    private MavenProject mavenProject;

    public ArrayList<Integer> validateLayer() {
        ArrayList<Integer> mensajes = new ArrayList<Integer>();
        validateWebLayer(mensajes);
        validateModelLayer(mensajes);
        validateServiceLayer(mensajes);
        validatePersistenceLayer(mensajes);
        validateUtilLayer(mensajes);
        return mensajes;
    }

    private void validateWebLayer(ArrayList<Integer> mensajes) {
        if (!mavenProject.getWebPath().exists())
            mensajes.add(MessageCode.WEB_PACKAGE_MISSING);
    }

    private void validateModelLayer(ArrayList<Integer> mensajes) {
        if (!mavenProject.getModelPath().exists())
            mensajes.add(MessageCode.MODEL_PACKAGE_MISSING);
    }

    private void validateServiceLayer(ArrayList<Integer> mensajes) {
        if (!mavenProject.getServicePath().exists())
            mensajes.add(MessageCode.SERVICE_PACKAGE_MISSING);
    }

    private void validatePersistenceLayer(ArrayList<Integer> mensajes) {
        if (!mavenProject.getPersistencePath().exists())
            mensajes.add(MessageCode.PERSISTENCE_PACKAGE_MISSING);
    }

    private void validateUtilLayer(ArrayList<Integer> mensajes) {
        if (!mavenProject.getUtilPath().exists())
            mensajes.add(MessageCode.UTIL_PACKAGE_MISSING);
    }
}
