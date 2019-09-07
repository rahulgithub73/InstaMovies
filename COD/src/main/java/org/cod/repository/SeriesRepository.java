package org.cod.repository;

import org.cod.entity.SeriesEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SeriesRepository extends JpaRepository<SeriesEntity, Long> {

	@Query("select c from SeriesEntity c where (lower(c.name) like %:keyword% OR lower(c.cast) like %:keyword%)")
	Page<SeriesEntity> searchByKeywords(String keyword, Pageable pageable);

}
