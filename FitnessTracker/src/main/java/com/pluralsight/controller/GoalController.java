package com.pluralsight.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.pluralsight.model.Goal;
import com.pluralsight.service.GoalService;

@Controller
@SessionAttributes("goal")
public class GoalController {

	@Autowired
	private GoalService goalService;
	
	
	@RequestMapping(value = "addGoal", method = RequestMethod.GET)
	public String addGoal(Model model,ModelMap modelmap) {
		Goal goal = new Goal();
		goal.setMinutes(10);
		model.addAttribute("goal", goal);
		
		modelmap.addAttribute("goals", goalService.findAll());
		return "addGoal";
	}
	
	@RequestMapping(value = "addGoal", method = RequestMethod.POST)
	public String updateGoal(@Valid @ModelAttribute("goal") Goal goal, BindingResult result, ModelMap model) {
		
		// check for any errors
		if(result.hasErrors()) {
			return "addGoal" ;
		}
		
		goalService.save(goal);

		model.addAttribute("goals", goalService.findAll());
		return "addGoal" ;
	}
	
	@RequestMapping(value = "deleteGoal", method = RequestMethod.DELETE)
	public String deleteGoal(){
		return "addGoal";
	}
	
}
