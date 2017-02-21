package com.mabebe.controller;

import com.mabebe.domain.member.MemberRepository;
import com.mabebe.domain.member.MemberService;
import com.mabebe.domain.member.Member;
import com.mabebe.exception.MBBMemberException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Slf4j
@Controller
public class MemberController {

    @Autowired
    private MemberService memberService;

    @RequestMapping(value="/login", method= RequestMethod.GET)
    public String loginForm(Model model) {
        log.debug("blablablablal");

        return "/member/loginForm";
    }

    @RequestMapping(value="/login", method= RequestMethod.POST)
    public String loginCommit(String email, String password, Model model) throws MBBMemberException{
        boolean result = memberService.login(email, password);

        if(result == true) {
            return "redirect:/";
        }
        else
            return "";
    }

    @RequestMapping(value="/signup", method=RequestMethod.GET)
    public String signUpForm(Model model) {
        log.info("in signUpForm() controller");

        return "/member/signupForm";
    }

    @RequestMapping(value="/signup", method=RequestMethod.POST)
    public String signUp(Member member, Model model) throws MBBMemberException {
        log.info("in signUp() controller");
        boolean result = memberService.signup(member);

        if(result == true) {
            return "redirect:/";
        } else
            return "";
    }
}
