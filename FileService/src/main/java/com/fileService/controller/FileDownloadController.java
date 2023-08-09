package com.fileService.controller;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.fileService.service.FileDownloadService;


@RestController
public class FileDownloadController {

	@Autowired
	FileDownloadService fileDownloadService;
	
	@GetMapping("/downloadFile/{fileCode}")
	public ResponseEntity<?> downloadFile(@PathVariable("fileCode") String fileCode) throws IOException{
		
		Resource resource = null;
		
		resource= fileDownloadService.getFileAsResource(fileCode);
		
		if(resource == null) {
			return new ResponseEntity<>("file not found", HttpStatus.NOT_FOUND);
		}
		
		String contentTString = "application/pdf";
		String headerString = "attachment; fileName=\""+resource.getFilename()+"\"";
		
		return ResponseEntity.ok().contentType(MediaType.parseMediaType(contentTString)).header(HttpHeaders.CONTENT_DISPOSITION, headerString).body(resource);
	}
}
