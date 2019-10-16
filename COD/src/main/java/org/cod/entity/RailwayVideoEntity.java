package org.cod.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "railway_video")
public class RailwayVideoEntity extends BaseEntity implements Serializable  {
	
	private static final long serialVersionUID = 4643590615445332223L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String hlsPath;

}
