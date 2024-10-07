/****************************************************************************
* Copyright 2021 (C) Andrey Tokmakov
* TestConfig.java class
*
* @name    : TestConfig.java
* @author  : Tokmakov Andrey
* @version : 1.0
* @since   : Jan 29, 2021
****************************************************************************/

package TestConfiguration.web_service;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;

import lombok.extern.log4j.Log4j2;

import java.time.Duration;

@Log4j2
@TestConfiguration
public class TestConfig {
	
	public TestConfig() {
		log.info("Configuration: " + this.getClass().getSimpleName() + " created!");
	}
	
    @Bean
    public RestTemplateBuilder restTemplateBuilder() {
    	log.info("RestTemplateBuilder::restTemplateBuilder() called");
        return new RestTemplateBuilder()
                .basicAuthentication("mkyong", "password")
                .setConnectTimeout(Duration.ofSeconds(5));
    }
}