package org.cod.controllers;

import java.time.LocalDateTime;

import javax.servlet.http.HttpSession;

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
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

	@Autowired
	UserRepository userRepository;

	@Autowired
	MovieRepository movieRepository;

	@PostMapping(value = "login")
	public String login(UserEntity userEntity, Model model, @PageableDefault(size = 10) Pageable pageable,HttpSession session) {

		UserEntity userExits = userRepository.findByPhoneNo(userEntity.getPhoneNo());

		if (userExits != null) {
			userExits.setLogin(true);
			userExits.setCreatedTimestamp(LocalDateTime.now());
			userExits.setCreatedTimestamp(LocalDateTime.now());

		} else {
			userEntity.setLogin(true);
			userEntity.setCreatedTimestamp(LocalDateTime.now());
			userEntity.setCreatedTimestamp(LocalDateTime.now());
			userRepository.save(userEntity);
		}

		Page<MoviesEntity> page = movieRepository.findAll(pageable);
		model.addAttribute("page", page);

		session.setAttribute("mobile", userEntity.getPhoneNo());
		
		return "index";
	}

	@GetMapping(value = "/logout")
	public String logout(Model model,HttpSession session) {
		if(session != null) {
			session.removeAttribute("mobile");
			session.invalidate();
		}
		
		return "redirect:/";
	}

	@GetMapping(value = "/userInfo")
	public String getUserInfo(Model model) {
		return "logout";
	}

}
