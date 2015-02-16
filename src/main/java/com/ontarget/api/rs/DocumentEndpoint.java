package com.ontarget.api.rs;

import com.ontarget.dto.AddDocumentAttachmentRequest;
import com.ontarget.dto.AddDocumentRequest;
import com.ontarget.dto.AddDocumentResponse;
import com.ontarget.dto.GetDocumentAttachmentsResponse;
import com.ontarget.dto.GetDocumentResponse;
import com.ontarget.dto.GetDocumentsResponse;
import com.ontarget.dto.OnTargetResponse;
import com.ontarget.dto.UpdateDocumentDataRequest;
import com.ontarget.dto.UpdateDocumentStatusRequest;

public interface DocumentEndpoint {

    public AddDocumentResponse addDocument(AddDocumentRequest request);

    public OnTargetResponse updateDocumentData(UpdateDocumentDataRequest request);

    public OnTargetResponse updateDocumentStatus(UpdateDocumentStatusRequest request);

    public GetDocumentsResponse getDocuments(String userName, int projectId);

    public GetDocumentResponse getDocument(int documentId);

    public OnTargetResponse addDocumentAttachment(AddDocumentAttachmentRequest request);

//    public GetDocumentAttachmentsResponse getDocumentAttachments(int documentId);
}
