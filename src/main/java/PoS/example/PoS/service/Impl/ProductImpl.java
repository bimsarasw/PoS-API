package PoS.example.PoS.service.Impl;

import PoS.example.PoS.dtos.*;
import PoS.example.PoS.entity.*;
import PoS.example.PoS.repo.ProductRepo;
import PoS.example.PoS.service.ProductService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class ProductImpl implements ProductService {

    @Autowired
    private  ProductRepo productRepo;

    @Override
    public Product addProduct(ProductDTO productDTO){
        Product product = new Product();

        product.setProductName(productDTO.getProductName());
        product.setProductPrice(productDTO.getProductPrice());
        product.setCostPrice(productDTO.getCostPrice());
        product.setItemCategory(productDTO.getItemCategory());
        product.setDescription(productDTO.getDescription());
        return productRepo.save(product);
    }

    @Override
    public Product updateProduct(@NotNull String productId, @NotNull ProductDTO productDTO) {
        Optional<Product> existingProduct = productRepo.findById(productId);
        if (existingProduct.isPresent()) {
            Product product = existingProduct.get();
            product.setProductName(productDTO.getProductName());
            product.setProductPrice(productDTO.getProductPrice());
            product.setCostPrice(productDTO.getCostPrice());
            product.setItemCategory(productDTO.getItemCategory());
            return productRepo.save(product);  // Save the updated user
        } else {
            throw new RuntimeException("User not found with ID: " + productId);
        }
    }
}
