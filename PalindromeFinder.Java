import java.util.ArrayList; 
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.io.*; 
import java.util.logging.*;

public class PalindromeFinder {
	public static void main(String[] args)	{
		//Setup		
		Log.L("test");
		FileReader fr = new FileReader();
		
		//Read the text file, parse each word and create an Instance of the Word class,
		//then store result as a Word array. Every instance of a Word is evaluated as palindrome
		//or non palindrome within the contructor. 
		ArrayList<Word> words = fr.LoadFile();

		//Now lets sort the array.
		try {
			Collections.sort(words, new CustomerSortingComparator());
		}
		catch (Exception e){
			Log.L("Failed to sort the collection: " + e.toString());
		}


		//FoundFirstNonPalin is a flag that tells us when we need to
		//print the newline character so that we split up the palindromes
		//and the non palindromes
		boolean foundFirstNonPalin = false;
		for(Word word: words) {
			if(word.isPalindrome) {
				System.out.println(word.letters);
			}
			else if(foundFirstNonPalin) {
			 	System.out.println(word.letters);
			}
			else if(!foundFirstNonPalin)
			{
				System.out.println("\n \n");
				System.out.println(word.letters);
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
		public Boolean isPalindrome;

		//Constructor
		public Word(String letters) {
			this.letters = StripNonLetters(letters);
			CheckIfPalindrome();
		}
		//Methods
		private void CheckIfPalindrome() {

		}
		private String StripNonLetters(String input) {
			 
			return input;
		}
	}

	static class CustomerSortingComparator implements Comparator<Word> {
		
        @Override
        public int compare(Word word1, Word word2) { 
			try	{
				// Setup for comparison
				int letterCompare = word1.letters.compareTo(word2.letters); 
				int isPalinCompare = word1.isPalindrome.compareTo(word2.isPalindrome); 
	  
				// 2-level comparison using if-else block
				//Sorts alphabetically first then on isPalindrome
				if (letterCompare == 0) { 
					return ((isPalinCompare == 0) ? letterCompare : isPalinCompare); 
				} else { 
					return letterCompare; 
				} 
			}
			catch (Exception e) {
				Log.L("Failed to compare: " + word1.letters + " To: " + word2.letters + "Error message: " + e.toString());
				return 0;
			}
            
        } 
    } 

	static class Log {
		static void L(String msg) {
			Logger logger = Logger.getLogger("PalindromeFinder");
			logger.log(Level.INFO, msg);
		}
	}
}