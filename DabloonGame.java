package project;
import java.util.Random;
import java.util.Scanner;


public class DabloonGame extends Encounters {
	private static Scanner scan = new Scanner(System.in);
	protected int dabloonWallet;
	private int event;

	public DabloonGame(){
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
			System.out.println("\n########################################################################################");
			System.out.println("\nDo you wish to travel?");
			System.out.println("\nYes / No");
			System.out.println("Enter 'Inventory' to check inventory. ");
			String ans = scan.nextLine();
			String choice = ans.toLowerCase();

			if(ans.equalsIgnoreCase("no")) {
				isLoop = false;
			}
			else {

				switch(choice) {
				case "yes":{
					Random rEvent = new Random(); 
					event = rEvent.nextInt(1,3); 

					switch(event){
					case 1: {
						dabloonWallet = task(dabloonWallet);
						System.out.println("\nJust exited task here's how much you've earned: " + dabloonWallet);
						continue;
					}
					case 2: {
						dabloonWallet = merchant(dabloonWallet);
						continue;

					}
					case 3: {//thieves

						Random stolen = new Random(); 
						int stolenDabloons = stolen.nextInt(50);
						if(dabloonWallet > stolenDabloons) {

							System.out.println("Oh no! There are thieves!!");
							System.out.println("Dabloons is decreased by: " + stolenDabloons);
							dabloonWallet -= stolenDabloons;
							System.out.println("Dabloons decreased by " + stolenDabloons +" after encountering thieves.");
							continue;
						}

					}
					}

				}
				case "no":{
					isLoop = false;
				}
				case "inventory" :{
					Encounters inventory = new Encounters();
					inventory.info();
				}
				default:{
					break;
				}
				}

			}
		}

	}
	

	public int getDabloons(){
		return dabloonWallet;
	}

	public void setDabloons(int dabloonWallet) {
		this.dabloonWallet = dabloonWallet;
	}

	public static void main(String[] args){
		DabloonGame game = new DabloonGame();

		System.out.println("Dabloons earned after playing: " + game.dabloonWallet);
		System.out.println("Thank you for playing!");
		System.out.println("Closing game...");
		
	}


}