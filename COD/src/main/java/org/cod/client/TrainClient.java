package org.cod.client;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.cod.entity.TrainRunningInfo;
import org.cod.entity.TrainTimeTable;
import org.cod.vo.ResponseVO;
import org.cod.vo.StationsVO;
import org.cod.vo.TrainRunningInfoResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class TrainClient {

	private static final Logger LOG = LoggerFactory.getLogger(TrainClient.class);

	@Value("${train.running.info.url}")
	private String trainRunningInfoUrl;

	@Value("${train.time.table.url}")
	private String trainTimetableUrl;

	@Autowired
	RestTemplate restTemplate;

	private TrainRunningInfoResponse getTrainRunningInfo() throws URISyntaxException {
		String methodName = "getTrainRunningInfo:: ";
		URI uri = new URI(trainRunningInfoUrl);
		ResponseEntity<TrainRunningInfoResponse> result = restTemplate.getForEntity(uri,
				TrainRunningInfoResponse.class);
		LOG.debug(" {} Response Entity object is {}", methodName, result);
		if (result.getStatusCodeValue() == 200) {
			LOG.debug(" {} response body is {}", methodName, result.getBody());
			return result.getBody();
		}
		return null;
	}

	private ResponseVO getTrainTimeTable() throws URISyntaxException {
		String methodName = "getTrainTimeTable:: ";

		URI uri = new URI(trainTimetableUrl);
		ResponseEntity<ResponseVO> result = restTemplate.getForEntity(uri, ResponseVO.class);
		LOG.debug(" {} Response Entity object is {}", methodName, result);
		if (result.getStatusCodeValue() == 200) {
			LOG.debug(" {} response body is {}", methodName, result.getBody());
			return result.getBody();
		}
		return null;
	}

	public TrainRunningInfo prepareTrainRunningInfoObject() {
		String methodName = "prepareTrainRunningInfoObject:: ";

		TrainRunningInfoResponse resp = null;
		try {
			resp = getTrainRunningInfo();

		} catch (Exception e) {
			LOG.error("{} Exception while getting train running info response {}", methodName, e.getMessage());
			return null;
		}

		if (resp == null) {
			LOG.error("{} Exception while getting train running info response is {}", methodName, resp);
			return null;
		}

		TrainRunningInfo trainRunningInfo = new TrainRunningInfo();

		trainRunningInfo.setNextStation(resp.getNextStatus());
		trainRunningInfo.setRemainingDistance(resp.getDiatanceRemainin());
		trainRunningInfo.setCurrentSpeed(resp.getSpeed());
		trainRunningInfo.setTotalDistance(resp.getTotalDistance());

		return trainRunningInfo;

	}

	public List<TrainTimeTable> prepareTrainTimeTableObject() {
		String methodName = "prepareTrainTimeTableObject:: ";
		ResponseVO resp = null;
		try {
			resp = getTrainTimeTable();

		} catch (Exception e) {
			LOG.error("{} Exception while prepare train time table object  {}", methodName, e.getMessage());
			return null;
		}

		if (resp == null) {
			LOG.error("{} prepare train time table object is {}", methodName, resp);
			return null;
		}

		List<StationsVO> info = resp.getStations();
		if (info == null || info.isEmpty()) {
			LOG.error("{} list of stations is {}", methodName, info);
			return null;
		}
		List<TrainTimeTable> tList = new ArrayList<TrainTimeTable>();
		for (StationsVO st : info) {
			if (st == null) {
				continue;
			}

			TrainTimeTable t = new TrainTimeTable();
			t.setTrainNo(resp.getTrainNo());
			t.setTrainName(resp.getTrainName());
			t.setStationName(st.getStattionNameEng());
			t.setStationNameHindi(st.getStationNameHindi());
			t.setEstimatedTimeArrival(st.getETA());
			t.setEstimatedTimeDeparture(st.getETD());
			t.setHaltTime(st.getHaltTime());
			t.setDistanceFromSource(st.getDistanceSource());

			tList.add(t);
		}

		return tList;
	}

	private static ResponseVO loadJsonStations() {
		ObjectMapper mapper = new ObjectMapper();

		try {

			// Java objects to JSON file
			return mapper.readValue(new File("E:\\stations.json"), ResponseVO.class);

		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

	private static TrainRunningInfoResponse loadStatus() {
		ObjectMapper mapper = new ObjectMapper();

		try {

			// Java objects to JSON file
			return mapper.readValue(new File("E:\\current.json"), TrainRunningInfoResponse.class);

		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

	public static void main(String[] args) {
		loadJsonStations();
	}

}
