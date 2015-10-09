package com.ontarget.response.bean;

import com.ontarget.dto.OnTargetResponse;
import com.ontarget.entities.DocumentResponse;
import lombok.Data;

import java.util.List;

/**
 * Created by sanjeevghimire on 10/9/15.
 */
@Data
public class GetDocumentQuestionResponse extends OnTargetResponse{

    private long documentId;
    private List<DocumentResponse> documentResponses;

}
