package com.fileService.service;

import java.io.IOException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.fileService.utility.FileUploadUtil;

@Service
public class FileUploadServiceImpl implements FileUploadService {

	@Override
	public String saveFile(String fileName, MultipartFile multipartFile) {
		
		String fileCode = null;
		
		try {
			fileCode = FileUploadUtil.saveFile(fileName, multipartFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fileCode;
	}

}
