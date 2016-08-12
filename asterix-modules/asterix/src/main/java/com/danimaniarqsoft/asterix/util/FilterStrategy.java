package com.danimaniarqsoft.asterix.util;

import java.io.File;

public interface FilterStrategy {
    boolean doFilter(File dir, String name, String targetWord);
}
