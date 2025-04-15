package com.chess.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true, nullable = false)
    private String email;

    private String password;

    private String role; // PLAYER, COACH, ADMIN

    private Integer rating; // Optional
    @Column(nullable = false)
    private Boolean enabled = true; // default to true if you want
    public String getPassword() {
        return password;
    }


}
