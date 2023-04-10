package com.zohocrm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.zohocrm.entities.Lead;
import com.zohocrm.services.LeadService;

@Controller
public class LeadController {
	
	@Autowired
	 private LeadService leadService;
	
		
		@GetMapping("/viewCreateLeadPage")
		public String viewCreateLeadPage() {
			return "create_new_lead";
		}
		
		@PostMapping("/save")
		public String saveLead(@ModelAttribute("lead") Lead lead, Model model) {
			leadService.saveOneLead(lead);
			model.addAttribute("lead", lead);
			return "lead_info";
		}
}
