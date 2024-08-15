package com.RAS.recruitment_automation_system.jobListing;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class JobListingResponse {
    private int id;
    private String title;
    private String description;
    private String location;
    private String department;
    private String requirements;
    private Date postedDate;
    private Date closingDate;
}
