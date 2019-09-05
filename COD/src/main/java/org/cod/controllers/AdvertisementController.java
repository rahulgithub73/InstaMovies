package org.cod.controllers;

import org.cod.repository.AdvertisementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdvertisementController {

	@Autowired
	AdvertisementRepository advertisementRepository;

	@GetMapping(value = "/advertisement")
	public String advertisement(Model model) {
		model.addAttribute("advertisement", advertisementRepository.findAll());
		return "advertisement";
	}
}
