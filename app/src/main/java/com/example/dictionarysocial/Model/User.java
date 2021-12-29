package com.example.dictionarysocial.Model;
public class User {
    private String id;
    private String username;
    private String email,description,language,language_level;
    private String passwordEncryption;
    private String imageUrl;

    public User() {
    }

    public User(String id, String username, String email, String description, String language, String language_level, String passwordEncryption, String imageUrl) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.description = description;
        this.language = language;
        this.language_level = language_level;
        this.passwordEncryption = passwordEncryption;
        this.imageUrl = imageUrl;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getLanguage_level() {
        return language_level;
    }

    public void setLanguage_level(String language_level) {
        this.language_level = language_level;
    }

    public String getPasswordEncryption() {
        return passwordEncryption;
    }

    public void setPasswordEncryption(String passwordEncryption) {
        this.passwordEncryption = passwordEncryption;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}