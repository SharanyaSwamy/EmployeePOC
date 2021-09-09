package com.employeeproject.demo.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "file")
@Entity
@Table(name="CPG_FILES")
public class CPG_Files {
	
	@Id
	 @GeneratedValue(strategy= GenerationType.AUTO)
	 private Integer document_id;
	  
	    @Column(name = "user_id")
	    private Integer UserId;

	    @Column(name = "file_name")
	    private String fileName;

	    @Column(name = "document_type")
	    private String documentType;

	    @Column(name = "document_format")
	    private String documentFormat;

	    @Column(name = "upload_dir")
	    private String uploadDir;

		public Integer getUserId() {
			return UserId;
		}

		public void setUserId(Integer userId) {
			UserId = userId;
		}
        
		public String getFileName() {
			return fileName;
		}

		public void setFileName(String fileName) {
			this.fileName = fileName;
		}

		public String getDocumentType() {
			return documentType;
		}

		public void setDocumentType(String documentType) {
			this.documentType = documentType;
		}

		public String getDocumentFormat() {
			return documentFormat;
		}

		public void setDocumentFormat(String documentFormat) {
			this.documentFormat = documentFormat;
		}

		public String getUploadDir() {
			return uploadDir;
		}

		public void setUploadDir(String uploadDir) {
			this.uploadDir = uploadDir;
		}
	  
	    

}
