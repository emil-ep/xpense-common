package org.xperia.client;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public abstract class AbstractHttpClient {

    private final RestTemplate restTemplate;


    protected AbstractHttpClient(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }


    protected <R> ResponseEntity<R> executeGet(String url, HttpHeaders httpHeaders,  Class<R> responseType){
        return execute(url, HttpMethod.GET,  httpHeaders, responseType);
    }

    protected <T, R> ResponseEntity<R> executePost(
            String url,
            T body,
            HttpHeaders httpHeaders,
            Class<R> responseType){

        return execute(url, HttpMethod.POST, body, httpHeaders, responseType);
    }

    protected <T, R> ResponseEntity<R> executePut(
            String url,
            T body,
            HttpHeaders httpHeaders,
            Class<R> responseType){

        return execute(url, HttpMethod.PUT, body, httpHeaders, responseType);
    }

    protected <R> ResponseEntity<R> execute(String url,
                                            HttpMethod httpMethod,
                                            HttpHeaders httpHeaders,
                                            Class<R> responseType){

        HttpEntity<Void> request = new HttpEntity<>(httpHeaders);
        return execute(url, request, httpMethod, responseType);
    }


    protected <T, R> ResponseEntity<R> execute(
            String url,
            HttpMethod httpMethod,
            T body,
            HttpHeaders httpHeaders,
            Class<R> responseType){

        HttpEntity<T> request = new HttpEntity<>(body, httpHeaders);
        return execute(url, request, httpMethod, responseType);
    }


    protected <T, R> ResponseEntity<R> execute(
            String url,
            HttpEntity<T> request,
            HttpMethod httpMethod,
            Class<R> responseType){

        return this.restTemplate.exchange(
                url,
                httpMethod,
                request,
                responseType);
    }
}
