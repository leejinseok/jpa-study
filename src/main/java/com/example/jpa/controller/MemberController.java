package com.example.jpa.controller;

import com.example.jpa.entity.Member;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberController {

    @PersistenceContext
    EntityManager em;

    @GetMapping("/test/proxy")
    public void testProxy() {
        Member memberProxy = em.getReference(Member.class, 1L);
        System.out.println("memberProxy = " + memberProxy.getClass().getName());
    }

}
