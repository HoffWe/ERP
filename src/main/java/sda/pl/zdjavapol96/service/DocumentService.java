package sda.pl.zdjavapol96.service;


import sda.pl.zdjavapol96.dto.DocumentDto;
import sda.pl.zdjavapol96.model.Customer;
import sda.pl.zdjavapol96.model.Document;
import sda.pl.zdjavapol96.model.DocumentType;
import sda.pl.zdjavapol96.model.Product;

import java.util.List;
import java.util.Optional;

public interface DocumentService {
    Document add(DocumentDto newDocument);

    List<Document> findByCustomerId(long customerId);

    Optional<Document> findById(long id);
    List<Document> findByDocumentType(DocumentType documentType);

    List<Document> findByProduct(Product product);

    List<Document> findAll();

    Document update(Document newUpdateDocument);

    void deleteById(long id);

}
