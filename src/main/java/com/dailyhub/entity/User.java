package com.dailyhub.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "user")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String username;
    private String avatar;
    private String openId;
    private LocalDateTime lasted;
    private LocalDateTime created;
}
