package com.RAS.recruitment_automation_system.application;

import com.RAS.recruitment_automation_system.jobListing.JobListing;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.sql.Date;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "application")
@EntityListeners(AuditingEntityListener.class)
public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String candidateName;
    private String candidateEmail;
    private String resumeUrl;
    private String coverLetter;
    private String status;
    private Date applicationDate;

    @ManyToOne
    @JoinColumn(name = "jobId", nullable = false)
    @Valid
    @NotNull(message = "Job listing cannot be null")
    private JobListing jobListing;
}