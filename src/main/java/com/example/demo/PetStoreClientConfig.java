package com.example.demo;

import com.example.demo.swagger.petstore.api.PetApi;
import com.example.demo.swagger.petstore.invoker.ApiClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 */
@Configuration
public class PetStoreClientConfig {

    @Bean
    public PetApi petApi() {
        return new PetApi(petStoreApiClient());
    }

    @Bean
    public ApiClient petStoreApiClient() {
        return new ApiClient();
    }
}
