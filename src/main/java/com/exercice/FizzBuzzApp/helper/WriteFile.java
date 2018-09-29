package com.exercice.FizzBuzzApp.helper;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class WriteFile {
	
	public WriteFile(){}
	
	public void write(String line) {
		try {
			ClassLoader classLoader = getClass().getClassLoader();
			File file = new File(classLoader.getResource("files").getFile());
//			URL url = this.getClass().getClassLoader().getResource("files");
//			String route = url.getPath()+"/archivo.txt";
//			File archivo = new File(route);
//			BufferedWriter bw;
//			if(archivo.exists()) {
//				bw = new BufferedWriter(new FileWriter(archivo));
//				bw.write("El fichero de texto ya estaba creado.");
//			} else {
//				bw = new BufferedWriter(new FileWriter(archivo));
//				bw.write("Acabo de crear el fichero de texto.");
//			}
//			bw.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
    }
}
