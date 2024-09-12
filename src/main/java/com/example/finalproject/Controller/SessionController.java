package com.example.finalproject.Controller;

import com.example.finalproject.ApiResponse.ApiResponse;
import com.example.finalproject.Model.Session;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.finalproject.Service.SessionService;

@RestController
@RequestMapping("/api/v1/session")
@RequiredArgsConstructor
public class SessionController {

    private final SessionService sessionService;

    @GetMapping("/get")
    public ResponseEntity getSessions(){
        return ResponseEntity.status(200).body(sessionService.getAllSessions());
    }

    @PostMapping("/add")
    public ResponseEntity addSession(@RequestBody @Valid Session session){
        sessionService.addSession(session);
        return ResponseEntity.status(201).body(new ApiResponse("Session Created"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateSession(@PathVariable Integer id, @RequestBody @Valid Session session){
        sessionService.updateSession(id, session);
        return ResponseEntity.status(200).body(new ApiResponse("Session Updated"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteSession(@PathVariable Integer id){
        sessionService.deleteSession(id);
        return ResponseEntity.status(200).body(new ApiResponse("Session Deleted"));
    }
}

