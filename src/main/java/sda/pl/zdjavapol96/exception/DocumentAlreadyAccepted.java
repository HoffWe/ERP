package sda.pl.zdjavapol96.exception;

public class DocumentAlreadyAccepted extends RuntimeException {
    private final long documentId;
    public DocumentAlreadyAccepted(String message, long documentId){
        super(message);
        this.documentId = documentId;
    }
    public long getDocumentId(){
        return documentId;
    }
}
