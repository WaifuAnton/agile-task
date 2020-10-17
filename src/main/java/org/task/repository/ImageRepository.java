package org.task.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.task.entity.Image;

@Repository
public interface ImageRepository extends JpaRepository<Image, String> {
}
