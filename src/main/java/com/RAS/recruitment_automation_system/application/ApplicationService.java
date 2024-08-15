package com.RAS.recruitment_automation_system.application;

import com.RAS.recruitment_automation_system.common.PageResponse;
import com.RAS.recruitment_automation_system.jobListing.JobListing;
import com.RAS.recruitment_automation_system.jobListing.JobListingRepository;
import com.RAS.recruitment_automation_system.jobListing.JobListingRequest;
import com.RAS.recruitment_automation_system.jobListing.JobListingResponse;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.core.ApplicationMapping;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class ApplicationService {

private final ApplicationRepository applicationRepository;
private final ApplicationMapper applicationMapper;
private final JobListingRepository jobListingRepository;
    public Integer createApplication(ApplicationRequest request) {
        JobListing jobListing = jobListingRepository.findById(request.getJobListingId().getId())
                .orElseThrow(() -> new RuntimeException("JobListing not found"));


        Application application = applicationMapper.toApplication(request);
        application.setJobListing(jobListing);

        return applicationRepository.save(application).getId();
    }

    public PageResponse<ApplicationResponse> findAllApplication(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("applicationDate").descending());
        Page<Application> applicationPage = applicationRepository.findAll(pageable);
        List<ApplicationResponse> applicationResponses = applicationPage
                .stream()
                .map(applicationMapper::toApplicationResponse)
                .toList();

        return new PageResponse<>(
                applicationResponses,
                applicationPage.getNumber(),
                applicationPage.getSize(),
                applicationPage.getTotalElements(),
                applicationPage.getTotalPages(),
                applicationPage.isFirst(),
                applicationPage.isLast()
        );
    }
    public PageResponse<ApplicationResponse> findApplicationById(int appId, int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("applicationDate").descending());
        Page<Application> applicationPage = applicationRepository.findAllByAppId(appId, pageable);
        List<ApplicationResponse> applicationResponses = applicationPage
                .stream()
                .map(applicationMapper::toApplicationResponse)
                .toList();

        return new PageResponse<>(
                applicationResponses,
                applicationPage.getNumber(),
                applicationPage.getSize(),
                applicationPage.getTotalElements(),
                applicationPage.getTotalPages(),
                applicationPage.isFirst(),
                applicationPage.isLast()
        );
    }
    public void updateApplicationById(Integer appId, ApplicationRequest request) {
        Application application = applicationRepository.findById(appId)
                .orElseThrow(() -> new RuntimeException("application not found"));
        application.setCandidateName(request.candidateName());
        application.setCandidateEmail(request.candidateEmail());
        application.setResumeUrl(request.resumeUrl());
        application.setCoverLetter(request.coverLetter());
        application.setStatus(request.status());
        application.setApplicationDate(request.applicationDate());
        application.setJobListing(request.jobListing());
        applicationRepository.save(application);

    }
    public void deleteApplicationById(Integer appId) {

        applicationRepository.deleteById(appId);
    }


}