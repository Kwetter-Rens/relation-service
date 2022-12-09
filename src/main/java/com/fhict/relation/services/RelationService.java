package com.fhict.relation.services;

import com.fhict.relation.models.Relation;
import com.fhict.relation.repositories.RelationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RelationService {
    private final RelationRepository relationRepo;

    public RelationService(RelationRepository relationRepo) {
        this.relationRepo = relationRepo;
    }

    public List<String> getByUserId(String id) {
        return this.relationRepo.findByUserId(id);
    }

    public void createRelation(Relation relation) {
        this.relationRepo.save(relation);
    }

    public Relation findByUserAndFollowingId(String currentUserId, String profileUserId) {
        return this.relationRepo.findByUserAndFollowingId(currentUserId, profileUserId);
    }

    public void deleteRelation(Relation relation) {
        this.relationRepo.delete(relation);
    }
}
