package com.media.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by Kazimirov on 28.03.2017.
 */
@Configuration
@EnableAutoConfiguration
@EntityScan(basePackages = {"com.media.entity"})
@EnableJpaRepositories(basePackages = {"com.media.repository"})
@EnableTransactionManagement
public class RepositoryConfiguration {
}
