import java.util.Arrays;
import java.util.Comparator;

public class PalindromeFinder {

	public static void main(string[] args)	{
		//Setup		
		IO io = new IO();
		Log log = new Log();
		
		//Read the text file, parse each word and create an Instance of the Word class,
		//then store result as a Word array. Every instance of a Word is evaluated as palindrome
		//or non palindrome within the contructor. 
		Word[] words = io.LoadFile();

		//Now lets sort the array.
		Collections.sort(words, new CustomerSortingComparator());
		Arrays.Sort(words);

		//FoundFirstNonPalin is a flag that tells us when we need to
		//print the newline character so that we split up the palindromes
		//and the non palindromes
		Bool foundFirstNonPalin = false;
		for(Word word: words) {
			if(word.isPalindrome) print(word.letters);
			else(foundFirstNonPalin) print(word.letters);
			else(!foundFirstNonPalin) print("\n \n");
		}
	}

	public class IO {
		//Attributes
		private String inputFilePath;
		private String outputFilePath;

		//Constructor
		public IO() {
			InitProperties();
		}
		//Methods
		private InitProperties() {
			//If config exists lets use those settings

			//Else lets use default workingDirectory/
		}
		public Word[] LoadFile() {
			//Fetch file contents
	
		}
	}

	public class Word {		
		//Attributes
		public String letters;
		public Bool isPalindrome;

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
		}
	}

	static class CustomerSortingComparator implements Comparator<Word> { 
		
        @Override
        public int compare(Word word1, Word word2) { 
  
            // for comparison 
            int letterCompare = word1.letters.compareTo(word2.letters); 
            int isPalinCompare = word1.isPalindrome.compareTo(word2.letters); 
  
            // 2-level comparison using if-else block 
            if (letterCompare == 0) { 
                return ((isPalinCompare == 0) ? letterCompare : isPalinCompare); 
            } else { 
                return letterCompare; 
            } 
        } 
    } 

	public class Log {
		String logFilePath;

	}
}