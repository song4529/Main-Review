package com.project.moviepop.reviewboard.repository;

import com.project.moviepop.reviewboard.entity.ReviewBoard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewBoardRepository extends JpaRepository<ReviewBoard, Long> {
}
