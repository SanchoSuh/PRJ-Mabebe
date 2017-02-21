package com.mabebe.domain.member;


import com.mabebe.exception.MBBMemberException;

import java.util.List;

public interface MemberService {
    <T extends Member> List<T> findAll();

    <T extends Member> T findByEmailId(String emailId);

    boolean login(String id, String password) throws MBBMemberException;

    boolean signup(Member member) throws MBBMemberException;
}
