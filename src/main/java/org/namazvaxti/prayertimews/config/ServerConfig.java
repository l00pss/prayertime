package org.namazvaxti.prayertimews.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.stereotype.Component;

@Component
public class ServerConfig implements WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> {
    @Value("${server.port}")
    int port;

    @Override
    public void customize(ConfigurableServletWebServerFactory server) {
        server.setPort(port);
    }
}