package com.example.ccsd.WebsiteTexts;
import com.example.ccsd.Users.users;
import com.mongodb.client.MongoIterable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WebsiteTextsService {

    @Autowired
    private WebsiteTextsRepository websiteTextsRepository;

    public List<WebsiteTexts> getAllText() {
        return websiteTextsRepository.findAll();
    }

    public Optional<WebsiteTexts> getTextById(String id) {
        return websiteTextsRepository.findById(id);
    }

    public WebsiteTexts addText(WebsiteTexts websiteTexts) {
        return websiteTextsRepository.save(websiteTexts);
    }

    public WebsiteTexts updateText(String id, WebsiteTexts textDetails) {
        Optional<WebsiteTexts> websiteTexts = websiteTextsRepository.findById(id);
        if (websiteTexts.isPresent()) {
            WebsiteTexts updwebtextDat = websiteTexts.get();

            //Set user data based on the new data given
            updwebtextDat.setPostShortDescription(textDetails.getPostShortDescription());
            updwebtextDat.setTag(textDetails.getTag());
            updwebtextDat.setTitle(textDetails.getTitle());
            updwebtextDat.setStatus(textDetails.getStatus());
            updwebtextDat.setPlace(textDetails.getPlace());
            return websiteTextsRepository.save(updwebtextDat); //return the object after finish setting all updated data
        } else{
            return null; //if not found, return nothing
        }
    }

    public void deleteText(String id) {
        websiteTextsRepository.deleteById(id);
    }
}
