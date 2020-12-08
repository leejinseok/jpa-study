package com.example.jpa.service;

import com.example.jpa.entity.Member;
import com.example.jpa.repository.MemberRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;


    public List<Member> getMembers() {
        return memberRepository.getMembers();
    }

}
