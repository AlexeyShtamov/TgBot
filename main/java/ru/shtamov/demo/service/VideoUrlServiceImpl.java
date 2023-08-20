package ru.shtamov.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.shtamov.demo.client.TestClient;

@Service
public class VideoUrlServiceImpl implements VideoUrlService{
    private final TestClient testClient;
    @Autowired
    public VideoUrlServiceImpl(TestClient testClient) {
        this.testClient = testClient;
    }


    @Override
    public void setVideoUrl(String url) {

    }

    @Override
    public String getVideoUrl(String url) {

        return url + " (getVideoUrl получил строку)";
    }
}
