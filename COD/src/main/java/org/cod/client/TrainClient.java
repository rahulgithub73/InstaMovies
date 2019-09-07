package org.cod.client;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.cod.entity.TrainRunningInfo;
import org.cod.entity.TrainTimeTable;
import org.cod.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class TrainClient {

	@Value("${train.running.info.url}")
	private String trainRunningInfoUrl;

	@Value("${train.time.table.url}")
	private String trainTimetableUrl;

	@Autowired
	RestTemplate restTemplate;

	public ResponseVO getTrainRunningInfo() throws URISyntaxException {
		URI uri = new URI(trainRunningInfoUrl);
		ResponseEntity<ResponseVO> result = restTemplate.getForEntity(uri, ResponseVO.class);
		if (result.getStatusCodeValue() == 200) {
			return result.getBody();
		}
		return null;
	}

	public ResponseVO getTrainTimeTable() throws URISyntaxException {
		URI uri = new URI(trainTimetableUrl);
		ResponseEntity<ResponseVO> result = restTemplate.getForEntity(uri, ResponseVO.class);
		if (result.getStatusCodeValue() == 200) {
			return result.getBody();
		}
		return null;
	}

	public TrainRunningInfo prepareTrainRunningInfoObject() {

		ResponseVO resp = null;
		try {
			resp = getTrainRunningInfo();
		} catch (URISyntaxException e) {
			e.printStackTrace();
			return null;
		}

		if (resp == null) {
			return null;
		}

		List<List<String>> info = resp.getResponse();
		if (info == null || info.size() == 0) {
			return null;
		}
		List<String> list = info.get(0);
		if (list == null || list.size() < 6) {
			return null;
		}
		TrainRunningInfo trainRunningInfo = new TrainRunningInfo();

		trainRunningInfo.setNextStation(list.get(1));
		trainRunningInfo.setRemainingDistance(list.get(4) == null ? null : Double.parseDouble(list.get(4)));
		trainRunningInfo.setCurrentSpeed(list.get(5) == null ? null : Double.parseDouble(list.get(5)));
		trainRunningInfo.setTotalDistance(list.get(3) == null ? null : Double.parseDouble(list.get(3)));

		return trainRunningInfo;

	}

	public List<TrainTimeTable> prepareTrainTimeTableObject() {
		ResponseVO resp = null;
		try {
			resp = getTrainTimeTable();
		} catch (URISyntaxException e) {
			e.printStackTrace();
			return null;
		}

		if (resp == null) {
			return null;
		}

		List<List<String>> info = resp.getResponse();
		if (info == null || info.size() == 0) {
			return null;
		}
		List<TrainTimeTable> tList = new ArrayList<TrainTimeTable>();
		for (List<String> listString : info) {
			if (listString == null || listString.size() < 8) {
				continue;
			}

			TrainTimeTable t = new TrainTimeTable();
			t.setTrainNo(listString.get(0));
			t.setTrainName(listString.get(1));
			t.setStationName(listString.get(2));
			t.setEstimatedTimeArrival(listString.get(4));
			t.setEstimatedTimeDeparture(listString.get(5));
			t.setHaltTime(listString.get(6));
			t.setDistanceFromSource(listString.get(7));

			tList.add(t);
		}

		return tList;
	}

}
