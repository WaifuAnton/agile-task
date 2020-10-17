package org.task.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.task.entity.Image;

import java.util.List;

@Repository
public interface ImageRepository extends JpaRepository<Image, String> {
    @Query(value = "select * from images where id = :param or author = :param or camera = :param or tags = :param", nativeQuery = true)
    List<Image> findAllByParam(@Param("param") String param);
}
