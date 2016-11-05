/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.patrones.software.serviciorest;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.patrones.software.serviciorest.recursos.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.boot.autoconfigure.web.HttpMessageConvertersAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 *
 * @author sebastianpacheco
 */
@Configuration
@EnableAutoConfiguration
@ConfigurationProperties()
@PropertySource("classpath:application.properties")
public class SpringBootConfig {

    @Bean
    public RestController getRestController() {
        return new RestController();
    }

//    @Autowired(required = true)
//    public void configeJackson(ObjectMapper jackson2ObjectMapper) {
//        jackson2ObjectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
//    }
//    @Bean
//    public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {
//        MappingJackson2HttpMessageConverter jsonConverter = new MappingJackson2HttpMessageConverter();
//        ObjectMapper objectMapper = new ObjectMapper();
//        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
//        jsonConverter.setObjectMapper(objectMapper);
//        return jsonConverter;
//    }
    
}
