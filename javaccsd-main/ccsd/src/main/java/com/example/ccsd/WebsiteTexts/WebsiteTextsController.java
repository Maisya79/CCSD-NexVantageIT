package com.example.ccsd.WebsiteTexts;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.ccsd.Users.users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/website-texts")
public class WebsiteTextsController {

    @Autowired
    private WebsiteTextsService websiteTextsService;

    @GetMapping
    public List<WebsiteTexts> getAllText() {
        return websiteTextsService.getAllText();
    }

    @GetMapping("/{id}")
    public ResponseEntity<WebsiteTexts> getTextById(@PathVariable String id) {
        return websiteTextsService.getTextById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public WebsiteTexts addText(@RequestBody WebsiteTexts websiteTexts) {
        return websiteTextsService.addText(websiteTexts);
    }


     @PutMapping("/{id}")
    public ResponseEntity<WebsiteTexts> updateText(@PathVariable String id, @RequestBody WebsiteTexts textDetails) {
        WebsiteTexts updatedText = websiteTextsService.updateText(id, textDetails);
        if (updatedText != null) {
            return ResponseEntity.ok(updatedText);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteText(@PathVariable String id) {
        websiteTextsService.deleteText(id);
        return ResponseEntity.noContent().build();
    }

}
