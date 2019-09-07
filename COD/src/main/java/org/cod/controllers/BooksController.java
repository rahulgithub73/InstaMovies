package org.cod.controllers;

import org.cod.entity.BooksEntity;
import org.cod.repository.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BooksController {

	@Autowired
	BooksRepository booksRepository;

	@GetMapping(value = "/books")
	public String books(Model model) {
		model.addAttribute("books", booksRepository.findAll());
		return "books";
	}

	@GetMapping("/paginationBooks")
	public String getEmployees(@PageableDefault(size = 10) Pageable pageable, Model model) {
		Page<BooksEntity> page = booksRepository.findAll(pageable);
		model.addAttribute("page", page);
		return "books";
	}

	@GetMapping("/bookSearch")
	public String serch(@PageableDefault(size = 10) Pageable pageable, Model model,
			@RequestParam(value = "keyword") String keyword) {
		Page<BooksEntity> page = booksRepository.searchByKeywords(keyword, pageable);
		model.addAttribute("page", page);
		return "books";
	}

}
