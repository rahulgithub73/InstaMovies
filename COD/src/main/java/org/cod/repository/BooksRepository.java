package org.cod.repository;

import org.cod.entity.BooksEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BooksRepository extends JpaRepository<BooksEntity, Long> {

	
	@Query("select c from BooksEntity c where (lower(c.name) like %:keyword% OR lower(c.cast) like %:keyword%)")
	Page<BooksEntity> searchByKeywords(String keyword, Pageable pageable);

}
