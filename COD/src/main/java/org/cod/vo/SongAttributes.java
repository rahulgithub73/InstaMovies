package org.cod.vo;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class SongAttributes implements Serializable {

	private static final long serialVersionUID = -7672611341691989665L;

	private String name;
	private String artist;
	private String album;
	private String url;
	@JsonProperty("cover_art_url")
	private String coverArtUrl;

}
