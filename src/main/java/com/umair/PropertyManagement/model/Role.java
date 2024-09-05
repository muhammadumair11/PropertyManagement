package com.umair.PropertyManagement.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.umair.PropertyManagement.Enums.RoleTypeEnum;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false, unique = true)
    @Enumerated(EnumType.STRING)
    RoleTypeEnum name;

    @ManyToMany(mappedBy = "roles")
    @JsonIgnore
    Set<User> users;

    public Role(RoleTypeEnum name) {
        this.name = name;
    }
}