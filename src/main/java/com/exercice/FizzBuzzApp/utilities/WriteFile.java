/**
 * Java class that we use to write to a file
 * @author Aleix Riba
 * @version 1.0.0
 */

package com.exercice.FizzBuzzApp.utilities;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.core.io.ClassPathResource;

public class WriteFile {
	
	private final String WARNING_FILE_NULL = "Error file to arrived null";
	private final String WARNING_WRITING = "Error when writing to the file";
	private final String WARNING_CREATE_FILE = "Error when creating file";
	
	public WriteFile(){}
	
	/**
	 * write the line received by parameter in a file
	 * @param line, line that will be written to the file
	 */
	public void write(String line) {
		try {
			File file = generateFile();
			
			if (file != null) {
				BufferedWriter bw;
				bw = new BufferedWriter(new FileWriter(file));
				bw.write(line);
				bw.close();
			} else {
				Logger.getLogger(getClass().getName()).log(
			            Level.WARNING, WARNING_FILE_NULL);
			}
		} catch (Exception e) {
			Logger.getLogger(getClass().getName()).log(
		            Level.WARNING, WARNING_WRITING);
		}
    }

	/**
	 * generate a file in src/main/resources/files name today's date with the generated time
	 * @return File
	 */
	private File generateFile() {
		File file = null;
		try {
			File resourcesDirectory = new File("src/main/resources/files/");
//			File resourcesDirectory = new File("target/classes/files/");
			String route = resourcesDirectory.getAbsolutePath();
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmssn");
			LocalDateTime now = LocalDateTime.now(); 
			String nameFile = dtf.format(now);
			file = new File(route+"/"+nameFile+".txt");
		} catch (Exception e) {
			file = null;
			Logger.getLogger(getClass().getName()).log(
		            Level.WARNING, WARNING_CREATE_FILE);
		}
		
		return file;
	}
}
