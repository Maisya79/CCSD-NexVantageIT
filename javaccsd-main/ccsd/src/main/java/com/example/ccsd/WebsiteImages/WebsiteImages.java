package com.example.ccsd.WebsiteImages;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Base64;

@Document(collection = "WebsiteImage")
public class WebsiteImages {
    private String id;
    private String title;
    private String postShortDescription;
    private String date;
    private String status;
    private String tag;
    private String place;
    private String content;
    private String postSlug;
    private byte[] image;
    private String imageStore64String;


    public WebsiteImages(){
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getpostShortDescription() {
        return postShortDescription;
    }
    public void setpostShortDescription(String postShortDescription) {
        this.postShortDescription = postShortDescription;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getTag() {
        return tag;
    }
    public void setTag(String tag) {
        this.tag = tag;
    }
    public String getPlace() {
        return place;
    }
    public void setPlace(String place) {
        this.place = place;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public String getPostSlug() {
        return postSlug;
    }
    public void setPostSlug(String postSlug) {
        this.postSlug = postSlug;
    }
    public byte[] getimage() {
        return image;
    }
    public void setimage(byte[] image) {
        this.image = image;
    }
    public String getImage64String() {
        return Base64.getEncoder().encodeToString(image);
    }

    public void setImage64String(String imageStore64String) {
        this.imageStore64String = imageStore64String;
    }

}
