package project;
import java.util.Random;
import java.util.Scanner;

import java.util.HashMap;
import java.util.Map;

public class DabloonGame extends Encounters {
	private static Scanner scan = new Scanner(System.in);
	private int dabloonWallet;
	private Map<String, Integer> storeInventory;
	private Map<String, Integer> userInventory;
	public DabloonGame () {
	    // Create the store inventory
	    storeInventory = new HashMap<>();
	    storeInventory.put("water", 10);
	    storeInventory.put("map", 15);
	    storeInventory.put("torch", 40);
	    storeInventory.put("blanket", 80);
	    storeInventory.put("tent", 200);
	    // Create the user's inventory
	    userInventory = new HashMap<>();
	    scan = new Scanner(System.in);
	  }
	
	public class Game{
		Merchant merchant = new Merchant();
		public void play(){
			Traveller traveller = new Traveller();
			
			System.out.println("\n########################################################################################"
					+ "\nHello Traveller! I see you're new to this world.\nMay I know your name?.\nEnter your name: ");

			String name = scan.nextLine();
			Traveller.setName(name);

			System.out.println("\n########################################################################################");
			System.out.println("\nHello, " + Traveller.getName() + ".");
			setDabloons(traveller.RandomDabloons(dabloonWallet));
			dabloonWallet = getDabloons();

			encounters(dabloonWallet);
			
		}
		
		public void encounters(int dabloonWallet){


			Boolean isLoop = true;


			while(dabloonWallet < 2000 && isLoop == true) {
				System.out.println("\n########################################################################################"
						+ "\nPRESS:\n[1]TRAVEL\n[2]REST\n[3]INVENTORY");
				String action = scan.nextLine();
				int parsedAnswer = answerParser(action);

				if(parsedAnswer == 2) {
					isLoop = false;
				}
				else {
					System.out.println("\nparsed answer is"+parsedAnswer+"\n");
					if(parsedAnswer ==1) {
						System.out.println("Caught inside switch");
					
						int randomEvent = randomizer(dabloonWallet); 
						
						switch(randomEvent){
						case 1: {
							dabloonWallet = task(dabloonWallet);
							System.out.println("\nJust exited task heres how much we've earned: " + dabloonWallet);
							continue;
						}
						case 2: {
							

							dabloonWallet = merchant.merchant(dabloonWallet);
							
						}
						case 3: {//thieves

							Random stolen = new Random(); 
							int stolenDabloons = stolen.nextInt(10,50);
					
							System.out.println("\nOh no! There are thieves!!");
							System.out.println("Dabloons is decreased by: " + stolenDabloons);
							dabloonWallet -= stolenDabloons;
							System.out.println(dabloonWallet + " Dabloons left after encountering thieves.");
								
						
							}
						default:{
							System.out.println("caught in the inner default");
						}

						}

					}
					else if (parsedAnswer == 3){
						
						System.out.println("\nYour inventory: ");
					    for (String item : userInventory.keySet()) {
					    	System.out.println(item + userInventory.get(item));
					    	
					    }
						continue;
					}
					else{
						System.out.println("You receive a default");
						continue;
					}
				}

				}
				
			}

		}
	

	@Override
	public int answerParser (String action) {
		System.out.println("you catch in answerParser");
		try {
			  int num = Integer.parseInt(action);
			  return num;
			} catch (NumberFormatException e) {
			  System.out.println("Invalid number format");
			  return 4;
			}
	}

	public int randomizer(int dabloonWallet) {
		System.out.println("Caught in the randomizer");
		Random rEvent = new Random(); 
		int randomEvent = rEvent.nextInt(3)+1;
		System.out.println("randomEvent is "+randomEvent +"\ndabloonWallet is "+dabloonWallet);
		if((dabloonWallet < 200 && randomEvent == 2) || (dabloonWallet < 500 && randomEvent == 3)) {
			randomEvent = 1;
			System.out.println("randomEvent is "+randomEvent +"\ndabloonWallet is "+dabloonWallet);
			return randomEvent;
		} else {
			System.out.println("randomEvent is "+randomEvent +"\ndabloonWallet is "+dabloonWallet);
			return randomEvent;
		}
		
		
		
	}
	
	public int getDabloons(){
		return dabloonWallet;
	}

	public void setDabloons(int dabloonWallet) {
		this.dabloonWallet = dabloonWallet;
	}

