package com.example.jwtspringsecurity.service;

import com.example.jwtspringsecurity.model.Product;
import com.example.jwtspringsecurity.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IProductService{



        @Autowired
        private ProductRepository productRepository;

        public Product saveProduct(Product product) {
            return productRepository.save(product);
        }

        public List<Product> getAllProducts() {
            return productRepository.findAll();
        }

        public Optional<Product> getProductById(Long id) {
            return productRepository.findById(id);
        }

        public Product updateProduct(Product product) {
            return productRepository.save(product);
        }

        public void deleteProduct(Long id) {
            productRepository.deleteById(id);
        }

    @Override
    public Product updateProductId(Long id, Product product) {
        Optional<Product> productToUpdateOptional = productRepository.findById(id);
        if (productToUpdateOptional.isPresent()) {
            Product productToUpdate = productToUpdateOptional.get();
            productToUpdate.setName(product.getName());
            productToUpdate.setPrice(product.getPrice());
            productRepository.save(productToUpdate);
        } else {
            return  null;
        }
        return  null;
    }



    }

