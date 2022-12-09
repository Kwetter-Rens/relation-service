package com.fhict.relation.controllers;

import com.fhict.relation.models.Relation;
import com.fhict.relation.repositories.RelationRepository;
import com.fhict.relation.services.RelationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/relation")
public class RelationController {
    private final RelationService relationService;

    public RelationController(RelationService relationService) {
        this.relationService = relationService;
    }

    @GetMapping("/{userId}")
    public List<String> getRelationsByUserId(@PathVariable String userId) {
        return this.relationService.getByUserId(userId);
    }

    @PostMapping()
    public void createRelation(@RequestBody Relation relation) {
        this.relationService.createRelation(relation);
    }

    @DeleteMapping("/{currentUserId}/{profileUserId}")
    public void deleteRelation(@PathVariable String currentUserId, @PathVariable String profileUserId) {
        Relation relation = this.relationService.findByUserAndFollowingId(currentUserId, profileUserId);
        if(relation != null) {
            this.relationService.deleteRelation(relation);
        }
    }

    @GetMapping("/test")
    public String test() {
        return "test from RelationService";
    }
}
