package ua.logos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ua.logos.entity.UploadFile;

@Repository
public interface UploadFileRepository extends JpaRepository<UploadFile, Integer>{

}
