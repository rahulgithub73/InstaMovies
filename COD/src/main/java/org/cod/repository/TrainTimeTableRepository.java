package org.cod.repository;

import java.util.List;

import org.cod.entity.TrainTimeTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainTimeTableRepository extends JpaRepository<TrainTimeTable, Long> {

	List<TrainTimeTable> findByTrainNo(String tainNo);

}
