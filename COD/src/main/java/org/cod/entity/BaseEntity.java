package org.cod.entity;

import javax.persistence.MappedSuperclass;

import lombok.Data;

@MappedSuperclass
@Data
public class BaseEntity {

	private String name;
	private String description;
	private String runtimeMinutes;
	private String cast;
	private String genres;
	private String imdbRating;
	private String director;
	private String releasaeYear;
	private String language;
	private String thumpnailPath;
	private String trailerPath;
	private String path;
	private String tags;
}
