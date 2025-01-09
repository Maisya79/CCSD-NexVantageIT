package com.example.ccsd.Products;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Base64;


@Document(collection = "products")
public class products {
    private String id;
    private String title;
    private String postSlug;
    private String postShortDescription;
    private String tag;
    private String place;
    private String date;
    private String status;
    private byte[] image;
    private String imageStore;


    public products() {
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getPostSlug() {
        return postSlug;
    }
    public void setPostSlug(String postSlug) {
        this.postSlug = postSlug;
    }
    public String getPostShortDescription() {
        return postShortDescription;
    }
    public void setPostShortDescription(String postShortDescription) {
        this.postShortDescription = postShortDescription;
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
    public String getDate() {
        return date;
    }
    public void setDateProduct(String date) {
        this.date = date;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public byte[] getImageStore() {
        return image;
    }
    public void setImageStore(byte[] image) {
        this.image = image;
    }
    public String getImageAsBase64() {
        if (image == null) {
            return null;
        }
        return Base64.getEncoder().encodeToString(image);
    }

    public void setImageStore64String(String imageAsBase64) {
        if (imageAsBase64 == null) {
            return;
        }
        this.image = Base64.getDecoder().decode(imageAsBase64);
    }
}
