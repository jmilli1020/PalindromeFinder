import java.util.Arrays;
import java.util.Comparator;

public class PalindromeFinder {
	public static void main(String[] args)	{
		//Setup		
		Log log = new Log();
		IO io = new IO();
		
		//Read the text file, parse each word and create an Instance of the Word class,
		//then store result as a Word array. Every instance of a Word is evaluated as palindrome
		//or non palindrome within the contructor. 
		Word[] words = io.LoadFile();

		//Now lets sort the array.
		
		Arrays.sort(words, new CustomerSortingComparator());

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
	static class IO {
		//Attributes
		private String inputFilePath;
		private String outputFilePath;

		//Constructor
		public IO() {
			InitProperties();
		}
		//Methods
		private void InitProperties() {
			//If config exists lets use those settings

			//Else lets use default workingDirectory
		}
		public Word[] LoadFile() {
			System.out.println("Loading text file...");
			Word words[] = new Word[1];
			try {
				//Fetch file contents
				System.out.println("Loading text file complete");
				return words;
			}
			catch (Exception e) {
				System.out.println("Failed to load text file: " + e.getMessage());
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
			//COnvert to String are so that 
			return "";
		}
	}

	static class CustomerSortingComparator implements Comparator<Word> {
		
        @Override
        public int compare(Word word1, Word word2) { 
  
            // for comparison 
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
    } 

	static class Log {
		String logFilePath ;

		public void Write(String msg) {
			//Write

		}
	}
}