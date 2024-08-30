package com.umair.PropertyManagement.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

//id bigint [pk, increment]
//user_id bigint [ref: > User.id]
//message text
//notification_date date

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Lob
    String message;
    Date notificationDate;


    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "user_id")
    User user;
}
