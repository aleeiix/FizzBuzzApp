/**
 * Class java that extends from Thread, to create the thread and start the game
 * @author Aleix Riba
 * @version 1.0.0
 */

package com.exercice.FizzBuzzApp.thread;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.exercice.FizzBuzzApp.helper.WriteFile;

public class WriteFileThread extends Thread {
	
    private Integer numberEnd;
	private Integer numberStart;
	
	public WriteFileThread(String msg, Integer numberStart, Integer numberEnd) {
		super(msg);
		this.numberStart = numberStart;
		this.numberEnd = numberEnd;
	}
	
	/**
	 * function performed by the thread that is to create the line that we will write in the file
	 */
	public void run() {
		try {
			StringBuilder line = new StringBuilder();
			
			for (int i = numberStart; i <= 100; i++) {
				if (i % 3 == 0 || i % 5 == 0) {
					if (i % 3 == 0) {
						line.append("fizz");
					}
					if (i % 5 == 0) {
						line.append("buzz");
					}
				} else {
					line.append(i);
				}
				line.append(", ");
			}
			
			WriteFile writeFile = new WriteFile();
			writeFile.write(line.substring(0, (line.length()-2)).toString());
		} catch (Exception e) {
			Logger.getLogger(getClass().getName()).log(
		            Level.WARNING, "Error when starting the game from the thread");
		}
	}
	
}
