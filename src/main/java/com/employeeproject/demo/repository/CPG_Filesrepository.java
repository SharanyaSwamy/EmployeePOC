package com.employeeproject.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import com.employeeproject.demo.entity.CPG_Files;

@Repository
public interface CPG_Filesrepository extends JpaRepository<CPG_Files,Integer> {
	
	@Query("Select a from DocumnentStorageProperties a where user_id = ?1 and document_type = ?2")
	CPG_Files checkDocumentByUserId(Integer userId, String docType);
	
	 @Query("Select fileName from DocumnentStorageProperties a where user_id = ?1 and document_type = ?2")
	 String getUploadDocumnetPath(Integer userId, String docType); 

}
