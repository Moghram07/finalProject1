package com.example.finalproject.Repository;

import com.example.finalproject.Model.FaceToFace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FaceToFaceRepository extends JpaRepository<FaceToFace, Integer> {
    FaceToFace findFaceToFaceById(Integer id);
}
