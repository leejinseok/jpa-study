package com.example.jpa.controller;

import com.example.jpa.entity.Member;
import com.example.jpa.service.MemberService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/members")
    public List<Member> getMember() {
        return memberService.getMembers();
    }
}
