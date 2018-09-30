/**
 * Java class that we use to write to a file
 * @author Aleix Riba
 * @version 1.0.0
 */

package com.exercice.FizzBuzzApp.helper;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class WriteFile {
	
	public WriteFile(){}
	
	/**
	 * write the line received by parameter in a file
	 * @param line, line that will be written to the file
	 */
	public void write(String line) {
		try {
			File file = generateFile();
			
			BufferedWriter bw;
			bw = new BufferedWriter(new FileWriter(file));
			bw.write(line);
			bw.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
    }

	/**
	 * generate a file in src/main/resources/files name today's date with the generated time
	 * @return File
	 */
	private File generateFile() {
		File resourcesDirectory = new File("src/main/resources/files/");
		String route = resourcesDirectory.getAbsolutePath();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmssn");
		LocalDateTime now = LocalDateTime.now(); 
		String nameFile = dtf.format(now);
		File file = new File(route+"/"+nameFile+".txt");
		
		return file;
	}
}
