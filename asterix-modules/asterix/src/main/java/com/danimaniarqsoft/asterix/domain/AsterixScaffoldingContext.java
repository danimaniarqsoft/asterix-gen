package com.danimaniarqsoft.asterix.domain;

import lombok.Data;

import com.danimaniarqsoft.asterix.javaparser.core.context.JavaFileContext;

@Data
public class AsterixScaffoldingContext {

    private DomainElement domainElement;
    private JavaFileContext javaFileContext;

    public AsterixScaffoldingContext() {
    }

    public AsterixScaffoldingContext(DomainElement domainElement) {
        this.domainElement = domainElement;
    }
}
