package ru.shtamov.demo.client;

import org.jsoup.Jsoup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import org.jsoup.*;
import org.jsoup.nodes.*;
import org.jsoup.select.*;
import java.io.*;


@Component
public class TestClient {

    private RestTemplate restTemplate;

    @Autowired
    public TestClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void restTemplate(){
        Document document;
        try {
            document = Jsoup.connect("url").get();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        document
    }

}
