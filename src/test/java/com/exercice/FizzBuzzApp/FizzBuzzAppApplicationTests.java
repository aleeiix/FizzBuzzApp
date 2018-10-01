/**
 * Java class that we use to make unit tests
 * @author Aleix Riba
 * @version 1.0.0
 */

package com.exercice.FizzBuzzApp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.exercice.FizzBuzzApp.controllers.FizzBuzzController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FizzBuzzAppApplicationTests {

	@Test
	public void contextLoads() {
		FizzBuzzController controller = new FizzBuzzController();
		controller.startGame(2);
		controller.startGame(-2);
		controller.startGame(150);
	}

}
