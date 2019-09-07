package org.cod.controllers;

import java.util.List;

import org.cod.entity.AlbumEntity;
import org.cod.entity.MusicEntity;
import org.cod.repository.AlbumRepository;
import org.cod.repository.MusicRepository;
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
public class MusicController {

	@Autowired
	MusicRepository musicRepository;

	@Autowired
	AlbumRepository albumRepository;

	@GetMapping(value = "/music")
	public String music(Model model) {
		model.addAttribute("music", albumRepository.findAll());
		return "music";
	}

	@GetMapping("/paginationMusic")
	public String getEmployees(@PageableDefault(size = 10) Pageable pageable, Model model) {
		Page<AlbumEntity> page = albumRepository.findAll(pageable);
		model.addAttribute("page", page);
		return "music";
	}

	@GetMapping(value = "/musicDetailPage/{id}")
	public String movieDetailPage(Model model, @PathVariable Long id) {
		List<MusicEntity> list = musicRepository.findByAlbumId(id);
		model.addAttribute("musics", list);
		if (list != null && list.size() > 0) {
			model.addAttribute("music", list.get(0));

		}

		return "musicDetailPage";

	}

	@GetMapping("/musicSearch")
	public String serch(@PageableDefault(size = 10) Pageable pageable, Model model,
			@RequestParam(value = "keyword") String keyword) {
		Page<AlbumEntity> page = albumRepository.searchByKeywords(keyword, pageable);
		model.addAttribute("page", page);
		return "music";
	}
}
