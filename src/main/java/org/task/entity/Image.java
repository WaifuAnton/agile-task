package org.task.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class Image implements Serializable {
    private String id;
    private String author;
    private String camera;
    private String tags;

    @JsonProperty("cropped_picture")
    private String croppedPicture;

    @JsonProperty("full_picture")
    private String fullPicture;
}
