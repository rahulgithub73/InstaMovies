package org.cod.controllers;

import java.util.Optional;

import org.cod.entity.SeriesEntity;
import org.cod.entity.SubSeriesEntity;
import org.cod.repository.SeriesRepository;
import org.cod.repository.SubSeriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class SeriesController {

	@Autowired
	SeriesRepository seriesRepository;

	@Autowired
	SubSeriesRepository subSeriesRepository;

	@GetMapping(value = "/series")
	public String series(Model model) {
		model.addAttribute("series", seriesRepository.findAll());
		return "series";
	}
	
	@GetMapping("/paginationSeries")
	public String getEmployees(@PageableDefault(size = 10) Pageable pageable, Model model) {
		Page<SeriesEntity> page = seriesRepository.findAll(pageable);
		model.addAttribute("page", page);
		return "series";
	}
	
	

	@GetMapping(value = "/subSeries/{id}")
	public String subSeries(Model model,@PathVariable Long id) {
		model.addAttribute("series", subSeriesRepository.findBySeriesId(id));
		return "subSeries";
	}

	@GetMapping(value = "/seriesDetailPage/{id}")
	public String movieDetailPage(Model model, @PathVariable Long id) {
		Optional<SubSeriesEntity> list = subSeriesRepository.findById(id);

		if (list.isPresent()) {
			model.addAttribute("subSeries", list.get());
			return "seriesDetailPage";
		}

		return "series";

	}

}
