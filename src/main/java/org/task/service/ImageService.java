package org.task.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
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

    public ImageService(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    public Page getPage() {
        RestTemplate template = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.AUTHORIZATION, authService.getToken());
        HttpEntity<String> entity = new HttpEntity<>("body", headers);
        return template.postForObject(LINK, entity, Page.class);
    }

    public Page getPage(int page) {
        RestTemplate template = new RestTemplate();
        return template.getForObject(LINK + "?page=" + page, Page.class);
    }

    public Image getImage(String id) {
        RestTemplate template = new RestTemplate();
        return template.getForObject(LINK + "/" + id, Image.class);
    }

    public void saveAll(List<Image> images) {
        imageRepository.saveAll(images);
    }

    public List<Image> findAll(String param) {
        return imageRepository.findAllByParam(param);
    }
}
