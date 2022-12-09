package com.fhict.relation.repositories;

import com.fhict.relation.models.Relation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RelationRepository extends JpaRepository<Relation, Integer> {
    @Query("select r.followingUserId from Relation r where r.userId=:userId")
    List<String> findByUserId(@Param("userId") String userId);

    @Query("select r from Relation r where r.userId=:currentUserId and r.followingUserId=:profileUserId")
    Relation findByUserAndFollowingId(@Param("currentUserId") String currentUserId, @Param("profileUserId") String profileUserId);
}
