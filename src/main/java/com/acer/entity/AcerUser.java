package com.acer.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "acer_user")
public class AcerUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "username", unique = true, length = 500)
    private String username;

    @Column(name = "email", nullable = false, length = 500)
    private String email;

    @Column(name = "password", nullable = false, length = 500)
    private String password;

}