package sda.pl.zdjavapol96.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sda.pl.zdjavapol96.model.DocumentElement;

import java.util.List;

public interface DocumentElementRepository extends JpaRepository<DocumentElement, Long> {

    List<DocumentElement> findDocumentElementByProductId(long productId);
}
