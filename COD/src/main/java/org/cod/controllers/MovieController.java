package org.cod.controllers;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.cod.client.BrowserDetector;
import org.cod.entity.MoviesEntity;
import org.cod.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MovieController {

	@Autowired
	MovieRepository movieRepository;

	@Autowired
	BrowserDetector browserDetector;
	
	@Value("${banner.path}")
	private String bannerPath;

	@GetMapping(value = "/movies")
	public String list(Model model) {
		model.addAttribute("movies", movieRepository.findAll());
		model.addAttribute("bannerPath", bannerPath);
		
		
		return "movies";
	}

	@GetMapping(value = "/movieDetailPage/{id}")
	public String movieDetailPage(Model model, @PathVariable Long id, HttpServletRequest request) {
		Optional<MoviesEntity> list = movieRepository.findById(id);

		if (list.isPresent()) {
			model.addAttribute("movie", list.get());
			model.addAttribute("IPhone", browserDetector.getBrowserType(request));
			return "movieDetailPage";
		} 
		return "movieDetailPage";
	}

	@GetMapping("/paginationMovies")
	public String getEmployees(@PageableDefault(size = 10) Pageable pageable, Model model) {
		Page<MoviesEntity> page = movieRepository.findAll(pageable);
		model.addAttribute("page", page);
		model.addAttribute("bannerPath", bannerPath);
		
		return "movies";
	}

	@GetMapping("/movieSearch")
	public String serch(@PageableDefault(size = 10) Pageable pageable, Model model,
			@RequestParam(value = "keyword") String keyword) {
		Page<MoviesEntity> page = movieRepository.searchByKeywords(keyword, pageable);
		model.addAttribute("page", page);
		model.addAttribute("bannerPath", bannerPath);
		
		return "movies";
	}

}
