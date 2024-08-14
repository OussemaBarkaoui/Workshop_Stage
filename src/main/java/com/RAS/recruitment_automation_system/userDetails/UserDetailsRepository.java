package com.RAS.recruitment_automation_system.userDetails;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserDetailsRepository extends JpaRepository<UserDetail,Long> {
    Optional<UserDetail> findByPhoneNumber(String phoneNumber);
}
