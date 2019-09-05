package org.cod.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity(name = "user")
public class UserEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String phoneNo;
	private String seatNo;
	private LocalDateTime createdTimestamp;
	private LocalDateTime modifiedTimestamp;
	private boolean login;
	private String media;
	private String advertisement;
	private String currentMedia;
	private String currentMediaPosition;

}
