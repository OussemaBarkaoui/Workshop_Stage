package com.RAS.recruitment_automation_system.application;

import com.RAS.recruitment_automation_system.jobListing.JobListing;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.sql.Date;

public record ApplicationRequest(
                                 Integer id,
                                 @NotNull(message = "100")

                                 String candidateName,
                                 @NotNull(message = "101")

                                 String candidateEmail,
                                 @NotNull(message = "102")

                                 String resumeUrl,
                                 @NotNull(message = "103")

                                 String coverLetter,
                                 @NotNull(message = "104")

                                 String status,
                                 @NotNull(message = "104")

                                 Date applicationDate,

                                 JobListing jobListing

                                 ) {

    public JobListing getJobListingId() {
        return jobListing;
    }
}
