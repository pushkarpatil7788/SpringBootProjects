package com.infosys.EcommerceSystem.beans;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int profileId;
    private String firstName;
    private String lastName;
    private String email;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Override
    public String toString() {
        return "Profile{id=" + profileId + ", firstName='" + firstName + "'}";
    }
}
