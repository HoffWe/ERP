package sda.pl.zdjavapol96.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sda.pl.zdjavapol96.dto.DocumentElementDto;
import sda.pl.zdjavapol96.mapper.DocumentElementMapper;
import sda.pl.zdjavapol96.model.DocumentElement;
import sda.pl.zdjavapol96.service.DocumentElementService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/documentelement")
public class DocumentElementController {

    private final DocumentElementService documentElementService;

    public DocumentElementController(DocumentElementService documentElementService) {
        this.documentElementService = documentElementService;
    }

    @GetMapping("")
    public List<DocumentElementDto> findAll(){
        return documentElementService.findAll().stream()
                .map(DocumentElementMapper::mapToDto)
                .collect(Collectors.toList());
    }
    @GetMapping("/{id}")
    public ResponseEntity<DocumentElementDto> findById(@PathVariable long id){
        final Optional<DocumentElement> optionalDocument = documentElementService.findById(id);
        return optionalDocument.map(document -> ResponseEntity.ok(DocumentElementMapper.mapToDto(document))).orElseGet(() -> ResponseEntity.of(Optional.empty()));
    }
    @PostMapping("")
    public ResponseEntity<DocumentElement> add(@Valid @RequestBody DocumentElementDto dto){
        final DocumentElement documentElement = documentElementService.add(dto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(documentElement);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id){
        documentElementService.deleteById(id);
    }



}
