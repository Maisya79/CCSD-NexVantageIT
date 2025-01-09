package com.example.ccsd.Gallery;

import com.mongodb.client.MongoIterable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class galleryService {
    
    @Autowired
    private galleryRepository GalleryRepository;

    public List<gallery> getAllGallerys() {
        return GalleryRepository.findAll();
    }

    public Optional<gallery> getGalleryById(String id) {
        return GalleryRepository.findById(id);
    }

    public gallery addGallery(gallery gallery) {
        return GalleryRepository.save(gallery);
    }

    public gallery updategallery(String id, gallery galleryDetails) {
        Optional<gallery> galleryDat = GalleryRepository.findById(id); //find the user ID for the user that wants to update their info
        //check if user exist
        if (galleryDat.isPresent()) {
            gallery updgalleryDat = galleryDat.get();

            //Set user data based on the new data given
            updgalleryDat.setTitle(galleryDetails.getTitle());
            updgalleryDat.setPostSlug(galleryDetails.getPostSlug());
            updgalleryDat.setpostShortDescription(galleryDetails.getPostShortDescription());
            updgalleryDat.setTag(galleryDetails.getTag());
            updgalleryDat.setPlace(galleryDetails.getPlace());
            updgalleryDat.setDate(galleryDetails.getDate());
            updgalleryDat.setStatus(galleryDetails.getStatus());
            updgalleryDat.setContent(galleryDetails.getContent());
            updgalleryDat.setImage(galleryDetails.getImage());
            return GalleryRepository.save(updgalleryDat); //return the object after finish setting all updated data
        } else{
            return null; //if not found, return nothing
        }
    }

    public void deletegallery(String id) {
        GalleryRepository.deleteById(id);
    }
}
