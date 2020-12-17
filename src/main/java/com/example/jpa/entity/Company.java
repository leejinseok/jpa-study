package com.example.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Getter;

@Entity
@Getter
public class Company {

    @Id
    @Column(name = "c_id")
    private Long cid;

}
