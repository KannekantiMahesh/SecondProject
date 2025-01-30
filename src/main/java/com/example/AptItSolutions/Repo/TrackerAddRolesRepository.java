package com.example.AptItSolutions.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.AptItSolutions.Entity.TrackerAddRoles;

@Repository
public interface TrackerAddRolesRepository extends JpaRepository<TrackerAddRoles, Long> {
}