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
		System.out.println(getDieRoll(numSides));
		System.out.println(getDieRoll(numSides));
	}
	public static int getDieRoll(int numSides) {
		return ((int) Math.ceil(Math.random() * numSides));
	}
	public static int getDieRoll2(int numSides) {
		Random r = new Random();
		return r.nextInt(numSides);
	}
}


