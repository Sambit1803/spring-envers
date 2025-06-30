package com.example.demo.controller;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.data.history.Revision;
import org.springframework.data.history.Revisions;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping
    public List<Product> getProduct() {
        return productRepository.findAll();
    }

    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable("id") Long id, @RequestBody Product updatedProduct) {
        Product product = productRepository.findById(id).get();
        product.setProductName(updatedProduct.getProductName());
        product.setPrice(updatedProduct.getPrice());
        return productRepository.save(product);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable("id") Long id) {
        productRepository.deleteById(id);
    }

//    @GetMapping("/revisions/{id}")
//    public List<Product> getProductRevisions(@PathVariable("id") Long id) {
//        Revisions<Long, Product> revisions = productRepository.findRevisions(id);
//        List<Revision<Long, Product>> products = revisions.getContent();
//        List<Product> productList = new ArrayList<>();
//
//        for (Revision<Long, Product> revision : products) {
//            productList.add(revision.getRevisionNumber());
//        }
//    }
}
