package com.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Demo1Application {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(Demo1Application.class, args);
	
		   	//String file1 = "C:\\Users\\Dell\\Documents\\Bus ArrayList.txt";
	        //String file2 = "C:\\Users\\Dell\\Documents\\BUS.txt";
	        List<String> parametros = new ArrayList<>();
	        parametros.add("Bus ArrayList.txt");
	        parametros.add("Bus.txt");
	        parametros.add("CV-Victor-Ramirez.docx 1.pdf");
	        
	        
	        //lista vacia esperando para ser poblada con los nombres de los archivos	
			List<String> listado = new ArrayList<>();
			
			//contador para las posiciones del arreglo
			int siguiente = 0;
			
			
			for(int i=0; i<parametros.size(); i++) {
				
				listado.add("C:\\Users\\Dell\\Documents\\"+parametros.get(i));
			}
			
			
			//parametros.stream().map(o -> listado.add("C:\\Users\\Dell\\Documents\\" + parametros.get(siguiente))).collect(Collectors.toList());
		
			
	        //final List<String> srcFiles = Arrays.asList(file1, file2);
	                
	        final FileOutputStream fos = new FileOutputStream(Paths.get(listado.get(0)).getParent().toAbsolutePath() + "/ZAMORA_MTZ_2023.zip");
	        ZipOutputStream zipOut = new ZipOutputStream(fos);

	        for (String srcFile : listado) {
	            File fileToZip = new File(srcFile);
	            FileInputStream fis = new FileInputStream(fileToZip);
	            ZipEntry zipEntry = new ZipEntry(fileToZip.getName());
	            zipOut.putNextEntry(zipEntry);

	            byte[] bytes = new byte[1024];
	            int length;
	            while((length = fis.read(bytes)) >= 0) {
	                zipOut.write(bytes, 0, length);
	            }
	            fis.close();
	        }

	        zipOut.close();
	        fos.close();
	    }
		
	

}
