package com.example.finalproject.Controller;

import com.example.finalproject.ApiResponse.ApiResponse;
import com.example.finalproject.Model.Video;
import com.example.finalproject.Service.VideoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/video")
@RequiredArgsConstructor
public class VideoController {

    private final VideoService videoService;

    @GetMapping("/get")
    public ResponseEntity getVideos(){
        return ResponseEntity.status(200).body(videoService.getAllVideos());
    }

    @PostMapping("/add")
    public ResponseEntity addVideo(@Valid @RequestBody Video video) {
        videoService.addVideo(video);
        return ResponseEntity.status(201).body(new ApiResponse("Video Added"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateVideo(@PathVariable Integer id, @Valid @RequestBody Video video) {
        videoService.updateVideo(id, video);
        return ResponseEntity.status(200).body(new ApiResponse("Video Updated"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteVideo(@PathVariable Integer id) {
        videoService.deleteVideo(id);
        return ResponseEntity.status(200).body(new ApiResponse("Video Deleted"));
    }
}

