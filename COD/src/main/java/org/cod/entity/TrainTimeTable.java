package org.cod.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity(name = "train_time_table")
public class TrainTimeTable implements Serializable {

	private static final long serialVersionUID = -468643837084690644L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String trainNo;
	private String trainName;
	private String source;
	private String destination;
	private String totalDistance;
	private String totalJourneyTime;
	private String stationName;
	private String stationNameHindi;
	private String estimatedTimeArrival;
	private String estimatedTimeDeparture;
	private String haltTime;
	private Double distanceFromSource;

}
