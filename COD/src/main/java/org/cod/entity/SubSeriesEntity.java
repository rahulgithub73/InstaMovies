package org.cod.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity(name = "sub_series")
public class SubSeriesEntity extends BaseEntity implements Serializable {

	private static final long serialVersionUID = -8865796046786707486L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "series_id")
	private Long seriesId;
	
	@Column(name = "episode")
	private String episode;
	
	private String hlsPath;

}
