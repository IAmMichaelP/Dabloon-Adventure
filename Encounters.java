package project;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;




public class Encounters extends Traveller {
	private static Scanner scan = new Scanner(System.in);
	protected String itemName;
	List<String> items = new ArrayList<>(Arrays.asList(itemName));


	public int task(int dabloonWallet){

		Random task = new Random(); 
		int taskNum = task.nextInt(1,6);
		System.out.println("\nThis is inside task() dabloons is: " + dabloonWallet);

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
				System.out.println("Earned: " + dabloonWallet);


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
				System.out.println("Earned: " + dabloonWallet);


			}
			else {
				System.out.println("\nOffer rejected.");
			}

		}
		else if(taskNum == 3) {//task3
			System.out.println("\n########################################################################################");
			System.out.println("Lost NPC is asking for directions!");
			System.out.println("Help NPC?");
			System.out.println("Yes / No");
			String answer = scan.nextLine();

			if(answer.equalsIgnoreCase("Yes")) {
				System.out.println("\nYou gave directions.");
				System.out.println("NPC: THANKS!!");

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

			}
			else {
				System.out.println("\nOffer rejected.");
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
				System.out.println("\nOffer rejected.");
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
			}
			else {
				System.out.println("\nOffer rejected.");
			}
		}
		return dabloonWallet;

	}


	public int merchant(int dabloonWallet) {
		System.out.println("\n########################################################################################");
		System.out.println("Encountered a shop along the way..");
		Boolean buy = true;


		while(buy == true) {
			System.out.println("\nWELCOME TO ");
			System.out.println("What item would you like to buy? We have a few...");
			System.out.println("Items for sale: \nWater     --- 10 dabloons\nMap       --- 15 dabloons\nTorch     --- 40 dabloons\nBlanket   --- 80 dabloons\nTent      --- 200 dabloons  " );
			System.out.println("Enter any key to leave shop");
			String answer = scan.nextLine();

			if(answer.equalsIgnoreCase("water")) {
				System.out.println("\nWater is added to inventory.");
				dabloonWallet -= 10;
				itemName = "Water ";
				items.add(itemName);

			}
			else if(answer.equalsIgnoreCase("map")){
				System.out.println("\nMap is added to inventory.");
				dabloonWallet -= 15;
				itemName = "Map ";
				items.add(itemName);
			}
			else if(answer.equalsIgnoreCase("torch")){
				System.out.println("\nTorch is added to inventory.");
				dabloonWallet -= 40;
				itemName = "Torch ";
				items.add(itemName);
			}
			else if(answer.equalsIgnoreCase("blanket")){
				System.out.println("\nBlanket is added to inventory.");
				dabloonWallet -= 80;
				itemName = "Blanket ";
				items.add(itemName);
			}
			else if(answer.equalsIgnoreCase("tent")){
				System.out.println("\nTent is added to inventory");
				dabloonWallet -= 200;
				itemName = "Tent ";
				items.add(itemName);
			}
			else {
				System.out.println("You left the shop.");
				buy = false;
			}
		}return dabloonWallet;}
	
	public void info(){
		System.out.println("Traveller name: " + name);
		System.out.println("Items in Inventory: " );
		for(String itemName : items){
			System.out.print( itemName );//outputs null
		}


	}


}


