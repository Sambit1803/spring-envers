package com.example.demo.entity;

import com.example.demo.Listener.CustomRevisionListener;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrePersist;
import org.hibernate.envers.DefaultRevisionEntity;
import org.hibernate.envers.RevisionEntity;

import java.time.LocalDateTime;

@Entity
@RevisionEntity(CustomRevisionListener.class)
public class CustomRevisionEntity extends DefaultRevisionEntity {

    @Column(name="rev_timestamp")
    private LocalDateTime revTimestamp;

    @PrePersist
    public void prePersist() {
        revTimestamp = LocalDateTime.now();
    }

    public LocalDateTime getRevTimestamp() {
        return revTimestamp;
    }

    public void setRevTimestamp(LocalDateTime revTimestamp) {
        this.revTimestamp = revTimestamp;
    }
}
