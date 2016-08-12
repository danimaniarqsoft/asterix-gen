package com.danimaniarqsoft.asterix.uiconsole;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.shell.plugin.BannerProvider;
import org.springframework.shell.support.util.FileUtils;
import org.springframework.shell.support.util.OsUtils;
import org.springframework.stereotype.Component;

/**
 * Clase que implementa la creación del Banner para el shell de Asterix
 * 
 * @author Daniel Pichardo
 * 
 */
@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class AsterixBanner implements BannerProvider {

    @Value("${asterix.version}")
    private String version;

    @Value("${asterix.welcome.message}")
    private String welcomeMessage;

    @Value("${asterix.banner.file}")
    private String asterixBannerFile;

    public String name() {
        return "Asterix";
    }

    @Override
    public String getBanner() {
        StringBuilder sb = new StringBuilder();
        sb.append(FileUtils.readBanner(AsterixBanner.class, asterixBannerFile));
        sb.append("Version:").append(getVersion())
                .append(OsUtils.LINE_SEPARATOR);
        sb.append(OsUtils.LINE_SEPARATOR);
        return sb.toString();
    }

    @Override
    public String getVersion() {
        return version + OsUtils.LINE_SEPARATOR;
    }

    @Override
    public String getWelcomeMessage() {
        return welcomeMessage + OsUtils.LINE_SEPARATOR + OsUtils.LINE_SEPARATOR
                + OsUtils.LINE_SEPARATOR;
    }

    public String getProviderName() {
        return "Asterix";
    }
}
