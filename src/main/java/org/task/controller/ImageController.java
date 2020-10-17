package org.task.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.task.entity.Image;
import org.task.entity.Page;
import org.task.service.ImageService;

@RestController("/images")
public class ImageController {
    private ImageService imageService;

    @Autowired
    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @GetMapping
    public Page getPictures(@RequestParam(defaultValue = "1") int page) {
        return imageService.getPage(page);
    }

    @GetMapping("/{id}")
    public Image getImage(@PathVariable String id) {
        return imageService.getImage(id);
    }
}
