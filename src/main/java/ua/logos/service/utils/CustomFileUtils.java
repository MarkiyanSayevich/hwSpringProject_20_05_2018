package ua.logos.service.utils;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.sonatype.plexus.components.cipher.Base64;
import org.springframework.web.multipart.MultipartFile;

import javassist.bytecode.ByteArray;

public class CustomFileUtils {

	static String PROJECT_PATH = System.getProperty("user.dir");
	static String SEPARATOR =  System.getProperty("file.separator");
	
	static String ROOT_PATH = PROJECT_PATH + SEPARATOR + "src" + SEPARATOR + "main" + SEPARATOR + "webapp" + SEPARATOR + "upload";

	public static File createFolder(String folderName) {
		File uploadDir = new File(ROOT_PATH);
		
		if(!uploadDir.exists()) {
			uploadDir.mkdir();
		}
		
		File folder = new File(uploadDir.getAbsolutePath() + SEPARATOR + folderName);
		
		
		if(!folder.exists()) {
			folder.mkdir();
		}
		return folder;
	}
	
	public static void createImage(String folderName , MultipartFile file) throws IOException {
		
		if(!file.isEmpty() && file != null ) {
			BufferedImage image = ImageIO.read(new ByteArrayInputStream(file.getBytes()));
			
			File destination = new File(createFolder(folderName).getAbsolutePath() + SEPARATOR + file.getOriginalFilename());
			ImageIO.write(image, "png", destination);
		}
	}
	
	public static String getImage(String folderName, String image) throws IOException {
		
		File file = null;
		byte[] encodedFileToByte = null;
		String encodedFile = null;
		
		if(image != null || image!= "") {
			file = new File(ROOT_PATH + SEPARATOR + folderName + SEPARATOR + image);
		}
		
		encodedFileToByte = Base64.encodeBase64(FileUtils.readFileToByteArray(file));
		encodedFile = new String(encodedFileToByte);
		
		return encodedFile;
	}
	
}


