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
@Table(name = "movies")
public class MoviesEntity extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 2793531073620086979L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

}
