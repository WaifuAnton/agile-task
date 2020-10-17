package org.task.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.task.config.Constants;
import org.task.entity.Image;
import org.task.entity.Page;
import org.task.service.ImageService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CacheScheduler {
    private ImageService imageService;

    public CacheScheduler(ImageService imageService) {
        this.imageService = imageService;
    }

    @Scheduled(fixedDelay = Constants.CACHE_PERIOD)
    public void cache() {
        Page page;
        List<Image> images = new ArrayList<>();
        int i = 1;
        do {
          page = imageService.getPage(i);
          images.addAll(page.getPictures().stream()
                  .map(imageBase -> imageService.getImage(imageBase.getId()))
                  .collect(Collectors.toList()));
          i++;
        } while (page.isHasMore());
        imageService.saveAll(images);
    }
}
