package com.umair.PropertyManagement.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.umair.PropertyManagement.Enums.RoleType;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false, unique = true)
    @Enumerated(EnumType.STRING)
    RoleType name;

    @ManyToMany(mappedBy = "roles")
    @JsonIgnore
    Set<User> users;

    public Role(RoleType name) {
        this.name = name;
    }
}