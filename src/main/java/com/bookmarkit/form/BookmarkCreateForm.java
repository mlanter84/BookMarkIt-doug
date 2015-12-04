package com.bookmarkit.form;

import com.bookmarkit.domain.User;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.URL;

import javax.persistence.ForeignKey;

/**
 * Created by 580782 on 11/25/2015.
 */
public class BookmarkCreateForm {

    @NotEmpty
    @URL
    private String url="";

    private String description="";

    private User user;

    public BookmarkCreateForm() { }

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

    public void setUser(User user) {
        this.user = user;
    }
}
