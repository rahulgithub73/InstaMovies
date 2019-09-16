package org.cod.controllers;

import java.util.List;

import org.cod.client.TrainClient;
import org.cod.entity.TrainTimeTable;
import org.cod.repository.TrainRunningInfoRepository;
import org.cod.repository.TrainTimeTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TrainInfoController {

	@Autowired
	TrainRunningInfoRepository trainRunningInfoRepository;

	@Autowired
	TrainTimeTableRepository trainTimeTableRepository;
	
	@Autowired
	TrainClient trainClient;

	@GetMapping(value = "/trainRunningInfo")
	public String trainRunningInfo(Model model) {

		model.addAttribute("trainRunningInfo", trainClient.prepareTrainRunningInfoObject());
		return "trainRunningInfo";
	}

	@GetMapping(value = "/trainTimeTable")
	public String trainTimeTable(Model model) {

		List<TrainTimeTable> list = trainClient.prepareTrainTimeTableObject();
		model.addAttribute("trainTimeTables", list);
		if(list != null && list.size()>0) {
			model.addAttribute("trainTime", list.get(0));
		}
		

		return "trainTimeTable";
	}
	
	
}
