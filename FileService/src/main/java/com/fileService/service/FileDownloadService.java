package com.fileService.service;

import org.springframework.core.io.Resource;

public interface FileDownloadService {

	Resource getFileAsResource(String fileCode);

}
