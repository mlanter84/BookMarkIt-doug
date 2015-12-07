package com.bookmarkit.domain;

import org.hibernate.validator.constraints.URL;

import javax.persistence.*;

/**
 * Created by 580782 on 11/25/2015.
 */

@Entity
public class Bookmark {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String url;

    @Column(length = 2048)
    private String description;

    @ManyToOne()
    private User user;

    public Bookmark() { }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Bookmark{" +
                "url='" + url + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
