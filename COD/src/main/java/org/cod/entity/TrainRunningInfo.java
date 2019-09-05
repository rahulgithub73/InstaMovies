package org.cod.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity(name = "train_running_info")
public class TrainRunningInfo implements Serializable {

	private static final long serialVersionUID = 5251409828790211528L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String trainNo;
	private String trainName;
	private String nextStation;
	private Double remainingDistance;
	private Double currentSpeed;
	private Double totalDistance;
}
