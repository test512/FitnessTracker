package com.pluralsight.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pluralsight.model.Activity;

public interface ActivityRepository extends JpaRepository<Activity, Long>{

}
