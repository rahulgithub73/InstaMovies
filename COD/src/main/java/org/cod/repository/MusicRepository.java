package org.cod.repository;

import org.cod.entity.MusicEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MusicRepository extends JpaRepository<MusicEntity, Long> {

	@Query("select c from MusicEntity c where (lower(c.name) like %:keyword% OR lower(c.cast) like %:keyword%)")
	Page<MusicEntity> searchByKeywords(String keyword, Pageable pageable);

}
