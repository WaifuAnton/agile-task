package org.task.scheduler;

import org.springframework.scheduling.annotation.Scheduled;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class CacheScheduler {
    @Scheduled(fixedDelay = 5000)
    public void cache() {
        try (ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream("images.cache"))) {

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
