package com.tanmoy.service;

import org.springframework.stereotype.Component;

@Component
public class CalculateSomething {

	//Method Join Points
	
	// This method is added to demonstrate Befor and After Advice
	public void makeMyCalculation() {
		/** Do your Calculation */
		System.out.println("Calculating...");
		System.out.println("Calculation Done...");
	}

	// This method is added to demonstrate AfterReturning Advice
	public int returnSomeValue() {
		/* Do the job */
		return 10;
	}

	// This method is added to demonstrate AfterThrowing Advice
	public void throwSomeException() {
		throw new NullPointerException("A NullPointerException");
	}

	// This method is added to demonstrate around advice
	public void makeSomeOtherCalculation() {
		/* Write Business logic */
		System.out.println("Executing Business logic...");
		throw new NullPointerException();
	}
}
