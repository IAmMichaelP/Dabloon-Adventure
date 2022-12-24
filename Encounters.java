package project;
import java.util.Scanner;
import java.util.Random;




public class Encounters extends Traveller{
	private static Scanner scan = new Scanner(System.in);
	protected int itemNum;



	public int task(int dabloonWallet){

		Random task = new Random(); 
		int taskNum = task.nextInt(1,6);

		if(taskNum == 1) {//task1
			System.out.println("\n########################################################################################");
			System.out.println("An elderly cat is asking for your assistance to carry his luggage...");
			System.out.println("Help the elderly cat?");
			System.out.println("Yes / No");
			String answer = scan.nextLine();

			if(answer.equalsIgnoreCase("Yes")) {
				System.out.println("\nYou have accepted the offer!");
				System.out.println("Elder Cat: Thank you for helping, here take this 70 dabloons.");
				dabloonWallet += 70;
				System.out.println("Dabloons after accepting offer: " + dabloonWallet);
			}
			else {
				System.out.println("\nOffer rejected.");
			}
		}
		else if (taskNum == 2) {//task2
			System.out.println("\n########################################################################################");
			System.out.println("Encountered a NPC cat!");
			System.out.println("NPC cat is asking for your assistance to deliver letters to the village...");
			System.out.println("Accept task?");
			System.out.println("Yes / No");
			String answer = scan.nextLine();

			if(answer.equalsIgnoreCase("Yes")) {
				System.out.println("\nNPC Cat: Thanks for helping! ");
				System.out.println("NPC Cat: I'll pay you 100 dabloons. ");
				dabloonWallet += 100;
				System.out.println("Dabloons after accepting offer: " + dabloonWallet);
			}
			else {
				System.out.println("\nOffer rejected.");

			}
		}
		else if(taskNum == 3) {
			System.out.println("\n########################################################################################");
			System.out.println("Lost NPC is asking for directions!");
			System.out.println("Help NPC?");
			System.out.println("Yes / No");
			String answer = scan.nextLine();

			if(answer.equalsIgnoreCase("Yes")) {
				System.out.println("\nYou gave directions for free.");
				System.out.println("NPC: Thank you! Be careful on your journey...");
			}
			else {
				System.out.println("\nOffer rejected.");
			}
		}
		else if(taskNum == 4) {
			System.out.println("\n########################################################################################");
			System.out.println("NPC offering Hot Soup!");
			System.out.println("Accept offer?");
			System.out.println("Yes / No");
			String answer = scan.nextLine();

			if(answer.equalsIgnoreCase("Yes")) {
				System.out.println("\nSoup accepted.");
				System.out.println("NPC gave you 200 dabloons");
				dabloonWallet += 200;
			}
			else {
				System.out.println("\nSoup rejected.");
			}
		}
		else if(taskNum == 5) {
			System.out.println("\n########################################################################################");
			System.out.println("NPC offering Bread!");
			System.out.println("Accept offer?");
			System.out.println("Yes / No");
			String answer = scan.nextLine();

			if(answer.equalsIgnoreCase("Yes")) {
				System.out.println("\nBread accepted.");
			}
			else {
				System.out.println("\nBread rejected.");
			}
		}
		else if(taskNum == 5) {
			System.out.println("\n########################################################################################");
			System.out.println("Inn Owner: Hey, it's getting quite cold outside.");
			System.out.println("Inn Owner: Stay in my Inn?");
			System.out.println("Staying in Inn costs 100 dabloons.");
			System.out.println("\nYes / No");
			String answer = scan.nextLine();

			if(answer.equalsIgnoreCase("Yes")) {
				System.out.println("\nStaying in Inn.");
				dabloonWallet -= 100;
				System.out.println("Dabloons after accepting offer: " + dabloonWallet);

			}
			else {
				System.out.println("\nOffer rejected.");
			}
		}
		else if(taskNum == 6) {
			System.out.println("\n########################################################################################");
			System.out.println("You found an empty cabin!");
			System.out.println("Enter cabin?");
			System.out.println("\nYes / No");
			String answer = scan.nextLine();

			if(answer.equalsIgnoreCase("Yes")) {
				System.out.println("\nEntered cabin.");
				System.out.println("You found 500 dabloons in the cabin!!");
				dabloonWallet += 500;
			}
			else {
				System.out.println("\nOffer rejected.");
			}
		}
		return dabloonWallet;

	}


	public int merchant(int dabloonWallet, int itemNum) {

		System.out.println("\n########################################################################################");
		System.out.println("Encountered a shop along the way..");
		Boolean buy = true;


		while(buy == true) {
			System.out.println("\nWELCOME TO ");
			System.out.println("What item would you like to buy? We have a few...");
			System.out.println("Items for sale: \nWater     --- 10 dabloons\nMap       --- 15 dabloons\nTorch     --- 40 dabloons\nBlanket   --- 80 dabloons\nTent      --- 200 dabloons  " );
			System.out.println("\nWallet: " + dabloonWallet);
			System.out.println("Enter any key to leave shop");
			String answer = scan.nextLine();

			if(answer.equalsIgnoreCase("water")) {
				System.out.println("\nWater is added to inventory.");
				dabloonWallet -= 10;

				itemNum = 1;
				return itemNum;
			}
			else if(answer.equalsIgnoreCase("map")){
				System.out.println("\nMap is added to inventory.");
				dabloonWallet -= 15;

				itemNum = 2;
				return itemNum;
			}
			else if(answer.equalsIgnoreCase("torch")){
				System.out.println("\nTorch is added to inventory.");
				dabloonWallet -= 40;

				itemNum = 3;
				return itemNum;
			}
			else if(answer.equalsIgnoreCase("blanket")){
				System.out.println("\nBlanket is added to inventory.");
				dabloonWallet -= 80;

				itemNum = 4;
				return itemNum;
			}
			else if(answer.equalsIgnoreCase("tent")){
				System.out.println("\nTent is added to inventory");
				dabloonWallet -= 200;

				itemNum = 5;
				return itemNum;

			}
			else {
				System.out.println("You left the shop.");
				buy = false;
			}
		}return dabloonWallet;
	}


}


