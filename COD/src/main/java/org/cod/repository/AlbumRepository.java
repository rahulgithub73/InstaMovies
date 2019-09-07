package org.cod.repository;

import org.cod.entity.AlbumEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AlbumRepository extends JpaRepository<AlbumEntity, Long> {

	@Query("select c from AlbumEntity c where (lower(c.name) like %:keyword% OR lower(c.cast) like %:keyword%)")
	Page<AlbumEntity> searchByKeywords(String keyword, Pageable pageable);

}
