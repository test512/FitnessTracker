package com.pluralsight.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pluralsight.model.Exercise;

public interface ExerciseRepository extends JpaRepository<Exercise, Long>{

}
