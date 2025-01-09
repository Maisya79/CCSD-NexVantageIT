package com.example.ccsd.Products;

import com.mongodb.MongoTimeoutException;
import com.mongodb.client.MongoIterable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class productsService {
    
    @Autowired
    private productsRepository ProductsRepository;
    @Autowired
    private MongoTemplate mongoTemplate;

    public List<products> getAllProducts() {
        return ProductsRepository.findAll();
    }

    public Optional<products> getProductsById(String id) {
        return ProductsRepository.findById(id);
    }

    public products addProducts(products product) {
        return ProductsRepository.save(product);
    }
    // Update an existing product by ID
    public products updateProducts(String id, products productDetails) {
        return ProductsRepository.findById(id).map(existingProduct -> {
            existingProduct.setTitle(productDetails.getTitle());
            existingProduct.setPostSlug(productDetails.getPostSlug());
            existingProduct.setPostShortDescription(productDetails.getPostShortDescription());
            existingProduct.setTag(productDetails.getTag());
            existingProduct.setPlace(productDetails.getPlace());
            existingProduct.setDateProduct(productDetails.getDate());
            existingProduct.setStatus(productDetails.getStatus());
            existingProduct.setImageStore(productDetails.getImageStore());
            return ProductsRepository.save(existingProduct);
        }).orElse(null);
    }

    // Delete a product by ID
    public void deleteProducts(String id) {
        ProductsRepository.deleteById(id);
    }

}