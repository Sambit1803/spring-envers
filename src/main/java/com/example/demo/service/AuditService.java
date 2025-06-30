package com.example.demo.service;

import com.example.demo.entity.User;
import jakarta.persistence.EntityManager;
import org.hibernate.envers.AuditReader;
import org.hibernate.envers.AuditReaderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuditService {

    private final EntityManager entityManager;

    public AuditService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<User> getRevisions(Long userId) {
        AuditReader auditReader = AuditReaderFactory.get(entityManager);

        List<Number> revisionNumbers = auditReader.getRevisions(User.class, userId);
        List<User> revisions = new ArrayList<>();

        for (Number rev : revisionNumbers) {
            User userRev = auditReader.find(User.class, userId, rev);
            revisions.add(userRev);
        }

        return revisions;
    }

    public User getRevision(Long userId, Number revision) {
        AuditReader auditReader = AuditReaderFactory.get(entityManager);
        return auditReader.find(User.class, userId, revision);
    }
}