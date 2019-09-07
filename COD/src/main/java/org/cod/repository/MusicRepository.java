package org.cod.repository;

import java.util.List;

import org.cod.entity.MusicEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MusicRepository extends JpaRepository<MusicEntity, Long> {

	List<MusicEntity> findByAlbumId(Long albumId);
}
