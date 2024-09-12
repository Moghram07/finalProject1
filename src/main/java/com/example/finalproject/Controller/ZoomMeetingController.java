package com.example.finalproject.Controller;

import com.example.finalproject.ApiResponse.ApiResponse;
import com.example.finalproject.Model.ZoomMeeting;
import com.example.finalproject.Service.ZoomMeetingService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/zoom")
@RequiredArgsConstructor
public class ZoomMeetingController {
    private final ZoomMeetingService zoomService;

    @GetMapping("/get")
    public ResponseEntity getZooms(){
        return ResponseEntity.status(200).body(zoomService.getAllZoomMeetings());
    }

    @PostMapping("/add")
    public ResponseEntity addZoom(@Valid @RequestBody ZoomMeeting zoom) {
        zoomService.addZoom(zoom);
        return ResponseEntity.status(201).body(new ApiResponse("Zoom Added"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateZoom(@PathVariable Integer id, @Valid @RequestBody ZoomMeeting zoom) {
        zoomService.updateZoom(id, zoom);
        return ResponseEntity.status(200).body(new ApiResponse("Zoom Updated"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteZoom(@PathVariable Integer id) {
        zoomService.deleteZoom(id);
        return ResponseEntity.status(200).body(new ApiResponse("Zoom Deleted"));
    }
}
