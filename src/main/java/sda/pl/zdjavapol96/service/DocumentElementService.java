package sda.pl.zdjavapol96.service;

import sda.pl.zdjavapol96.dto.DocumentDto;
import sda.pl.zdjavapol96.dto.DocumentElementDto;
import sda.pl.zdjavapol96.model.DocumentElement;

import java.util.List;
import java.util.Optional;

public interface DocumentElementService {
    DocumentElement add(DocumentElementDto newDocumentElement);
    List<DocumentElement> findAll();
    Optional<DocumentElement> findById(long id);

    void deleteById(long id);
}
