package ua.logos.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="upload_file")
@Getter
@Setter
@NoArgsConstructor
public class UploadFile extends BaseEntity {
	
	@Column(name="file_name")
	private String fileName;
	
	@Lob
	@Column(columnDefinition="MEDIUMBLOB")
	@Basic(fetch = FetchType.LAZY)
	private byte[] fileData;

	@Transient
	private MultipartFile file;
	
}
