package com.ptit.personal.entity;

import lombok.Getter;

@Getter
public enum ContentType {
    JPG("image/jpeg"),
    PNG("image/png"),
    MP4("mp4");

    private String value;

    ContentType(String value) {
        this.value = value;
    }
}
