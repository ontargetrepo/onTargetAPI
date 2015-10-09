package com.ontarget.api.jpa.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import com.ontarget.api.service.impl.DocumentServiceImpl;
import com.ontarget.constant.OnTargetConstant;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.ontarget.api.dao.DocumentAttachmentDAO;
import com.ontarget.api.dao.impl.BaseGenericDAOImpl;
import com.ontarget.api.repository.DocumentAttachmentRepository;
import com.ontarget.bean.DocumentAttachmentDTO;
import com.ontarget.entities.Document;
import com.ontarget.entities.DocumentAttachment;
import com.ontarget.entities.User;

@Repository("documentAttachmentJpaDAOImpl")
public class DocumentAttachmentJpaDAOImpl extends BaseGenericDAOImpl<DocumentAttachmentDTO> implements DocumentAttachmentDAO {

    private Logger logger = Logger.getLogger(DocumentAttachmentJpaDAOImpl.class);

	@Resource
	private DocumentAttachmentRepository documentAttachmentRepository;

	@Override
	public DocumentAttachmentDTO insert(DocumentAttachmentDTO documentAttachmentDTO) {
		DocumentAttachment documentAttachment = new DocumentAttachment();
		documentAttachment.setDocument(new Document(documentAttachmentDTO.getDocument().getDocumentId()));
		documentAttachment.setFilePath(documentAttachmentDTO.getFilePath());
		documentAttachment.setCreatedBy(new User(documentAttachmentDTO.getAddedBy()));
		documentAttachment.setCreatedDate(new Date());
        documentAttachment.setStatus(OnTargetConstant.DocumentAttachmentStatus.ACTIVE);
		documentAttachmentRepository.save(documentAttachment);
		documentAttachmentDTO.setDocumentAttachmentId(documentAttachment.getDocumentAttachmentId());
		return documentAttachmentDTO;
	}

	@Override
	public DocumentAttachmentDTO read(long id) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean update(DocumentAttachmentDTO bean) {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<DocumentAttachmentDTO> getByDocumentId(long documentId) {
		List<DocumentAttachment> documentAttachments = documentAttachmentRepository.findByDocumentId((int) documentId);

		List<DocumentAttachmentDTO> documentAttachmentDTOList = new ArrayList<DocumentAttachmentDTO>();
		if (documentAttachments != null && !documentAttachments.isEmpty()) {
			for (DocumentAttachment documentAttachment : documentAttachments) {
				DocumentAttachmentDTO documentAttachmentDTO = new DocumentAttachmentDTO();
				documentAttachment.setDocumentAttachmentId(documentAttachment.getDocumentAttachmentId());
				documentAttachment.setFilePath(documentAttachment.getFilePath());
				documentAttachmentDTOList.add(documentAttachmentDTO);
			}
		}
		return documentAttachmentDTOList;
	}


    @Override
    public boolean delete(long documentAttachmentId, int modifiedBy){
        logger.debug("Updating attachment to delete status.");
        DocumentAttachment attachment = documentAttachmentRepository.findOne((int) documentAttachmentId);
        attachment.setModifiedBy(new User(modifiedBy));
        attachment.setStatus(OnTargetConstant.DocumentAttachmentStatus.DELETED);
       documentAttachmentRepository.save(attachment);
       return true;
    }

}
