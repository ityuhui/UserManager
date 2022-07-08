package com.yuhuixa.usermanager.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity(name = "um_user")
@Table(
    name = "um_user",
    uniqueConstraints = {
        @UniqueConstraint(name="user_email_unique", columnNames = "email")
    }
)
public class User {

    @Id
    @SequenceGenerator(
        name = "um_user_sequence",
        sequenceName = "um_user_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "um_user_sequence"
    )
    private Long id;
    
    @Column(
        nullable = false,
        columnDefinition = "TEXT"
    )
    private String name;

    @Column(
        nullable = false,
        columnDefinition = "TEXT"
    )
    private String email;
    
    public User() {
    }

    public User(String name, String email) {
        this.name = name;
        this.email = email;
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
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    
    @Override
    public String toString() {
        return "User [email=" + email + ", id=" + id + ", name=" + name + "]";
    }

    
}
