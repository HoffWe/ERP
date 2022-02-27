package sda.pl.zdjavapol96.mapper;

import sda.pl.zdjavapol96.dto.DocumentDto;
import sda.pl.zdjavapol96.model.Document;

import java.util.stream.Collectors;

public class DocumentMapper {
    public static DocumentDto mapToDto(Document document){
        return DocumentDto.builder()
                .documentType(document.getDocumentType())
                .documentElements(document.getDocumentElements().stream()
                        .map(DocumentElementMapper::mapToDto)
                        .collect(Collectors.toSet()))
                .customerId(document.getCustomer().getId())
                .issueDate(document.getIssueDate())
                .userId(document.getUser().getId())
                .totalNet(document.getTotalNet())
                .totalGros(document.getTotalGros())
                .build();
    }
}
