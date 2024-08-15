package com.RAS.recruitment_automation_system.jobListing;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Entity
@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class JobListing {
    @Id
    @GeneratedValue
    private int id;

    private String title;
    private String description;
    private String location;
    private String department;
    private String requirements;
    private java.sql.Date postedDate;
    private java.sql.Date closingDate;

}