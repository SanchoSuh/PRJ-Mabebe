package com.mabebe.controller;


import com.mabebe.domain.member.MemberRepository;
import com.mabebe.domain.member.Member;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Slf4j
@Controller
public class MainController {
    @Autowired
    private MemberRepository memberRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String runMainApplication(Model model) {
        model.addAttribute("member", memberRepository.findAll());

        log.debug("Here?");

        return "/index";
    }
}
