package com.fileService.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import com.fileService.utility.FileDownloadUtil;

@Service
public class FileDownloadServiceImpl implements FileDownloadService {

	@Autowired
	FileDownloadUtil fileDownloadUtil;
	
	@Override
	public Resource getFileAsResource(String fileCode) {
		
		Resource resource = null;
		
		try {
			resource= fileDownloadUtil.getFileAsResource(fileCode);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resource;
	}

}
