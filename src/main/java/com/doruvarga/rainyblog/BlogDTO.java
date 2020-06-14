package com.doruvarga.rainyblog;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BlogDTO {
    //@JsonProperty(name="contentSchimbat")
    private String content;
    private String title;
    private Integer id;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
