package com.test.serviceImp;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.test.service.IEmpleadoService;

@Service
public class IEmpleadoImpl implements IEmpleadoService{

	@Override
	public List<File> getFilesFromServer() {
		
		return getFileFromComputer();
	}
	
	
	  private List<File> getFileFromComputer(){
	        List<File> result = new ArrayList<>();
	        File file1 = new File("C:\\Users\\Dell\\Pictures\\Comprobante Pago 9101889174.jpg");
	        File file2 = new File("C:\\\\Users\\\\Dell\\\\Pictures\\inteligencia-artificial-3101612[4086].jpg");
	        result.add(file1);
	        result.add(file2);
	        return result;
	    }

}
