package com.example.demo.controller.audit;

import com.example.demo.entity.Product;
import com.example.demo.service.ProductAuditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductAuditController {
    @Autowired
    private ProductAuditService productAuditService;

    @GetMapping("/{id}/revisions")
    public List<Product> getRevisions(@PathVariable("id") Long id) {
        return productAuditService.getRevisions(id);
    }
}
