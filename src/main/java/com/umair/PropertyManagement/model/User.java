package com.umair.PropertyManagement.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "user_table")
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false, unique = true)
    String username;
    @Column(nullable = false, unique = true)
    String email;
    @Column(nullable = false)
    String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    Set<Role> roles;

    @OneToMany(mappedBy = "agent")
    List<Property> properties;

    @OneToMany(mappedBy = "user")
    List<Inquiry> inquiries;

    @OneToMany(mappedBy = "buyer")
    List<Contract> buyerContracts;

    @OneToMany(mappedBy = "seller")
    List<Contract> sellerContracts;

    @OneToMany(mappedBy = "user")
    List<Review> reviews;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "favorite",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "property_id")
    )
    List<Property> favoriteProperties;


    @OneToMany(mappedBy = "user")
    List<Notification> notifications;
}
