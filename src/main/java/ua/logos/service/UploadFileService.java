package ua.logos.service;

import ua.logos.entity.UploadFile;

public interface UploadFileService {

	void save(UploadFile file);
	
	UploadFile findOneById(int id);
	
}
