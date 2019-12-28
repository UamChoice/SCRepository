package com.db.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 *
 */
@Document(value = "mongo_test_user") // JPA @Table
public class User {

    // 自增主键 必须唯一
    @Id
    private Long id;

    @Field(value = "user_name")
    private String name;

    public User() {

    }

    public User(Long id) {
        this.id = id;
    }


    public User(Long id, String name) {
        this.id = id;
        this.name = name;
    }

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
