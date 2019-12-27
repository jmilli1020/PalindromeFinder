import java.util.ArrayList; 
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.io.*; 

public class PalindromeFinder {
	public static void main(String[] args)	{
		//Setup
		//Read the text file, parse each word and create an Instance of the Word class,
		//then store result as a Word array. Every instance of a Word is evaluated as palindrome
		//or non palindrome within the contructor. 
		FileReader fr = new FileReader();
		ArrayList<Word> words = fr.LoadFile();

		//Now lets sort the array.
		try {
			Collections.sort(words, Comparator.comparing(Word::getLetters)
			.thenComparing(Word::getIsPalindrome));
		}
		catch (Exception e){
			System.out.println("Failed to sort the collection: " + e.toString());
		}

		//Now lets write the palindromes to the console
		System.out.println("Printing all palindromes now:");
		for(Word word: words) {
			if(word.isPalindrome) {
				System.out.println(word.letters);
			}
		}

		//Now lets print the non-palindromes
		System.out.println("Printing all non-palindromes now:");
		for(Word word: words) {
			if(!word.isPalindrome) {
				System.out.println(word.letters + " : Failed when comparing letters: " + word.palindromeFailPoint);
			}
		}
	}
	static class FileReader {
		//Attributes
		private String inputFilePath;

		//Constructor
		public FileReader() {
			inputFilePath = System.getProperty("user.dir");
		}
		//Methods
		public ArrayList<Word> LoadFile() {
			//Setup
			System.out.println("Loading text file...");
			ArrayList<Word> words = new ArrayList<Word>();
			try {
				//Fetch file contents by passing a file path			
				File file = new File(inputFilePath + "\\word-list.txt"); 

				//Create a scanner to read the file
				Scanner sc = new Scanner(file); 
				while (sc.hasNextLine()) 
					//Foreach line create a new Word and add it to the arrayList words
					words.add(new Word(sc.nextLine()));
				System.out.println("Loading text file complete");
				sc.close();
				return words;
			}
			catch (Exception e) {
				System.out.println("Failed to load text file: " + e.getMessage());
				words = null;
				return words;
			}

		}
	}
	static class Word {		
		//Attributes
		public String letters;
		public String palindromeFailPoint;
		public Boolean isPalindrome = false;

		//Constructor
		public Word(String letters) {
			this.letters = StripNonLetters(letters.toLowerCase());
			this.palindromeFailPoint = "";
			CheckIfPalindrome();
		}
		//Methods
		public String getLetters() {
			return this.letters;
		}
		public Boolean getIsPalindrome() {
			return this.isPalindrome;
		}
		private void CheckIfPalindrome() {
			try {
				int j = this.letters.length()-1;//Substract 1 so we don't got out of bounds
				int stopPoint = GetStopPoint((double) j);//Need to pass it a double so that we can divide it to try to find the middle
				for(int i = 0; i < stopPoint; i++) {
					if(this.letters.charAt(i) == this.letters.charAt(j)) {
						this.isPalindrome = true;
						j--; //Decrement j so the end comparer back to keep up with i moving forward
					}
					else {
						//They're not the same so lets set the fail point variable and break out of the loop
						this.isPalindrome = false;
						this.palindromeFailPoint += this.letters.charAt(i);
						this.palindromeFailPoint += this.letters.charAt(j);
						break;
					}
				}
			} 			
			catch (Exception e) {
				System.out.println("Failed to determine if " + this.letters + " Was a palindrome. Error message: " + e.toString());
			}

		}
		private int GetStopPoint(double endComparePosition) {
			double midPoint = endComparePosition/2;
			boolean notWhole = true;
			int returnVal = 0;
			if( midPoint % 1 == 0) {
				notWhole = false; 
				//Adding plus 1 to midpoint so that for even length strings we can compare the inner most chars
				returnVal = (int) midPoint + 1;
			}
			if(notWhole){
				midPoint = midPoint + 0.5;
				returnVal = (int) midPoint;
			}
			return returnVal;
		}
		private String StripNonLetters(String input) {
			try {
				//Split on all non alphas
				String[] stringArray = input.split("\\W+");
				String result = new String();
				for(int i = 0; i < stringArray.length;i++){
					result = result+ stringArray[i];
				}
				return result;
			}
			catch(Exception e) {
				System.out.println("Failed to strip non alphas from: " + input + "Error message: " + e.toString());
				return input;
			}
		}
	}
}