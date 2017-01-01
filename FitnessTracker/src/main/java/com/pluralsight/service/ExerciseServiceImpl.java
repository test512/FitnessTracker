package com.pluralsight.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pluralsight.model.Activity;
import com.pluralsight.model.Exercise;
import com.pluralsight.repository.ActivityRepository;
import com.pluralsight.repository.ExerciseRepository;


@Service
public class ExerciseServiceImpl implements ExerciseService {
	@Autowired
	private ActivityRepository activityRepository;
	 
	@Autowired
	private ExerciseRepository exerciseRepository;

	public List<Activity> findAllActivities() {
		return activityRepository.findAll();
	}

	@Override
	public Exercise save(Exercise exercise) {
		return exerciseRepository.save(exercise);
	}

	@Override
	public List<Exercise> findAll() {
		return exerciseRepository.findAll();
	}
	
	@Override
	public void deleteExercise(Long exerciseId) {
		exerciseRepository.delete(exerciseId);
	}

	@Override
	public Boolean isExsists(Long exerciseId) {
		return exerciseRepository.exists(exerciseId);
	}
}
