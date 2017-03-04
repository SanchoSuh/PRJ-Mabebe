package com.mabebe.domain.profile;


import com.mabebe.domain.member.Member;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;

@Entity
@Data
@Table(name = "profile")
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "profileId")
    private long profileId;

    @OneToOne
    @JoinColumn(name = "member_Id", nullable = false, unique = true)
    private Member member;

    //public Profile() { ; }

    public Profile(Member member) {
        this.member = member;
    }

}
