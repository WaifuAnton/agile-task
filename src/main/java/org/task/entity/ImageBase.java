package org.task.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ImageBase {
    private String id;

    @JsonProperty("cropped_picture")
    private String croppedPicture;
}
