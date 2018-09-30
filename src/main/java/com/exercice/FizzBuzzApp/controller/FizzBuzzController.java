package com.exercice.FizzBuzzApp.controller;



import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exercice.FizzBuzzApp.thread.WriteFileThread;

@RestController
public class FizzBuzzController {
	
	@Value("${numberEnd}")
    private Integer numberEnd;
	
	@GetMapping("/start")
	Integer startGame() {
		try {
			Thread process = new WriteFileThread("processWriteFile",2,numberEnd);
			process.start();
		} catch (Exception e) {
			System.out.println("Error");
		}
		return 0;
	}
}