package org.cod.vo;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class ResponseVO implements Serializable {

	private static final long serialVersionUID = 2064865377742584668L;

	private List<List<String>> response;
}
