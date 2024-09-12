package com.example.finalproject.Service;

import com.example.finalproject.ApiException.ApiException;
import com.example.finalproject.Model.Document;
import com.example.finalproject.Repository.DocumentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DocumentService {

    private final DocumentRepository documentRepository;

    public List<Document> getAllDocuments() {
        return documentRepository.findAll();
    }

    public void addDocument(Document document) {
        documentRepository.save(document);
    }

    public Document updateDocument(Integer id, Document document) {
        Document d = findDocumentById(id);
        if(d == null) {
            throw new ApiException("Document not found");
        }
        d.setTitle(document.getTitle());
        d.setPrice(document.getPrice());
//        d.setCourse(document.getCourse());
        return documentRepository.save(d);
    }

    public void deleteDocument(Integer id) {
        Document d = findDocumentById(id);
        if(d == null) {
            throw new ApiException("Document not found");
        }
        documentRepository.deleteById(id);
    }

    public Document findDocumentById(Integer id) {
        Document document = documentRepository.findDocumentById(id);
        if (document == null) {
            throw new ApiException("Document not found");
        }
        return documentRepository.findDocumentById(id);
    }
}

