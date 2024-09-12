package com.example.finalproject.Service;

import com.example.finalproject.ApiException.ApiException;
import com.example.finalproject.Model.FaceToFace;
import com.example.finalproject.Repository.FaceToFaceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FaceToFaceService {

    private final FaceToFaceRepository faceRepository;

    public List<FaceToFace> getAllFaceMeeting() {
        return faceRepository.findAll();
    }

    public void addFaceMeeting(FaceToFace face) {
        faceRepository.save(face);
    }

    public FaceToFace updateFaceMeeting(Integer id, FaceToFace face) {
        FaceToFace f = faceRepository.findFaceToFaceById(id);
        if(face == null) {
            throw new ApiException("Face not found");
        }
        f.setLocation(face.getLocation());
        f.setPrice(face.getPrice());
        return faceRepository.save(f);
    }

    public void deleteFaceMeeting(Integer id) {
        FaceToFace f = faceRepository.findFaceToFaceById(id);
        if(f == null) {
            throw new ApiException("Face not found");
        }
        faceRepository.deleteById(id);
    }

    public FaceToFace findFaceById(Integer id) {
        FaceToFace face = faceRepository.findFaceToFaceById(id);
        if (face == null) {
            throw new ApiException("Face not found");
        }
        return faceRepository.findFaceToFaceById(id);
    }

}

