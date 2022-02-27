package sda.pl.zdjavapol96.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sda.pl.zdjavapol96.dto.DocumentDto;
import sda.pl.zdjavapol96.model.Document;
import sda.pl.zdjavapol96.model.DocumentType;

import java.util.List;

@Repository
public interface DocumentRepository extends JpaRepository<Document, Long> {

    List<Document> findDocumentByDocumentType(DocumentType documentType);
    List<Document> findByCustomerId(long id);
}
