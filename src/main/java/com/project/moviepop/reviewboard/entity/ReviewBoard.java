package com.project.moviepop.reviewboard.entity;

import com.project.moviepop.audit.Auditable;
import com.project.moviepop.comment.entity.Comment;
import com.project.moviepop.user.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class ReviewBoard extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long reviewBoardId;
    private String title;
    private String review;
    private int wish;
    private String thumbnail;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    private User user;

    @OneToMany(mappedBy = "reviewBoard", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @OrderBy("commentId desc")
    private Set<Comment> comments = new LinkedHashSet<>();
}