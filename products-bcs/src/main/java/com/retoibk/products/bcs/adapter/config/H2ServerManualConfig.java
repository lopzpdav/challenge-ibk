package com.retoibk.products.bcs.adapter.config;
import lombok.extern.slf4j.Slf4j;
import org.h2.tools.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import static org.h2.tools.Server.createWebServer;

/**
 * @author Ricardo Santos
 */
@Slf4j
@Component
public class H2ServerManualConfig {

    private Server webServer;

    @Value("${h2-server.port}")
    Integer h2ConsolePort;

    @EventListener(ContextRefreshedEvent.class)
    public void start() throws java.sql.SQLException {
        log.info("starting h2 console at port "+ h2ConsolePort);
        this.webServer = createWebServer("-webPort", h2ConsolePort.toString(),
                "-tcpAllowOthers").start();
        log.info("webServer.getURL() -> {}",webServer.getURL());
    }

    @EventListener(ContextClosedEvent.class)
    public void stop() {
        log.info("stopping h2 console at port "+h2ConsolePort);
        this.webServer.stop();
    }
}
