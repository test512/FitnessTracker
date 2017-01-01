package com.pluralsight.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pluralsight.model.Goal;
import com.pluralsight.repository.GoalRepository;


@Service
public class GoalServiceImpl implements GoalService {

	@Autowired
	private GoalRepository goalRepository;
	
	@Override
	public Goal save(Goal goal) {
		return goalRepository.save(goal);
	}

	@Override
	public List<Goal> findAll() {
		return goalRepository.findAll();
	}
}
