package MyTestcases;

import java.util.Random;

public class Parameters {

	Random rand =new Random();
	
	String[] firstNames = {"Alex", "Emily", "Jordan", "Liam", "Sophia", "Ryan", "Maya", "Ethan", "Olivia", "Nathan"};
	String[] lastNames = {"Smith", "Johnson", "Williams", "Jones", "Brown", "Davis", "Miller", "Wilson", "Moore", "Taylor"};
	String CommonPassword = "Abc123@#"; 
	int randEmailId = rand.nextInt(9999);
	int RandIndex = rand.nextInt(10);
	String EmailAddres = firstNames[RandIndex]+lastNames[RandIndex]+randEmailId+"@"+"gmail.com";
}



