package com.example.finalproject.Controller;

import com.example.finalproject.ApiResponse.ApiResponse;
import com.example.finalproject.Model.Document;
import com.example.finalproject.Service.DocumentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/document")
@RequiredArgsConstructor
public class DocumentController {

    private final DocumentService documentService;

    @GetMapping("/get")
    public ResponseEntity getDocuments(){
        return ResponseEntity.status(200).body(documentService.getAllDocuments());
    }

    @PostMapping("/add")
    public ResponseEntity addDocument(@Valid @RequestBody Document document) {
        documentService.addDocument(document);
        return ResponseEntity.status(201).body(new ApiResponse("Document Added"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateDocument(@PathVariable Integer id, @Valid @RequestBody Document document) {
        documentService.updateDocument(id, document);
        return ResponseEntity.status(200).body(new ApiResponse("Document Updated"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteDocument(@PathVariable Integer id) {
        documentService.deleteDocument(id);
        return ResponseEntity.status(200).body(new ApiResponse("Document Deleted"));
    }
}
