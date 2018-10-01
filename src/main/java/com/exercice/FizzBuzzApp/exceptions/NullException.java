/**
 * Class java that extends from NullPointerException
 * @author Aleix Riba
 * @version 1.0.0
 */

package com.exercice.FizzBuzzApp.exceptions;

public class NullException extends NullPointerException{
	
	public NullException(){};
	
	public String getMessage() {
		return "Error caused by a null";
	}
	
}
