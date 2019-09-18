package org.cod.controllers;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.cod.client.BrowserDetector;
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
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SeriesController {

	@Autowired
	SeriesRepository seriesRepository;

	@Autowired
	SubSeriesRepository subSeriesRepository;
	
	@Autowired
	BrowserDetector browserDetector;

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
	public String subSeries(Model model, @PathVariable Long id) throws Exception {

		List<SubSeriesEntity> list = subSeriesRepository.findBySeriesId(id);
		model.addAttribute("series", list);

		if (list != null && list.size() > 0) {
			model.addAttribute("serie", list.get(0));
			return "subSeries";
		}else {
			throw new Exception();
		}

		
	}

	@GetMapping(value = "/seriesDetailPage/{id}")
	public String movieDetailPage(Model model, @PathVariable Long id,HttpServletRequest request) throws Exception {
		Optional<SubSeriesEntity> list = subSeriesRepository.findById(id);

		if (list.isPresent()) {
			model.addAttribute("subSeries", list.get());
			model.addAttribute("IPhone", browserDetector.getBrowserType(request));
			return "seriesDetailPage";
		}else {
			throw new Exception();
		}

		

	}

	@GetMapping("/seriesSearch")
	public String serch(@PageableDefault(size = 10) Pageable pageable, Model model,
			@RequestParam(value = "keyword") String keyword) {
		Page<SeriesEntity> page = seriesRepository.searchByKeywords(keyword, pageable);
		model.addAttribute("page", page);
		return "series";
	}

}
