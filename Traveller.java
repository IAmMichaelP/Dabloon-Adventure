package project;
import java.util.Random;


public class Traveller{
	
	protected static String name;
	private int startingDabloons;
	
	 public static String getName()   
     {  
         return name;  
     }  

	public static void setName(String n) {
		name = n;
	}

	public int RandomDabloons(int dabloonWallet) {

		Random rand = new Random(); 
		startingDabloons = rand.nextInt(1, 100); 
		System.out.println("Here have this "+ startingDabloons + " dabloons to start your journey.");
		dabloonWallet += startingDabloons;
		return dabloonWallet;	

	}

}