package com.pluralsight.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pluralsight.model.Activity;
import com.pluralsight.model.Exercise;
import com.pluralsight.service.ExerciseService;


@Controller
public class MinutesController {

	@Autowired
	private ExerciseService exerciseService;

	@RequestMapping(value = "/addMinutes",  method = RequestMethod.GET)
	public String getMinutes(@ModelAttribute ("exercise") Exercise exercise, ModelMap model) {
		List<Exercise> exercises = exerciseService.findAll();
		model.addAttribute("exercises", exercises);
		
		return "addMinutes";
	}

	@RequestMapping(value = "/addMinutes",  method = RequestMethod.POST)
	public String addMinutes(@Valid @ModelAttribute ("exercise") Exercise exercise, BindingResult result, ModelMap model ) {

		// check if there are any errors
		if(result.hasErrors()) {
			return "addMinutes";
		}
		
		// save the new Exercise
		exerciseService.save(exercise);
		
		// return all saved exercises
		List<Exercise> exercises = exerciseService.findAll();
		model.addAttribute("exercises", exercises);

		return "addMinutes";
	}

	@RequestMapping(value = "/activities", method = RequestMethod.GET)
	public @ResponseBody List<Activity> findAllActivities() {
		return exerciseService.findAllActivities();
	}

	@RequestMapping(value = "/delete/{exerciseId}",method = RequestMethod.GET)
	public String deleteActivity(@PathVariable("exerciseId") Long exerciseId, ModelMap model) {
		
		if(exerciseService.isExsists(exerciseId))
			exerciseService.deleteExercise(exerciseId);
		else
			System.out.println("Exercise Id "+exerciseId+" does not exists.");
		
		model.addAttribute("exercise", new Exercise());

		return "addMinutes";
	}
}
