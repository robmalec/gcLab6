package co.grandcircus;

import java.util.Random;
import java.util.Scanner;

public class Lab6 {
	public static void main(String[] args) {
		char again = 'y';
		Scanner scn = new Scanner(System.in);
		int numSides = 0;
		do {
			try {
				System.out.println("How many sides should each die have?");
				numSides = scn.nextInt();
				
				rollBothDice(numSides);
				
				System.out.println("Roll again?");
				again = scn.next().charAt(0);
				if ((again != 'y') && (again != 'n')) {
					again = 'y';
					throw new Exception();
				}
			}
			catch (Exception e){
				System.out.println("Invalid input.  Try again.");
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
	public static int getDieRoll(int numSides) {
		return ((int) Math.ceil(Math.random() * numSides));
	}
	public static int getDieRoll2(int numSides) {
		Random r = new Random();
		return r.nextInt(numSides);
	}
	public static void rollAndPrintMsg(int numSides) {
		int i = getDieRoll(numSides);
		printMsg(i);
		System.out.println(i);
	}
	public static void printMsg(int roll) {
		
	}
}


