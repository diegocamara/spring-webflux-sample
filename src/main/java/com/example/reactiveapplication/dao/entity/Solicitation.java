package com.example.reactiveapplication.dao.entity;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.example.reactiveapplication.dao.entity.common.AbstractEntity;

@Document(collection = "solicitations")
public class Solicitation extends AbstractEntity {

    private static final long serialVersionUID = 1L;

    @TextIndexed
    private String title;

    private String content;

    @Indexed
    private String author;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

}
