package com.test.excel.utils;

import java.io.ByteArrayInputStream;
import java.util.List;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.*;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import com.test.model.Empleado;

import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.util.ResourceUtils;

import static com.test.excel.utils.FileFactory.PATH_TEMPLATE;

@Slf4j
@Component
public class ExcelUtils {

	// export config
	public static ByteArrayInputStream exportCustomer(List<Empleado> empleado, String fileName) throws Exception {

		XSSFWorkbook xssfWorkbook = new XSSFWorkbook();

		// get file -> not found -> create file
		File file;
		FileInputStream fileInputStream;

		try {
			file = ResourceUtils.getFile(PATH_TEMPLATE + fileName);
			fileInputStream = new FileInputStream(file);

		} catch (Exception e) {
			log.info("FILE NOT FOUND");
			file = FileFactory.createFile(fileName, xssfWorkbook);
			fileInputStream = new FileInputStream(file);
		}

		

		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		xssfWorkbook.write(outputStream);

		// close resource
		outputStream.close();
		fileInputStream.close();

		log.info("done");
		return new ByteArrayInputStream(outputStream.toByteArray());
	}
	
	
	

	
	
}