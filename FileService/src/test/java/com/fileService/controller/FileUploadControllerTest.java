package com.fileService.controller;

import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.util.StringUtils;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(SpringExtension.class)
@WebMvcTest
public class FileUploadControllerTest {

	
	public void testGetfileNameExtension() {
		
		 assertEquals(null, StringUtils.getFilenameExtension(null));
		 assertEquals(null, StringUtils.getFilenameExtension(""));
		 assertEquals(null, StringUtils.getFilenameExtension("uploadFile"));
		 assertEquals(null, StringUtils.getFilenameExtension("uploadFile/file"));
		 assertEquals("pdf", StringUtils.getFilenameExtension("/uploadFile/file.pdf"));
	}
}
