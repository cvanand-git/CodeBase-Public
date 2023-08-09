package com.fileService.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileUploadService {

	String saveFile(String fileName, MultipartFile multipartFile);

}
