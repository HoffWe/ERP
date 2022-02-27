package sda.pl.zdjavapol96.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sda.pl.zdjavapol96.dto.DocumentDto;
import sda.pl.zdjavapol96.mapper.DocumentMapper;
import sda.pl.zdjavapol96.model.Customer;
import sda.pl.zdjavapol96.model.Document;
import sda.pl.zdjavapol96.model.DocumentType;
import sda.pl.zdjavapol96.service.DocumentService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/document")
public class DocumentController {
    private final DocumentService documentService;

    public DocumentController(DocumentService documentService) {
        this.documentService = documentService;
    }

    @GetMapping("")
    public List<DocumentDto> findAll() {
        return documentService.findAll().stream()
                .map(DocumentMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DocumentDto> findById(@PathVariable long id) {
        final Optional<Document> optionalDocument = documentService.findById(id);
        return optionalDocument.map(document -> ResponseEntity.ok(DocumentMapper.mapToDto(document))).orElseGet(() -> ResponseEntity.of(Optional.empty()));
    }

    @GetMapping("/type")
    public List<DocumentDto> findByDocumentType(@RequestParam DocumentType type) {
        return documentService.findByDocumentType(type).stream()
                .map(DocumentMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @PostMapping("")
    public ResponseEntity<Document> add(@RequestBody DocumentDto documentDto) {
        return ResponseEntity.ok(documentService.add(documentDto));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id){ documentService.deleteById(id);}
}
