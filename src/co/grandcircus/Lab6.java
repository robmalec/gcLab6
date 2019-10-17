package co.grandcircus;

import java.util.Random;
import java.util.Scanner;

public class Lab6 {
	
	static int numSides = 0;
	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		char again = 'y';
		Boolean askNumSides = true;
		int rollNum = 1;
		do {
			try {
				//Asking the number of sides on each dice, if necessary
				if (askNumSides) {
					promptNumSides();
				}
				
				//Making sure it doesn't automatically ask again unless prompted
				askNumSides = false;
				
				//Making a label for this roll
				System.out.println("Roll #" + rollNum + ":");
				
				//Rolling the dice
				rollBothDice(numSides);
				rollNum++;
				
				//Prompting the user for what to do now
				System.out.println("Roll again? Type y for yes, n for no, or c to change the number of sides on the dice.");
				
				//Error checking on the user's response
				again = scn.next().charAt(0);
				if (again == 'c') {
					askNumSides = true;
					again = 'y';
				}
				else if ((again != 'y') && (again != 'n')) {
					again = 'y';
					throw new Exception();
				}
			}
			catch (Exception e){
				System.out.println("Invalid input.  Rolling again anyways.");
				scn.nextLine();
			}
		} while (again == 'y');
	}
	public static void rollBothDice(int numSides) {
		int roll1 = getDieRoll(numSides), roll2 = getDieRoll(numSides), sum = roll1 + roll2;
		
		System.out.println(roll1);
		System.out.println(roll2);
		
		switch (sum) {
		case 2:
			System.out.println("Snake eyes!");
		case 3:
			System.out.println("Craps!");
			break;
		case 12:
			if (roll1 == roll2) {
				System.out.println("Boxcar!");
			}
			System.out.println("Craps!");
			break;
			default:
				break;
		}
		
	}
	public static void promptNumSides() {
		Boolean good = false;
		do {
			System.out.println("How many sides should each die have?");
			numSides = scn.nextInt();
			if (numSides == 0) {
				System.out.println("A zero-sided dice?  Are you kidding me?  Try again!");
			}
			else if (numSides < 0) {
				System.out.println("Oh come on now.  You can't have a negative number of anything.  Get real.");
			}
			else
			{
				good = true;
			}
		}while (!good);
	}
	public static int getDieRoll(int numSides) {
		return ((int) Math.ceil(Math.random() * numSides));
	}
	public static int getDieRoll2(int numSides) {
		Random r = new Random();
		return r.nextInt(numSides);
	}
}


