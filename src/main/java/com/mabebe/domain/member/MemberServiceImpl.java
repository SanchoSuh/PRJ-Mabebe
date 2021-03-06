package com.mabebe.domain.member;

import com.mabebe.exception.MBBMemberException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberRepository memberRepository;

    @Override
    public List<Member> findAll() {
        return memberRepository.findAll();
    }

    @Override
    public Member findByEmailId(String emailId) {
        return memberRepository.findByEmailId(emailId);
    }

    @Override
    public void save(Member member) {
        memberRepository.save(member);
    }

    @Override
    public boolean login(String id, String password) throws MBBMemberException {
        Member member = memberRepository.findByEmailId(id);

        if(member == null) {
            throw new MBBMemberException("EmailId not found");
        }

        if(member.equalPassword(password)) {
            log.debug("password correct");
            // Set cookie

            return true;
        }

        return false;
    }

    @Override
    public boolean signup(Member member) throws MBBMemberException {
        Member tempMember = memberRepository.findByEmailId(member.getEmailId());
        log.info("tempMember : " + tempMember);

        if(tempMember != null && !tempMember.equals("")) {
            log.info("signup : same emailID found while signup. TempMember : " + tempMember);
            return false;
        } else {
            log.info("signup : save(). Member : " + member);
            memberRepository.save(member);
            return true;
        }
    }
}
