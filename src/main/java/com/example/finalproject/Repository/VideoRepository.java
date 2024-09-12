package com.example.finalproject.Repository;

import com.example.finalproject.Model.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VideoRepository extends JpaRepository<Video, Integer> {
    Video findVideoById(Integer id);
}
