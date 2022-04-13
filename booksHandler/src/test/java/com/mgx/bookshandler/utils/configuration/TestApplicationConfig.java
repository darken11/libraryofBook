package com.mgx.bookshandler.utils.configuration;


import com.mgx.bookshandler.web.converter.BookApiImplConverter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.mgx.bookshandler.web.converter")
public class TestApplicationConfig {
    @Bean
    public BookApiImplConverter bookApiConverter() {
        return new BookApiImplConverter() {

        };
    }
}
