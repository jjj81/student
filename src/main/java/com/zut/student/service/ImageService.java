package com.zut.student.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Base64;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ImageService {

	public String fileToBase64(File file) {
		try {
			byte[] fileContent = FileUtils.readFileToByteArray(file);
			String encodedString = Base64.getEncoder().encodeToString(fileContent);
			return encodedString;
		} catch (java.io.IOException e) {
			e.printStackTrace();
		}

		return "fail";
	}

	public File base64ToFile(String imageString, File a) {
		try {
			byte[] decodedBytes = Base64.getDecoder().decode(imageString);
			FileUtils.writeByteArrayToFile(a, decodedBytes);
			return a;
		} catch (java.io.IOException e) {
			e.printStackTrace();
		}
		return a;
	}


	public File multipartFileToFile(MultipartFile image, File file) {
		try (OutputStream os = new FileOutputStream(file)) {
			os.write(image.getBytes());
			return file;
		} catch (java.io.IOException e) {
			e.printStackTrace();
		}
		return file;
	}
}
