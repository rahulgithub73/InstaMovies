package org.cod.controllers;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.cod.client.BrowserDetector;
import org.cod.entity.RailwayVideoEntity;
import org.cod.repository.RailwayVideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RailwayVideoController {

	@Autowired
	RailwayVideoRepository railwayVideoRepository;

	@Autowired
	BrowserDetector browserDetector;

	@GetMapping(value = "/railwayvideo")
	public String list(Model model) {
		model.addAttribute("railwayvideos", railwayVideoRepository.findAll());
		return "railwayvideo";
	}

	@GetMapping(value = "/railwayvideoDetailPage/{id}")
	public String movieDetailPage(Model model, @PathVariable Long id, HttpServletRequest request) {
		Optional<RailwayVideoEntity> list = railwayVideoRepository.findById(id);

		if (list.isPresent()) {
			model.addAttribute("railwayvideo", list.get());
			model.addAttribute("IPhone", browserDetector.getBrowserType(request));
			return "railwayvideoDetailPage";
		} 
		return "railwayvideoDetailPage";
	}

	@GetMapping("/paginationrailwayvideo")
	public String getEmployees(@PageableDefault(size = 10) Pageable pageable, Model model) {
		Page<RailwayVideoEntity> page = railwayVideoRepository.findAll(pageable);
		model.addAttribute("page", page);
		return "railwayvideo";
	}

	@GetMapping("/railwayvideoearch")
	public String serch(@PageableDefault(size = 10) Pageable pageable, Model model,
			@RequestParam(value = "keyword") String keyword) {
		Page<RailwayVideoEntity> page = railwayVideoRepository.searchByKeywords(keyword, pageable);
		model.addAttribute("page", page);
		return "railwayvideo";
	}


}
