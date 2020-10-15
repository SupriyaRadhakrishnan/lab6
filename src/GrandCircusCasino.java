import java.util.*;
import java.util.Scanner;
// Pair Programming - Jess , Skye and Supriya
public class GrandCircusCasino {

	private static Scanner scnr = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Welcome to grandcircus Casino");
		String prompt ="Enter the number of Sides :";
		Scanner scnr = new Scanner(System.in);
		int noOfSides = Validator.getInt(scnr,prompt);
		if(noOfSides > 0)
		rollDice(noOfSides);
		System.out.println("Thank You for playing");
		
	}

	public static void rollDice(int noOfSides) {
		boolean isRoll = true;
		int rollCount = 0;
		boolean isChoice = false;
		int firstDie = 0;
		int secondDie = 0;
		while (isRoll) {
			rollCount++;
			System.out.println("Roll " + rollCount);
			firstDie = generateRandomDieRoll(noOfSides);
			secondDie = generateRandomDieRoll(noOfSides);
			System.out.println(firstDie);

			System.out.println(secondDie);
			hasSpecialRoll(firstDie, secondDie);
			do {
				isChoice = false;
				String prompt = "Do you wish to continue(y/n) :";
				String yourChoice = Validator.getString(scnr,prompt);

				if (yourChoice.equalsIgnoreCase("y"))
					;
				else if (yourChoice.equalsIgnoreCase("n"))
					{
					isRoll = false;
				    }
				else {
					System.out.println("Invalid Choice.");
					isChoice = true;
				}

			} while (isChoice);
		}

	}

	public static int generateRandomDieRoll(int noOfSides) {
		Random r = new Random();
		int low = 1;
		int high = noOfSides;
		int result = r.nextInt(high - low) + low;
		return result;
	}

	public static void hasSpecialRoll(int firstDie, int secondDie) {
		int sumOfDice = firstDie + secondDie;
		if (firstDie == 1 && secondDie == 1) {
			System.out.println("You got SnakeEyes");
		} else if (firstDie == 6 && secondDie == 6) {
			System.out.println("You got BoxCars");
		} else if (sumOfDice == 7) {
			System.out.println("You got Craps");
		} else if (sumOfDice == 11) {
			System.out.println("You got Craps");
		}
	}
}
