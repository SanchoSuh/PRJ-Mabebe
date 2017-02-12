package com.mabebe.controller;

import com.mabebe.domain.member.MemberRepository;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MemberController {

    @Autowired
    private MemberRepository memberRepository;

    @RequestMapping(value="/login", method= RequestMethod.GET)
    public String ctrLogin(Model model) {

        return "/member/loginForm";
    }

    @RequestMapping(value="/loginCommit", method= RequestMethod.POST)
    public String loginCommit(Model model) {

        return "";
    }
}
