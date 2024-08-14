package com.RAS.recruitment_automation_system.role;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.RAS.recruitment_automation_system.user.User;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique= true)
    private String name;
    @JsonIgnore
    @OneToMany(mappedBy = "roles")
    private List<User> users;


    @CreatedDate
    @Column(nullable = false, updatable =false)
    private LocalDateTime createdDate;
    @LastModifiedDate
    @Column(insertable = false)
    private LocalDateTime lastModified;
}