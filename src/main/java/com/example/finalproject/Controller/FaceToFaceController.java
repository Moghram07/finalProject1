package com.example.finalproject.Controller;

import com.example.finalproject.ApiResponse.ApiResponse;
import com.example.finalproject.Model.FaceToFace;
import com.example.finalproject.Service.FaceToFaceService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/face")
@RequiredArgsConstructor
public class FaceToFaceController {

    private final FaceToFaceService faceService;

    @GetMapping("/get")
    public ResponseEntity getFaces(){
        return ResponseEntity.status(200).body(faceService.getAllFaceMeeting());
    }

    @GetMapping("/add")
    public ResponseEntity addFaceMeeting(@Valid @RequestBody FaceToFace face) {
        faceService.addFaceMeeting(face);
        return ResponseEntity.status(201).body(new ApiResponse("Face Added"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateFaceMeeting(@PathVariable Integer id, @Valid @RequestBody FaceToFace face) {
        faceService.updateFaceMeeting(id, face);
        return ResponseEntity.status(200).body(new ApiResponse("Face Updated"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteFaceMeeting(@PathVariable Integer id) {
        faceService.deleteFaceMeeting(id);
        return ResponseEntity.status(200).body(new ApiResponse("Face Deleted"));
    }
}

