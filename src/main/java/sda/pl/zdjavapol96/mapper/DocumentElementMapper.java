package sda.pl.zdjavapol96.mapper;

import sda.pl.zdjavapol96.dto.DocumentElementDto;
import sda.pl.zdjavapol96.model.DocumentElement;

public class DocumentElementMapper {
    static public DocumentElementDto mapToDto(DocumentElement documentElement){
        return DocumentElementDto.builder()
                .documentId(documentElement.getDocument().getId())
                .productId(documentElement.getProduct().getId())
                .productPriceId(documentElement.getProductPrice().getId())
                .quantity(documentElement.getQuantity())
                .build();
    }
}
