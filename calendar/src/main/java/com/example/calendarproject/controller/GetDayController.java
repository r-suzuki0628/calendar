package com.example.calendarproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.calendarproject.Models.GetDayModel;

@Controller
@RequestMapping(value = "/")
public class GetDayController {
	@Autowired
    GetDayModel getDayModel;
	
	@RequestMapping(method = RequestMethod.GET)
    public String days(Model model) {
		model.addAttribute("days", getDayModel.CurrentMonthAndDays());
		model.addAttribute("YearAndMonth", getDayModel.CurrentYearAndMonth());
        return "index";
    }
}
	
