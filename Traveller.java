package project;
import java.util.Random;
import java.util.ArrayList; 


public class Traveller extends Inventory {
	private static String name;
	private ArrayList<Inventory> items;
	private int startingDabloons = 0;
	private int wallet;

	public static void setName(String n) {
		name = n;
	}

	public static String getName(){
		return name;
	}

	public int RandomDabloons() {

		Random rand = new Random(); 
		startingDabloons = rand.nextInt(1, 100); 
		System.out.println("Here have this "+ startingDabloons + " dabloons to start your journey.");
		setDabloonWallet(startingDabloons);
		return getDabloonWallet();

	}

	public int getDabloonWallet() {
		return wallet;
	}

	public void setDabloonWallet(int wallet) {
		this.wallet = wallet;
	}
	
	public void info(){
		System.out.println("Traveller name: " + name + "\nWallet: " + wallet );
		System.out.println("Items in Inventory: " + getItems());
		
	}

	public ArrayList<Inventory> getItems() {
		return items;
	}

	public void setItems(ArrayList<Inventory> items) {
		this.items = items;
	}


		

	
	

}
