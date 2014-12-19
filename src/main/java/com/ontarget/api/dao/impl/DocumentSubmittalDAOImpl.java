package com.ontarget.api.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.ontarget.api.dao.DocumentSubmittalDAO;
import com.ontarget.bean.DocumentSubmittal;
import com.ontarget.constant.OnTargetQuery;

@Repository
public class DocumentSubmittalDAOImpl
		extends BaseGenericDAOImpl<DocumentSubmittal>
		implements DocumentSubmittalDAO {

	@Override
	public DocumentSubmittal insert(final DocumentSubmittal documentSubmittal) {
		KeyHolder kh = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator(){
			@Override
			public PreparedStatement createPreparedStatement(Connection conn)
					throws SQLException {
				PreparedStatement ps = conn.prepareStatement(OnTargetQuery.documentSubmittal.ADD, 
						new String[] { "document_submittal_id" });
		            ps.setLong(1, documentSubmittal.getDocument().getDocumentId());
		            ps.setLong(2, documentSubmittal.getAssignee().getUserId());
		            ps.setString(3, documentSubmittal.getCreatedBy());
		            ps.setString(4, documentSubmittal.getModifiedBy());
		            return ps;
			}
			
		}, kh);
		documentSubmittal.setDocumentSubmittalId(kh.getKey().longValue());
		return documentSubmittal;
	}

	@Override
	public DocumentSubmittal read(long documentSubmittalId) {
		DocumentSubmittal docSub = jdbcTemplate.queryForObject(OnTargetQuery.documentSubmittal.GET_BY_ID, 
				new Object[] { documentSubmittalId }, 
				new DocumentSubmittalRowMapper());
		return docSub;
	}

	@Override
	public boolean update(DocumentSubmittal documentSubmittal) {
		
		return false;
	}

	static class DocumentSubmittalRowMapper 
			implements RowMapper<DocumentSubmittal> {
		@Override
		public DocumentSubmittal mapRow(ResultSet rs, int index) throws SQLException {
			DocumentSubmittal docSub = new DocumentSubmittal();
			docSub.setDocumentSubmittalId(rs.getLong("document_submittal_id"));
			//docSub.setSubmitter(submitter);
			//docSub.setAssignee(assignee);
			//docSub.setDocument(document);
			return docSub;
		}
	}

}