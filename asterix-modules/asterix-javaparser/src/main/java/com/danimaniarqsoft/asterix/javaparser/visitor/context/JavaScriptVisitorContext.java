package com.danimaniarqsoft.asterix.javaparser.visitor.context;

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

import lombok.Data;

@Data
public class JavaScriptVisitorContext {
    private String constantFileName;
    private TreeMap<String, Object> constants;

    public JavaScriptVisitorContext(String constantFileName) {
        this.constantFileName = constantFileName;
        constants = new TreeMap<String, Object>();
    }

    public void agregarConstante(String constante, Object valor) {
        constants.put(constante, valor);
    }

    public String buildJavaScriptConstantString() {
        StringBuilder sb = new StringBuilder();
        Set<Entry<String, Object>> set = constants.entrySet();
        Iterator<Entry<String, Object>> i = set.iterator();
        while (i.hasNext()) {
            Entry<String, Object> me = i.next();
            if (sb.length() == 0) {
                sb.append("var " + constantFileName + " = {");
                sb.append("\n\t");
            } else {
                sb.append(",\n\t");
            }
            sb.append("\"" + me.getKey() + "\"" + " = " + me.getValue());
        }

        sb.append("\n}");
        return sb.toString();
    }
}
