package com.author;

import com.author.controller.HibernateAwareObjectMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.TypeExcludeFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.bind.annotation.CrossOrigin;

//@ComponentScan(
//        excludeFilters = {
//                @ComponentScan.Filter(
//                        type = FilterType.CUSTOM,
//                        classes = {TypeExcludeFilter.class}
//                )}
//)
@SpringBootApplication
@CrossOrigin("*")
public class BooKAuthorApplication {

    public static void main(String[] args) {
        SpringApplication.run(BooKAuthorApplication.class, args);
    }

    @Bean
    public ObjectMapper objectMapper() {
        return (new HibernateAwareObjectMapper());
    }
}



