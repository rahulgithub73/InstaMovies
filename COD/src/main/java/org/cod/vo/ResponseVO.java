package org.cod.vo;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class ResponseVO implements Serializable {

	private static final long serialVersionUID = 2064865377742584668L;

	@JsonProperty("Trainno")
	private String trainNo;
	@JsonProperty("TrainName")
	private String trainName;
	private List<StationsVO> stations;
}
