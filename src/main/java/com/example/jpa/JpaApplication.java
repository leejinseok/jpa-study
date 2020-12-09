package com.example.jpa;

import com.example.jpa.entity.Address;
import com.example.jpa.entity.Member;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JpaApplication implements CommandLineRunner {

    @PersistenceContext
    EntityManager em;

    public static void main(String[] args) {
        SpringApplication.run(JpaApplication.class, args);
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        Member member = new Member();
        member.setUserName("이진석");

        Member member1 = new Member();
        member.setUserName("홍길동");

        Member member2 = new Member();
        member2.setUserName("임꺽정");

//        값 타입 컬렉션 예제
//        member2.getAddressHistory().add(new Address("서울", "강남", "123-123"));

        em.persist(member);
        em.persist(member1);
        em.persist(member2);
    }
}
