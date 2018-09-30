package com.exercice.FizzBuzzApp.thread;

import com.exercice.FizzBuzzApp.helper.WriteFile;

public class WriteFileThread extends Thread {
	
    private Integer numberEnd;
	private Integer numberStart;
	
	public WriteFileThread(String msg, Integer numberStart, Integer numberEnd) {
		super(msg);
		this.numberStart = numberStart;
		this.numberEnd = numberEnd;
	}
	
	public void run() {
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
	}
	
}
