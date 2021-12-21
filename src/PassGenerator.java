/**
 * Random Password Generator
 * Gives the user two prompts, first how many passwords would they like to be generated
 * second how many characters would they like the passwords to be.
 * The generator will use ASCII values for integers 0-9, or english alphabet, lower or uppercase.
 */
import java.util.*;

public class PassGenerator {

	
	public static char genRandChar() {
		/*The Math.random() function returns a semi-random double ranging from 0.0 to 1.0.
		So when we multiply Math.random() by 78, we do this because there are 26 lowercase letters,
		26 uppercase letters, 10 numbers, and 16 special characters. (26 + 26 + 10 + 16 = 78)*/
		
		//This random number has values between 0 (inclusive) and 79 (exclusive)
		int rand = (int)(Math.random()*78);
		
		
		if(rand <= 15) {
			//Number (32-47 in ASCII)
			//To convert from 0-15 to 32-47, we can add 32 to rand because 32-0 = 32
			int symbol = rand + 32;
			//This way, rand = 0 => symbol = 48 => '0'
			return (char)(symbol);
		} else if(rand > 15 || rand <= 25) {
			//Uppercase letter (65-90 in ASCII)
			//To convert from 10-35 to 65-90, we can add 55 to rand because 65-10 = 55
			int number = rand + 48;
			//This way, rand = 10 => uppercase = 65 => 'A'
			return (char)(number);
		} else if(rand > 24 || rand <= 51) {
			
			int uppercase = rand + 65;
			
			return (char)(uppercase);
		} else {
			//Lowercase letter (97-122 in ASCII)
			//To convert from 36-61 to 97-122, we can add 61 to rand because 97-36 = 61
			int lowercase = rand + 98;
			//This way, rand = 36 => lowercase = 97 => 'a'
			return (char)(lowercase);
		}
	}
	/**
	 * Method to print the contents of the password array to the console.
	 * @param arr, the array to be printed
	 */
	public static void printArray(String[] arr) {
		for(int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

	public static void main(String[] args) {
		//Declard variables for the number of passwords and the length of the passwords
		int numberOfPasswords, lengthOfPassword;

		//Create a scanner object to take the users input
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Welcome to the password generator\n");
		
		System.out.println("How many randomly generated passwords would "
				+ "you like the generator to create? \n");
		//store the users input as to how many passwords they want generated
		numberOfPasswords = scan.nextInt();
		
		System.out.println("How long, as in how many characters would "
				+ "you like the passwords to be? \n");
		//store the users input as to how long they want the passwords to be
		lengthOfPassword = scan.nextInt();
		
		String[] passwordArray = new String[numberOfPasswords];
		
		for(int i = 0; i < numberOfPasswords; i++) {
			
			String randPass = "";
			
			for(int j = 0; j < lengthOfPassword; j++) {
				
				randPass += genRandChar();
			}
			passwordArray[i] = randPass;
		}
		printArray(passwordArray);
	}

}
