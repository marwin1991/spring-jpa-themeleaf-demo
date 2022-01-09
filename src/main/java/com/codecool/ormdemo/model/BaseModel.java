package com.codecool.ormdemo.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class BaseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //UUID, BigInteger, String

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
