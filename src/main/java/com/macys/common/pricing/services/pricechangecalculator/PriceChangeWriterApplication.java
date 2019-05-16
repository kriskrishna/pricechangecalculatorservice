package com.macys.common.pricing.services.pricechangecalculator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;

import com.microsoft.spring.data.gremlin.repository.config.EnableGremlinRepositories;

@SpringBootApplication
@EnableAutoConfiguration(exclude = { MongoAutoConfiguration.class, MongoDataAutoConfiguration.class })
public class PriceChangeWriterApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(PriceChangeWriterApplication.class, args);
    }

}
