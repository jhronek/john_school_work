// John Hronek

package hronek3;

// This program is the Rock, Paper, Scissors Game against a computer opponent

import java.util.Scanner;

public class RockPaperScissors {

	public static void main(String[] args) {
		// Create a Scanner
		Scanner input = new Scanner(System.in);
		
		// Use random number 1,2,3 to decide what the computer opponent will
		// play
		int computerGuess = (int) (Math.random() * 3);

		// Prompt user for guess
		System.out.print("scissor (0), rock (1), paper (2): ");
		int playerGuess = input.nextInt();
		
		// Close Scanner
		input.close();
		
		// Display result
		if (playerGuess == 2) {
			if (computerGuess == 2)
				System.out.println("The computer is paper. You are paper too. It is a draw");
			else if (computerGuess == 1)
				System.out.println("The computer is rock. You are paper. You won");
			else
				System.out.println("The computer is scissor. You are paper. Computer won");
		}

		else if (playerGuess == 1) {
			if (computerGuess == 2)
				System.out.println("The computer is paper. You are rock. Computer won");
			else if (computerGuess == 1)
				System.out.println("The computer is rock. You are rock too. It is a draw");
			else
				System.out.println("The computer is scissor. You are rock. You won");
		}

		else if (playerGuess == 0) {
			if (computerGuess == 2)
				System.out.println("The computer is paper. You are scissor. You won");
			else if (computerGuess == 1)
				System.out.println("The computer is rock. You are scissor. Computer won");
			else
				System.out.println("The computer is scissor. You are scissor too. It is a draw");
		}

		else
			System.out.println("Input was invalid. Next time, please enter 0, 1, or 2.");
	}

}
