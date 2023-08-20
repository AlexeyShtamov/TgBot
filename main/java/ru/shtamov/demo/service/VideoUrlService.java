package ru.shtamov.demo.service;

import org.springframework.stereotype.Service;

@Service
public interface VideoUrlService {
    void setVideoUrl(String url);

    String getVideoUrl();

}
