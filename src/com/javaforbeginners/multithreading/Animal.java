package com.javaforbeginners.multithreading;

public class Animal implements Runnable {

	// Initialize instance variables
	private String name = null;
	private int position = 0;
	private int speed = 0;
	private int maxRest;
	private Food food;
	private static boolean winner = false;

	// Create Animal constructor
	public Animal(String name, int position, int speed, int restMax, Food food) {
		super();
		this.name = name;
		this.position = position;
		this.speed = speed;
		this.maxRest = restMax;
		this.food = food;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getRestMax() {
		return maxRest;
	}

	public void setRestMax(int restMax) {
		this.maxRest = restMax;
	}

	public static boolean isWinner() {
		return winner;
	}

	static void setWinner(boolean winner) {
		Animal.winner = winner;
	}

	@Override
	public void run() {

		// Create local variable for position
		// in case an Animal has a 'head start'
		int localPosition = this.position;

		while (localPosition < 100) {

			// loop 6 times, eat, repeat
			for (int i = 0; i <= 6; i++) {
				// Rest up!
				rest();

				// Report name and race position
				System.out.printf("\n%s is running @ position %d", name, localPosition);

				// Increment position with speed variable
				localPosition += this.speed;

				// Declare a winner if position > 100 (yards)
				if (localPosition >= 100) {

					Animal.setWinner(true);

					System.out.printf("\n%s has won the race!", name);

					System.exit(0);
				}
			
			}
			// Eat!
			eat();

		}

	}

	private void eat() {
		int mealTime = 4 * this.maxRest;
		try {
			food.eat(this.name, mealTime);
		} catch (InterruptedException e) {
			System.out.printf("\nInterruptedException in eat() for %s", this.name);
		}
	}

	private void rest() {
		try {
			Thread.sleep(this.maxRest);
		} catch (InterruptedException e) {
			System.out.printf("\nInterruptedException in rest() for %s", this.name);
		}
	}

}

/*
 * if (localPosition >= 100) { Animal.winner = true;
 * System.out.printf("\n%s has won the race!", name);
 * 
 * System.exit(0); }
 */