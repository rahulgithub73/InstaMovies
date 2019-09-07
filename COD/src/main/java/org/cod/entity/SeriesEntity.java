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
@Table(name = "series")
public class SeriesEntity extends BaseEntity implements Serializable {

	private static final long serialVersionUID = -8865796046786707486L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
}
