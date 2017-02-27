package com.mabebe.domain.member;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Data
@Entity
@Table(name = "member")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "memberId")
    private long memberId;

    @Column(name = "emailId", unique=true, nullable=false, length=30)
    private String emailId;

    @Column(name = "password", nullable=false, length=20)
    private String password;

    @Column(name = "deleted")
    private boolean deleted;

    public Member(long memberId, String emailId, String password, boolean deleted) {
        this.memberId = memberId;
        this.emailId = emailId;
        this.password = password;
        this.deleted = deleted;
    }

    public boolean equalPassword(String inputPassword) {
        if(this.password.equals(inputPassword))
            return true;
        return false;
    }
}
