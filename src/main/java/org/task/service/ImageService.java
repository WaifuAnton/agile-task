package org.task.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.task.entity.Image;
import org.task.entity.Page;
import org.task.repository.ImageRepository;

import java.util.List;

@Service
public class ImageService {
    private final String LINK = "http://interview.agileengine.com/images";

    private ImageRepository imageRepository;
    private AuthService authService;

    private String auth;

    public ImageService(ImageRepository imageRepository, AuthService authService) {
        this.imageRepository = imageRepository;
        this.authService = authService;
    }

    public Page getPage(int page) {
        RestTemplate template = new RestTemplate();
        HttpEntity<String> entity = addAuthHeader();
        ResponseEntity<Page> responseEntity = template.exchange(LINK + "?page=" + page, HttpMethod.GET, entity, Page.class);
        return responseEntity.getBody();
    }

    public Image getImage(String id) {
        RestTemplate template = new RestTemplate();
        HttpEntity<String> entity = addAuthHeader();
        ResponseEntity<Image> responseEntity = template.exchange(LINK + "/" + id, HttpMethod.GET, entity, Image.class);
        return responseEntity.getBody();
    }

    public void saveAll(List<Image> images) {
        imageRepository.saveAll(images);
    }

    public List<Image> findAll(String param) {
        return imageRepository.findAllByParam(param);
    }

    private HttpEntity<String> addAuthHeader() {
        HttpHeaders headers = new HttpHeaders();
        if (auth == null)
            auth = authService.getToken();
        headers.add(HttpHeaders.AUTHORIZATION, auth);
        return new HttpEntity<>(headers);
    }
}
