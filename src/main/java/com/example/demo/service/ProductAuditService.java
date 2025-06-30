package com.example.demo.service;

import com.example.demo.entity.Product;
import com.example.demo.entity.User;
import jakarta.persistence.EntityManager;
import org.hibernate.envers.AuditReader;
import org.hibernate.envers.AuditReaderFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductAuditService {

    private final EntityManager entityManager;

    public ProductAuditService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Product> getRevisions(Long productId) {
        AuditReader auditReader = AuditReaderFactory.get(entityManager);

        List<Number> revisionNumbers = auditReader.getRevisions(Product.class, productId);
        List<Product> revisions = new ArrayList<>();

        for (Number rev : revisionNumbers) {
            Product productRev = auditReader.find(Product.class, productId, rev);
            revisions.add(productRev);
        }

        return revisions;
    }
}
