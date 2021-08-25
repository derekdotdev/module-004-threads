package com.javaforbeginners.multithreading;

public class Food {

	// constructor
	public Food() {
		super();
	}

	// mealTime = ( 4 * Animal.maxRest )
	synchronized public void eat(String name, int mealTime) throws InterruptedException {

		System.out.printf("\n%s began eating.", name);

		Thread.sleep(mealTime);

		System.out.printf("\n%s finished eating.", name);
	}

}
