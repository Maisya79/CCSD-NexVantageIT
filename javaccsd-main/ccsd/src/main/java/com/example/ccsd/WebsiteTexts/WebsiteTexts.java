package com.example.ccsd.WebsiteTexts;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Base64;

@Document(collection = "websitetexts")
public class WebsiteTexts {
    private String id;
    private String postShortDescription;
    private String tag;
    private String title;
    private String status;
    private String place;
   // private String postSlug;
  //  private String date;
  //  private byte[] image;
 //   private String imageStore64String;

    public WebsiteTexts() {
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
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
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getPlace() {
        return place;
    }
    public void setPlace(String place) {
        this.place = place;
    }
}



