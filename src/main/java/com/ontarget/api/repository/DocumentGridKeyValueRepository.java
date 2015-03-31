package com.ontarget.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ontarget.entities.DocumentGridKeyValue;

public interface DocumentGridKeyValueRepository extends JpaRepository<DocumentGridKeyValue, Integer> {

	@Query("select d from DocumentGridKeyValue d where d.document.id = ?1")
	List<DocumentGridKeyValue> getDocumentGridKeyValuesByDocumentId(Integer documentId);

	@Query("select d from DocumentGridKeyValue d where d.document.id = ?1 and d.gridId = ?2")
	DocumentGridKeyValue getDocumentgridKeyValuesByDocumentIdAndGridId(Integer documentId, String gridId);

}
