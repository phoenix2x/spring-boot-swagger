package com.example.demo;

import com.example.demo.swagger.ebay.api.ItemApi;
import com.example.demo.swagger.ebay.api.ItemSummaryApi;
import com.example.demo.swagger.ebay.invoker.ApiClient;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

/**
 */
@Configuration
public class EbayClientConfig {

	@Value("${ebay.baseUrl}")
    private String serverBaseUrl;

	@Bean
	public ItemApi itemApi() {
		return new ItemApi(ebayApiClient());
	}

	@Bean
	public ItemSummaryApi itemSummaryApi() {
		return new ItemSummaryApi(ebayApiClient());
	}

	@Bean(name = "ebayApiClient")
	public ApiClient ebayApiClient() {
		ApiClient apiClient = new ApiClient(restTemplate());
		apiClient.setBasePath(serverBaseUrl);
		return apiClient;
	}

	@Bean
	@ConfigurationProperties("ebay.oauth2.client")
	protected ClientCredentialsResourceDetails oAuthDetails() {
		return new ClientCredentialsResourceDetails();
	}

	@Bean
	@Qualifier("ebay")
    protected RestTemplate restTemplate() {
		OAuth2RestTemplate restTemplate = new OAuth2RestTemplate(oAuthDetails());
		restTemplate.setAuthenticator(new CustomOAuth2RequestAuthentificator());
		restTemplate.setInterceptors(Collections.singletonList(new RequestLoggingInterceptor()));
		return restTemplate;
	}
}
