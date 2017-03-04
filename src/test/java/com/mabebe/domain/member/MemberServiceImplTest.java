package com.mabebe.domain.member;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.persistence.PersistenceContext;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@Slf4j
@RunWith(MockitoJUnitRunner.class)
public class MemberServiceImplTest {
    @Mock
    private MemberRepository memberRepository;

    @InjectMocks
    private MemberServiceImpl memberServiceimpl; // = new MemberServiceImpl();

    @Test
    public void save() throws Exception {
        //Member member1 = new Member(0, "sancho@sanc.om", "23", false);
        Member member1 = new Member();
        member1.setEmailId("sancho@san.com");
        member1.setPassword("11");
        member1.setDeleted(false);

        memberServiceimpl.save(member1);

        verify(memberRepository).save(member1);
        // TODO : capture라는 게 있다 repository에 들어가는 내용들을 확인할 수 있다
  //      List<Member> listMember = memberServiceimpl.findAll();
//        assertEquals(listMember.size(), 1);
    }

    @Test
    public void findAll() throws Exception {
        Member member1 = new Member(0, "sancho@sanc.om", "23", false);
        Member member2 = new Member(1, "haha@ah.com", "111", false);

        //memberRepository.save(member1);
        //memberRepository.save(member2);
        when(memberRepository.findAll()).thenReturn()

//TODO : given when then

        List<Member> listMember = memberServiceimpl.findAll();
        log.info("listMember size : " + listMember.size());
        assertEquals(listMember.size(), 2);

    }

    @Test
    public void findByEmailId() throws Exception {
        Member member1 = new Member(0, "sancho@sanc.om", "1111", false);
        //memberRepository.save(member1);

        Member returnMember = memberServiceimpl.findByEmailId("sancho@sanc.om");
        assertNotNull(returnMember);
    }

    @Test
    public void login() throws Exception {

    }

    @Test
    public void signup() throws Exception {
        Member member1 = new Member(0, "sancho@sanc.om", "23", false);
        Member member2 = new Member(1, "haha@ah.com", "111", false);
        Member member3 = new Member(2, "haha@ah.com", "111", false);
        Member member4 = new Member(1, "124@ah.com", "111", false);

        assertTrue(memberServiceimpl.signup(member1));
        assertTrue(memberServiceimpl.signup(member2));
        assertFalse(memberServiceimpl.signup(member3));
        assertTrue(memberServiceimpl.signup(member4));

    }


}