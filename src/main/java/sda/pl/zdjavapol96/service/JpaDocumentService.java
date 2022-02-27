package sda.pl.zdjavapol96.service;

import org.springframework.stereotype.Service;
import sda.pl.zdjavapol96.dto.DocumentDto;
import sda.pl.zdjavapol96.exception.DocumentAlreadyAccepted;
import sda.pl.zdjavapol96.model.*;
import sda.pl.zdjavapol96.repository.DocumentElementRepository;
import sda.pl.zdjavapol96.repository.DocumentRepository;
import sda.pl.zdjavapol96.repository.UserAppRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import java.util.stream.Collectors;


@Service
public class JpaDocumentService implements DocumentService {
    private final DocumentRepository documentRepository;
    private final DocumentElementRepository documentElementRepository;
    private final UserAppRepository userAppRepository;

    public JpaDocumentService(DocumentRepository documentRepository, DocumentElementRepository documentElementRepository, UserAppRepository userAppRepository) {
        this.documentRepository = documentRepository;
        this.documentElementRepository = documentElementRepository;
        this.userAppRepository = userAppRepository;
    }

    @Override
    public Document add(DocumentDto newDocument) {
        Document document = Document.builder()
                .documentType(newDocument.getDocumentType())
                .customer(Customer.builder()
                        .id(newDocument.getCustomerId())
                        .build())
                .issueDate(newDocument.getIssueDate())
                .user(userAppRepository.getById(newDocument.getUserId()))
                .documentElements(Set.of())
                .totalNet(BigDecimal.ZERO)
                .totalGros(BigDecimal.ZERO)
                .accepted(false)
                .build();
        return documentRepository.save(document);
    }

    @Override
    public List<Document> findByCustomerId(long customerId) {
        return documentRepository.findByCustomerId(customerId);
    }

    @Override
    public Optional<Document> findById(long id) {
        return documentRepository.findById(id);
    }

    @Override
    public List<Document> findByDocumentType(DocumentType documentType) {
        return documentRepository.findDocumentByDocumentType(documentType);
    }

    @Override
    public List<Document> findByProduct(Product product) {
        List<DocumentElement> documentElementByProductId = documentElementRepository.findDocumentElementByProductId(product.getId());
        return documentElementByProductId.stream().map(DocumentElement::getDocument).distinct().collect(Collectors.toList());
    }

    @Override
    public List<Document> findAll() {
        return documentRepository.findAll();
    }

    @Override
    public Document update(Document newUpdateDocument) {
        if (documentRepository.getById(newUpdateDocument.getId()).getAccepted() == true)
            throw new DocumentAlreadyAccepted("Dokument już zaakceptowany, nie można edytować", newUpdateDocument.getId());
        else {
            documentRepository.save(newUpdateDocument);
            return newUpdateDocument;
        }
    }

    @Override
    public void deleteById(long id) {
        documentRepository.deleteById(id);
    }
}