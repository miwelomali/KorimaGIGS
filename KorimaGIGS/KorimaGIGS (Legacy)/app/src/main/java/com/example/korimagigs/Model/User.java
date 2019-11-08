package com.example.korimagigs.Model;

public class User {
    private String id;
    private String username;
    private String imageURL;
    private String type;

    public User(String id, String username, String imageURL, String type) {
        this.id = id;
        this.username = username;
        this.imageURL = imageURL;
        this.type = type;
    }

    public User() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
