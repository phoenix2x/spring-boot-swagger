package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;

/**
 */

public class RequestLoggingInterceptor implements ClientHttpRequestInterceptor {

	private final Logger log = LoggerFactory.getLogger(getClass());

 @Override
 public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
     ClientHttpResponse response = execution.execute(request, body);

     log.debug("request method: {}, request URI: {}, request headers: {}, request body: , response status code: {}, response headers: {}, response body:",
         request.getMethod(),
         request.getURI(),
         request.getHeaders(),
//         new String(body, Charset.forName("UTF-8")),
         response.getStatusCode(),
         response.getHeaders()
//         new String(ByteStreams.toByteArray(response.getBody()), Charset.forName("UTF-8"))
		);

     return response;
 }
}
