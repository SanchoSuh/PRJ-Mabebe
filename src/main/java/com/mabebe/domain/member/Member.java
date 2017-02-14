package com.mabebe.domain.member;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Data
@Entity
public class Member {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    private long memberid;

    @Column(unique=true, nullable=false, length=30)
    private String emailId;

    @Column(nullable=false, length=20)
    private String password;

    @Column
    private boolean isDeleted;

}
