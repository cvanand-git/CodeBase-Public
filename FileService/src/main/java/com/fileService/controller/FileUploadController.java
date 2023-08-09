package com.fileService.controller;


import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.fileService.DTO.FileUploadResponse;
import com.fileService.service.FileUploadService;

@RestController
public class FileUploadController {
	
	@Autowired
	FileUploadResponse response;
	
	@Autowired
	FileUploadService fileUploadService;

	@PostMapping("/uploadFile")
	public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile multipartFile) throws IOException{
		
		String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
		String fileExtension = StringUtils.getFilenameExtension(multipartFile.getOriginalFilename());
		long size = multipartFile.getSize();
		
		if(!"pdf".equals(fileExtension)) {
			return new ResponseEntity<>("Not a PDF file", HttpStatus.BAD_REQUEST);
		}
		
		String fileCode = fileUploadService.saveFile(fileName, multipartFile);
		
		response.setFileName(fileName);
		response.setSize(size);
		response.setDownloadUri("/downloadFile/"+fileCode);
		
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
