package com.mabebe.domain.member;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
public class MemberTest {
    @Test
    public void equalPassword() throws Exception {
        Member member = new Member(0, "sansa@san.com", "1234", false);
        assertFalse(member.equalPassword("2222"));
        assertTrue(member.equalPassword("1234"));
    }

}