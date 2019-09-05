package org.cod.repository;

import org.cod.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

	UserEntity findByPhoneNo(String phoneNo);
	
}
