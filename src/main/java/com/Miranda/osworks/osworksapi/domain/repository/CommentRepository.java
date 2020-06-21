package com.Miranda.osworks.osworksapi.domain.repository;

import com.Miranda.osworks.osworksapi.domain.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Long> {
}
