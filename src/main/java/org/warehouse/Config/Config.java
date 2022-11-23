package org.warehouse.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.warehouse.Entity.Worker;

@Configuration
@ComponentScan("org.warehouse.Entity")
public class Config {

    @Bean
    @Scope("prototype")
    public Worker Mishka() {
        return new Worker();
    }
    @Bean
    @Scope("prototype")
    public Worker Zelya() {
        return new Worker();
    }
}
