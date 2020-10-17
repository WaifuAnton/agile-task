package org.task.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "images")
public class Image implements Serializable {
    @Id
    private String id;
    private String author;
    private String camera;
    private String tags;

    @JsonProperty("cropped_picture")
    private String croppedPicture;

    @JsonProperty("full_picture")
    private String fullPicture;
}
