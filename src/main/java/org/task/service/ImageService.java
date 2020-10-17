package org.task.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.task.entity.Image;
import org.task.entity.Page;

@Service
public class ImageService {
    private final String LINK = "http://interview.agileengine.com/images";

    public Page getPage() {
        RestTemplate template = new RestTemplate();
        return template.getForObject(LINK, Page.class);
    }

    public Page getPage(int page) {
        RestTemplate template = new RestTemplate();
        return template.getForObject(LINK + "?page=" + page, Page.class);
    }

    public Image getImage(String id) {
        RestTemplate template = new RestTemplate();
        return template.getForObject(LINK + "/" + id, Image.class);
    }
}
