package org.cod.repository;

import java.util.List;

import org.cod.entity.SubSeriesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubSeriesRepository extends JpaRepository<SubSeriesEntity, Long> {

	List<SubSeriesEntity> findBySeriesId(Long seriesId);

}
