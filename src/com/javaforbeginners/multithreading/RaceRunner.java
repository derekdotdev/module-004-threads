package com.javaforbeginners.multithreading;

public class RaceRunner {

	public static void main(String[] args) {


		// Create single instance of Food class
		Food food = new Food();

		// Create two instances of Animal class (part 1 (no eat() method)
		// Animal rabbit = new Animal("Rabbit", 0, 5, 173, food);
		// Animal turtle = new Animal("Turtle", 0, 3, 99, food);

		// Create two instances of Animal class (part 2 - unsynchronized)
		// Animal rabbit = new Animal("Rabbit", 0, 5, 175, food);
		// Animal turtle = new Animal("Turtle", 0, 3, 96, food);

		// Create two instances of Animal class (part 2 - synchronized)
		Animal rabbit = new Animal("Rabbit", 0, 5, 173, food);
		Animal turtle = new Animal("Turtle", 0, 3, 100, food);


		// public Animal(String name, int position, int speed, int restMax)
		// Use those instances to create Threads
		Thread rabbitThread = new Thread(rabbit);
		Thread turtleThread = new Thread(turtle);

		// Set as "user" threads (as opposed to daemon threads)
		rabbitThread.setDaemon(false);
		turtleThread.setDaemon(false);

		// Start threads
		rabbitThread.start();
		turtleThread.start();

	}

}
