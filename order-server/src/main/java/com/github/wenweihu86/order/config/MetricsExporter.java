package com.github.wenweihu86.order.config;

import io.micrometer.prometheus.PrometheusMeterRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Component
public class MetricsExporter {
    private static Logger LOG = LoggerFactory.getLogger("metrics");

    @Autowired
    private PrometheusMeterRegistry prometheusMeterRegistry;

    private ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();

    @PostConstruct
    public void init() {
        executorService.scheduleWithFixedDelay(new Runnable() {
            @Override
            public void run() {
                String string = prometheusMeterRegistry.scrape();
                LOG.info(string);
            }
        }, 5, 1, TimeUnit.SECONDS);
    }

    @PreDestroy
    public void desctroy() {
        executorService.shutdown();
    }
}
