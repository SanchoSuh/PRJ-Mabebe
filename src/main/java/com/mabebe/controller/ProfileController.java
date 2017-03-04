package com.mabebe.controller;

import com.mabebe.domain.member.Member;
import com.mabebe.domain.member.MemberRepository;
import com.mabebe.domain.profile.Profile;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Slf4j
@Controller
public class ProfileController {
    @Autowired
    private MemberRepository memberRepository;

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String profileForm(Model model) {
        Member member = memberRepository.findOne((long) 1);
        log.info("member : " + member);

        Profile profile = new Profile(member);
        model.addAttribute(profile);

        return "/profile/profileForm";
    }
}
