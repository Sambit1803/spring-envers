package com.example.demo.controller.audit;

import com.example.demo.entity.User;
import com.example.demo.service.AuditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserAuditController {

    @Autowired
    private AuditService auditService;

    @GetMapping("/{id}/revisions")
    public List<User> getRevisions(@PathVariable("id") Long id) {
        return auditService.getRevisions(id);
    }
}
