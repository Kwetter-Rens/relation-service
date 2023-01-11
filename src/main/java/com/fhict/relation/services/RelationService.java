package com.fhict.relation.services;

import com.fhict.relation.models.Relation;
import com.fhict.relation.repositories.RelationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RelationService {
    private final RelationRepository relationRepo;
    final static Logger logger = LoggerFactory.getLogger(RelationService.class);

    public RelationService(RelationRepository relationRepo) {
        this.relationRepo = relationRepo;
    }

    public List<String> getByUserId(String id) {
        return this.relationRepo.findByUserId(id);
    }

    public ResponseEntity<?> createRelation(Relation relation) {
        if(relationRepo.findByUserAndFollowingId(relation.getUserId(), relation.getFollowingUserId()) == null) {
            logger.info(relation.getUserId() + " is now following " + relation.getFollowingUserId());
            return new ResponseEntity<>(this.relationRepo.save(relation), HttpStatus.CREATED);
        }
        else {
            logger.warn(relation.getUserId() + " already follows " + relation.getFollowingUserId());
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    public Relation findByUserAndFollowingId(String currentUserId, String profileUserId) {
        Relation relation = this.relationRepo.findByUserAndFollowingId(currentUserId, profileUserId);
        logger.info("Returning relation: "+ relation);
        System.out.println(relation);
        return relation;
    }

    public void deleteRelation(Relation relation) {
        this.relationRepo.delete(relation);
    }
}
