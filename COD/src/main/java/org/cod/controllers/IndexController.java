package org.cod.controllers;

import org.cod.entity.MoviesEntity;
import org.cod.entity.UserEntity;
import org.cod.repository.MovieRepository;
import org.cod.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Homepage controller.
 */
@Controller
public class IndexController {

	@Autowired
	MovieRepository movieRepository;

	@Autowired
	UserRepository userRepository;

	@GetMapping("/")
	String login(UserEntity userEntity) {
		return "login";
	}

	@GetMapping("/img/favicon")
	String favicon() {
		return "forward:/img/favicon.png";
	}

	@GetMapping(value = "/index")
	public String login(Model model) {

		model.addAttribute("movies", movieRepository.findAll());
		return "index";
	}

	@GetMapping("/paginationIndex")
	public String getEmployees(@PageableDefault(size = 10) Pageable pageable, Model model) {
		Page<MoviesEntity> page = movieRepository.findAll(pageable);
		model.addAttribute("page", page);
		return "index";
	}

}
