package com.danimaniarqsoft.asterix.util.filters;

import java.io.File;

import com.danimaniarqsoft.asterix.util.FilterStrategy;

public class EndtFilterStrategy implements FilterStrategy {

    @Override
    public boolean doFilter(File dir, String name, String targetWord) {
        return name.toLowerCase().endsWith(targetWord);
    }
}
