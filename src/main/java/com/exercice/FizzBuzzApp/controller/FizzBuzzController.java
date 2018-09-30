package com.exercice.FizzBuzzApp.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.exercice.FizzBuzzApp.thread.WriteFileThread;

@RestController
public class FizzBuzzController {
	
	@Value("${numberEnd}")
    private Integer numberEnd;
	
	@GetMapping("/maxNum")
	Integer getMaxNum() {
		return numberEnd;
	}
	
	@PostMapping("/start")
	Boolean startGame(@RequestBody Integer numRandom) {
		Boolean flag = true;
		try {
			Thread process = new WriteFileThread("processWriteFile",numRandom,numberEnd);
			process.start();
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	//TEST
	@GetMapping("/start/{numRandom}")
	Boolean startGameTest(@PathVariable Integer numRandom) {
		Boolean flag = true;
		try {
			Thread process = new WriteFileThread("processWriteFile",numRandom,numberEnd);
			process.start();
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
}
