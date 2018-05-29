package ua.logos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.logos.entity.UploadFile;
import ua.logos.repository.UploadFileRepository;
import ua.logos.service.UploadFileService;

@Service
public class UploadFileServiceImpl implements UploadFileService {

	@Autowired UploadFileRepository uploadFileRepos;
	
	@Override
	public void save(UploadFile file) {
		uploadFileRepos.save(file);
	}

	@Override
	public UploadFile findOneById(int id) {
		return uploadFileRepos.getOne(id);
	}

}
