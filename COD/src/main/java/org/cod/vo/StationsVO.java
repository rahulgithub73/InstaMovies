package org.cod.vo;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class StationsVO implements Serializable {

	private static final long serialVersionUID = 332077679877069700L;

	@JsonProperty("DistanceSource")
	private Double distanceSource;

	@JsonProperty("Stattionnameeng")
	private String stattionNameEng;

	@JsonProperty("ETA")
	private String ETA;

	@JsonProperty("ETD")
	private String ETD;

	@JsonProperty("Stationnamehindi")
	private String stationNameHindi;

	@JsonProperty("Halttime")
	private String haltTime;

}
