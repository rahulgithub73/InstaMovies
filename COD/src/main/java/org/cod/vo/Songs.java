package org.cod.vo;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class Songs implements Serializable {

	private static final long serialVersionUID = -2434379745614372843L;

	List<SongAttributes> songs;

}
