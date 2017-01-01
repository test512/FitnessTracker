package com.pluralsight.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pluralsight.model.Goal;

public interface GoalRepository extends JpaRepository<Goal, Long>{

}
