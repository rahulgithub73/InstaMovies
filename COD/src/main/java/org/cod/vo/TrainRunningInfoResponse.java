package org.cod.vo;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class TrainRunningInfoResponse implements Serializable {

	private static final long serialVersionUID = 3014532621561569105L;
	@JsonProperty("Status")
	private Integer status;

	@JsonProperty("Speed")
	private Double speed;

	@JsonProperty("diatanceRemainin")
	private Double diatanceRemainin;

	@JsonProperty("CurrentStatus")
	private String currentStatus;

	@JsonProperty("NextStatus")
	private String nextStatus;

	@JsonProperty("totalDistance")
	private Double totalDistance;

}
