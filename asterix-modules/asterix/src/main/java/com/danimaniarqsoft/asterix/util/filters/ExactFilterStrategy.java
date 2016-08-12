package com.danimaniarqsoft.asterix.util.filters;

import java.io.File;

import com.danimaniarqsoft.asterix.util.FilterStrategy;

public class ExactFilterStrategy implements FilterStrategy {

    @Override
    public boolean doFilter(File dir, String name, String targetWord) {
        return name.toLowerCase().equalsIgnoreCase(targetWord);
    }
}
