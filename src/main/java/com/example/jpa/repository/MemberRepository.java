package com.example.jpa.repository;

import com.example.jpa.entity.Member;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
public class MemberRepository {

    @PersistenceContext
    EntityManager em;

    public List<Member> getMembers() {
        return em.createQuery("select m from Member m", Member.class).getResultList();
    }

    @Transactional
    public Member addMember(Member member) {
        em.persist(member);
        em.flush();

        return member;
    }

}