	public class Merchant {
		public int merchantAnswerParser (String answer) {
			try {
				  int num = Integer.parseInt(answer);
				  return num;
				} catch (NumberFormatException e) {
				  System.out.println("Invalid number format");
				  return 6;
				}
		}
		public int merchant(int dabloonWallet) {
		    

			System.out.println("\n########################################################################################");
			System.out.println("Encountered a shop along the way..");
			Boolean buy = true;


			while(buy == true) {
				System.out.println("\nWELCOME TO THE SHOP");
				System.out.println("Attendant: What item would you like to buy? We have a few...");
				System.out.println("\nStore inventory: ");
			    for (String item : storeInventory.keySet()) {
			      System.out.println(item + " - $" + storeInventory.get(item));
			    }
				System.out.println("\nWallet: " + dabloonWallet
						+"\nEnter designated number to buy the item, any other key to leave." + "\n[1]Water  [2]Map  [3]Torch   [4]Blanket  [5]Tent [0]Exit shop");
			    System.out.println("\nYour inventory: ");
			    for (String item : userInventory.keySet()) {
			      System.out.println(item + userInventory.get(item));
			    }
				String answer = scan.nextLine();
				int parsedAnswer = merchantAnswerParser(answer);

				if (dabloonWallet < 10) {
					System.out.println("You don't have enough amount of dabloons left to buy anything");
					continue;
				}
				else if(parsedAnswer == 1 && storeInventory.containsKey("water")) {
					System.out.println("\nWater is added to inventory.");
					// Add the item to the user's inventory
			        int quantity = userInventory.getOrDefault("water", 0);
			        userInventory.put("Water", quantity + 1);

			        // Remove the item from the store inventory
			        quantity = storeInventory.get("water");
			        if (quantity > 1) {
			          storeInventory.put("water", quantity - 1);
			        } else {
			          storeInventory.remove("water");
			        }
					dabloonWallet -= 10;
				}
				else if(parsedAnswer == 2 && storeInventory.containsKey("map")) {
					System.out.println("\nMap is added to inventory.");
					// Add the item to the user's inventory
			        int quantity = userInventory.getOrDefault("map", 0);
			        userInventory.put("map", quantity + 1);

			        // Remove the item from the store inventory
			        quantity = storeInventory.get("map");
			        if (quantity > 1) {
			          storeInventory.put("map", quantity - 1);
			        } else {
			          storeInventory.remove("map");
			        }
					dabloonWallet -= 15;
				}
				else if(parsedAnswer == 3 && storeInventory.containsKey("torch")) {
					System.out.println("\nTorch is added to inventory.");
					// Add the item to the user's inventory
			        int quantity = userInventory.getOrDefault("torch", 0);
			        userInventory.put("torch", quantity + 1);

			        // Remove the item from the store inventory
			        quantity = storeInventory.get("torch");
			        if (quantity > 1) {
			          storeInventory.put("torch", quantity - 1);
			        } else {
			          storeInventory.remove("torch");
			        }
					dabloonWallet -= 40;
				}
				else if(parsedAnswer == 4 && storeInventory.containsKey("blanket")) {
					System.out.println("\nBlanket is added to inventory.");
					// Add the item to the user's inventory
			        int quantity = userInventory.getOrDefault("blanket", 0);
			        userInventory.put("blanket", quantity + 1);

			        // Remove the item from the store inventory
			        quantity = storeInventory.get("blanket");
			        if (quantity > 1) {
			          storeInventory.put("blanket", quantity - 1);
			        } else {
			          storeInventory.remove("blanket");
			        }
					dabloonWallet -= 80;
				}
				else if(parsedAnswer == 5 && storeInventory.containsKey("tent")) {
					System.out.println("\nTent is added to inventory.");
					// Add the item to the user's inventory
			        int quantity = userInventory.getOrDefault("tent", 0);
			        userInventory.put("tent", quantity + 1);

			        // Remove the item from the store inventory
			        quantity = storeInventory.get("tent");
			        if (quantity > 1) {
			          storeInventory.put("tent", quantity - 1);
			        } else {
			          storeInventory.remove("tent");
			        }
					dabloonWallet -= 200;
				}
				else {
					System.out.println("You left the shop.");
					buy = false;
				}
			}return dabloonWallet;
		}
	}
	public static void main(String[] args){
		


		
		DabloonGame dabloonGame = new DabloonGame();
		DabloonGame.Game game = dabloonGame.new Game();
		game.play();
		
		System.out.println("\nDabloons earned after playing: " );
		System.out.println("Thank you for playing!");
		System.out.println("Closing game...");
		
	}


}