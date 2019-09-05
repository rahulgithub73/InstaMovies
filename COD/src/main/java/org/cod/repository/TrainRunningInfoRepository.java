package org.cod.repository;

import org.cod.entity.TrainRunningInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainRunningInfoRepository extends JpaRepository<TrainRunningInfo, Long> {

	TrainRunningInfo findByTrainNo(String tainNo);
}
