/**
 * This program is a text-based adventure game where the player travels through different locations and encounters random events. 
 * The player can make choices and the game updates the player's inventory and dabloon wallet accordingly.
 * 
 * CMSC 22 FINAL PROJECT
 * @author: Cate Gellai Mucas and Michael Patrick Pelegrino
 * @version 3.8
 * @since 2022-12-30
 */

package project;
import java.util.Random;
import java.util.Scanner;

/**
 * The Game class represents the main gameplay of the DabloonGame. It provides methods for the player to enter their name,
 * encounter random events, and interact with a merchant.
 */
public class DabloonGame extends Encounters {
	// Initialized field
	private static Scanner scan = new Scanner(System.in);


	/**
	 * The Game class represents a text-based adventure game where the player travels through different locations and encounters random events. 
	 * It also provides methods for the player to make choices and updates the player's inventory and dabloon wallet accordingly.
	 */
	public class Game{
		// Created an instance of Traveller class
		Traveller traveller = new Traveller();

		// Created an instance of Merchant class, which is an inner class of Traveller class
		Traveller.Merchant Merchant = traveller.new Merchant();

		/**
		 * This method is the main entry point for the game. It prompts the user to enter their name,
		 * It also gets the user's current number of dabloons, and then calls the encounters method to begin the game.
		 * 
		 * @return the amount of dabloons after the user reached 2000 threshold or opted rest in the encounter method
		 */
		public int play(){
			System.out.println("\n########################################################################################"
					+ "\nHello Traveller! I see you're new to this world.\nMay I know your name?.\nEnter your name: ");

			String name = scan.nextLine();
			Traveller.setName(name);

			System.out.println("\n########################################################################################"
					+ "\nHello, " + Traveller.getName() + ".");
			traveller.setDabloons(traveller.randomizeNumber());
			int dabloonWallet = traveller.getDabloons();

			dabloonWallet = encounter(dabloonWallet);
			return dabloonWallet;
		}

		/**
		 * The encounter method simulates random events that a player can encounter during their travels. 
		 * It presents the player with options to travel, rest, or view their inventory and takes in the player's current number of dabloons. 
		 * If the player chooses to travel, a random event is generated. The method continues to loop until the player reaches a dabloon goal 
		 * or decides to rest.
		 * 
		 * @param dabloonWallet the current number of dabloons that the player has
		 * @return the current number of dabloons the player has after completing travel, or if they chose rest
		 */
		public int encounter(int dabloonWallet){
			Boolean isLoopOn = true;

			while(dabloonWallet < 2000 && isLoopOn == true) {
				System.out.println("\n########################################################################################"
						+ "\n\nMAIN MENU:\n(press designated number to proceed)\n[1]TRAVEL\n[2]REST\n[3]INVENTORY");
				String answer = scan.nextLine();

				int parsedAnswer = parseAnswer(answer);

				if(parsedAnswer == 2) {
					isLoopOn = false;
				}
				else {
					if(parsedAnswer == 1) {
						int randomEvent = randomizeNumber(dabloonWallet); 

						switch(randomEvent){
						case 1: {
							dabloonWallet = simulateTask(dabloonWallet);
							System.out.println("\nJust finished task. Here's how much we've earned: " + dabloonWallet);
							continue;
						}
						case 2: {
							dabloonWallet = Merchant.sell(dabloonWallet);
						}
						case 3: {
							Random stolen = new Random(); 
							int stolenDabloons = stolen.nextInt(50);

							System.out.println("\nOh no! There are thieves!!");

							if (dabloonWallet < stolenDabloons) {
								System.out.println("All the dabloons are taken by the thieves");
								dabloonWallet = 0;
							} else {
								System.out.println("Dabloons is decreased by: " + stolenDabloons);
								dabloonWallet -= stolenDabloons;
							}
							System.out.println(dabloonWallet + " Dabloons left after encountering thieves.");
						}
						default: {
							/* falls through */
						}
						}
					}
					else if (parsedAnswer == 3){
						Merchant.inventoryPresenter();
					}
					else{
						continue;
					}
				}
			}
			return dabloonWallet;
		}
	}


	/**
	 * This method is a modified version of the original answerParser method from the parent class.
	 * This method converts a string to an integer. If the string cannot be converted, it returns a default value.
	 * 
	 * @param answer the string to be converted
	 * @return the converted integer or a default value
	 */
	@Override
	public int parseAnswer (String answer) {
		try {
			int integerAnswer = Integer.parseInt(answer);
			return integerAnswer;
		} catch (NumberFormatException e) {
			System.out.println("Invalid number format");
			return 4;
		}
	}

	/**
	 * Generates a random integer between 1 and 3 representing a random event that the player can encounter during their travels.
	 * If the player's dabloon wallet is less than the required amount for the merchant or thieves event, the method returns 1 (a task event) instead.
	 *
	 * @param dabloonWallet the current number of dabloons that the player has
	 * @return a random integer between 1 and 3 representing a random event
	 */
	public int randomizeNumber(int dabloonWallet) {
		Random randomEvent = new Random(); 
		int event = randomEvent.nextInt(3)+1;

		if((dabloonWallet < 200 && event == 2) || (dabloonWallet < 500 && event == 3)) {
			event = 1;
			return event;
		} else {
			return event;
		}
	}

	/** 
	 * The main method is the entry point of the program. It creates an instance of the DabloonGame class and calls the play method to start the game.
	 * After the game is finished, the main method prints a message and closes the game.
	 */
	public static void main(String[] args){
		DabloonGame dabloonGame = new DabloonGame();
		DabloonGame.Game Game = dabloonGame.new Game();

		int dabloonWallet = Game.play();

		if(dabloonWallet > 2000) {
			System.out.println("\nooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo\n" +
					"\nCONGRATULATIONS!! You have earned more than 2000 dabloons in the game!");
		}
		
		System.out.println("\nooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo\n"
				+"\nDabloons earned after playing: " + dabloonWallet
				+ "\nThank you for playing!"
				+ "\nClosing game...");
	}
}