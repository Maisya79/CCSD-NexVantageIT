package com.example.ccsd.WebsiteImages;


import com.example.ccsd.Users.users;
import com.mongodb.client.MongoIterable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WebsiteImagesService {
    

    @Autowired
    private WebsiteImagesRepository websiteImagesRepository;


    public List<WebsiteImages> getAllWebsiteImageses() {
        return websiteImagesRepository.findAll();
    }

    public Optional<WebsiteImages> getWebsiteImagesById(String id) {
        return websiteImagesRepository.findById(id);
    }

    public WebsiteImages addWebsiteImages(WebsiteImages websiteImages) {
        return websiteImagesRepository.save(websiteImages);
    }

    public WebsiteImages updateWebsiteImages(String id, WebsiteImages websiteImagesDetails) {
        Optional<WebsiteImages> webDat = websiteImagesRepository.findById(id); //find the user ID for the user that wants to update their info
        //check if user exist
        if (webDat.isPresent()) {
            WebsiteImages updWebDat = webDat.get();

            //Set user data based on the new data given
            updWebDat.setTitle(websiteImagesDetails.getTitle());
            updWebDat.setpostShortDescription(websiteImagesDetails.getpostShortDescription());
            updWebDat.setDate(websiteImagesDetails.getDate());
            updWebDat.setStatus(websiteImagesDetails.getStatus());
            updWebDat.setTag(websiteImagesDetails.getTag());
            updWebDat.setPlace(websiteImagesDetails.getPlace());
            updWebDat.setContent(websiteImagesDetails.getContent());
            updWebDat.setPostSlug(websiteImagesDetails.getPostSlug());
            updWebDat.setimage(websiteImagesDetails.getimage());
            return websiteImagesRepository.save(updWebDat); //return the object after finish setting all updated data
        } else{
            return null; //if not found, return nothing
        }
    }

    public void deleteWebsiteImages(String id) {
        websiteImagesRepository.deleteById(id);
    }
}