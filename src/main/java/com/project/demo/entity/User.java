package com.project.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "user_data")
public class User implements UserDetails {
    @Id
    @GeneratedValue
    private Integer userId;
    @Column(nullable = false)
    @Size(min=3,message = "User name cannot be smaller than 3 characters")
    private String name;
    @Column(nullable = false, unique = true)
    @Email
    private String emailId;
    @Column(nullable = false, unique = true)
    @Pattern(regexp = "^\\d{10}$", message = "Invalid phone number format")
    private String phoneNumber;
    @Column(nullable = false, unique = true)
    private String imageUrl;
    @Column(nullable = false)
    @Size(min=6 ,max=30, message = "Password must be between 6 and 30 characters")
    private String password;
    @CreationTimestamp
    @Column(updatable = false, name = "created_at")
    private Date createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private Date updatedAt;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }
//we can also use @PREUPDATE tag in order to give any logic that we want to use before updating any of the user type object

}
