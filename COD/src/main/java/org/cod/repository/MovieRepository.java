package org.cod.repository;

import org.cod.entity.MoviesEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<MoviesEntity, Long> {

	@Query("select c from MoviesEntity c where (lower(c.name) like %:keyword% OR lower(c.cast) like %:keyword%)")
	Page<MoviesEntity> searchByKeywords(String keyword, Pageable pageable);

}
