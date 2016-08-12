package com.danimaniarqsoft.asterix.uiconsole;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.shell.plugin.PromptProvider;
import org.springframework.stereotype.Component;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class AsterixPrompt implements PromptProvider {

    @Value("${asterix.prompt}")
    private String prompt;

    public String name() {
        return "asterix promt";
    }

    @Override
    public String getPrompt() {
        return prompt;
    }

    public String getProviderName() {
        return "asterix promt";
    }
}
