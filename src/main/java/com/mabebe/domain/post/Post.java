package com.mabebe.domain.post;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long postId;

    @Column(nullable = false)
    private Long memberId;

    @Column(nullable = false, length = 255)
    private String description;

    @Column(nullable = false)
    private boolean liked;

    @Column(nullable = false)
    private boolean deleted;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date createdAt;

}
