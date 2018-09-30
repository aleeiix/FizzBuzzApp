/**
 * Game controller with the REST service entry point
 * @author Aleix Riba
 * @version 1.0.0
 */

package com.exercice.FizzBuzzApp.controller;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.exercice.FizzBuzzApp.thread.WriteFileThread;

@RestController
public class FizzBuzzController {
	
	/**
	 * I collect the numberEnd value of the application.properties file
	 */
	@Value("${numberEnd}")
    private Integer numberEnd;
	
	/**
	 * as entry point / maxNum I return the value of the variable numberEnd
	 * @return numberEnd(Integer)
	 */
	@GetMapping("/maxNum")
	Integer getMaxNum() {
		return numberEnd;
	}
	
	/**
	 * start the game by creating a thread which performs the game and will save the result in a file
	 * @param numRandom random number where to start the game
	 * @return true if everything has gone well, and false if something has failed
	 */
	@PostMapping("/start")
	Boolean startGame(@RequestBody Integer numRandom) {
		Boolean flag = true;
		try {
			Thread process = new WriteFileThread("processWriteFile",numRandom,numberEnd);
			process.start();
		} catch (Exception e) {
			flag = false;
			Logger.getLogger(getClass().getName()).log(
		            Level.WARNING, "Error when creating the thread or its execution");
		}
		return flag;
	}
	
}
