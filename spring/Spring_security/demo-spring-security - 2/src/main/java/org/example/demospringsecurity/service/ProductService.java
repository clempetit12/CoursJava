package org.example.demospringsecurity.service;

import org.example.demospringsecurity.entity.Product;
import org.example.demospringsecurity.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private final ProductRepository productRepository;


    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAll() {
        return productRepository.findAll();
    }

    public Product getById(Long id) {
        return productRepository.findProductById(id);
    }

    public Product createProduct(Product product) {
        return  productRepository.save(product);

    }

    public void deleteProduct(Product product) {
        if(product != null){
            productRepository.delete(product);
        }
    }

    public Product updateProduct(Long id, Product product) {
        Product productToUpdate = productRepository.findProductById(id);
        if(productToUpdate!=null) {
            productToUpdate.setName(product.getName());
            productToUpdate.setPrice(product.getPrice());
            productRepository.save(productToUpdate);
            return productToUpdate;
        }
     return null;

    }

}
