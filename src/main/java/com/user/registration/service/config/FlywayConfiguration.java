package com.user.registration.service.config;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManagerFactory;
import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.configuration.FluentConfiguration;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
public class FlywayConfiguration {

    @Bean
    @Primary
    @ConfigurationProperties(prefix = "datasource.bankservice")
    public DataSource dataSource(){
        return  DataSourceBuilder.create().build();
    }

    @PostConstruct
    public void flyway(){
        FluentConfiguration config = Flyway.configure()
                .baselineOnMigrate(true)
                .dataSource(dataSource())
                .outOfOrder(true)
                .schemas("bankservice");
        Flyway flyway = new Flyway(config);
        flyway.migrate();
    }

    @Primary
    @Bean(name = "entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(EntityManagerFactoryBuilder builder,
                                                                           @Qualifier("dataSource") DataSource dataSource){
        return builder
                .dataSource(dataSource)
                .packages("com.user.registration.service.entity")
                .persistenceUnit("migration")
                .build();
    }

    @Primary
    @Bean(name = "transactionManager")
    public PlatformTransactionManager transactionManager(@Qualifier("entityManagerFactory")
                                                         EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}
