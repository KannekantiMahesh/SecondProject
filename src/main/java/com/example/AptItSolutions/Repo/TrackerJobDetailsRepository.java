package com.example.AptItSolutions.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.AptItSolutions.Entity.TrackerJobDetails;


@Repository
public interface TrackerJobDetailsRepository extends JpaRepository<TrackerJobDetails, Long> {
}