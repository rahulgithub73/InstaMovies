package org.cod.repository;

import org.cod.entity.RailwayVideoEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RailwayVideoRepository extends JpaRepository<RailwayVideoEntity, Long> {
	@Query("select c from RailwayVideoEntity c where (lower(c.name) like %:keyword% OR lower(c.cast) like %:keyword%)")
	Page<RailwayVideoEntity> searchByKeywords(String keyword, Pageable pageable);

}
