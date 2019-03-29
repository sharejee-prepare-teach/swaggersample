package com.mkyong.models;

import javax.persistence.*;

/**
 * Create By: Ron Rith
 * Create Date on: 3/29/2019.
 */
@Entity
@Table(name = "test_model")
public class TestModel {
    private Long id;
    private String name;

    public TestModel(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public TestModel() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
