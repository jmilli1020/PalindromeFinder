public class PalindromeFinder {

	public static void main(string[] args)	{
		//Setup		
		IO io = new IO();
		Log log = new Log();
		
		//Get the words from the file and then check if they're palindromes
		Word[] words = io.LoadFile();
		//Lets sort the array now 
		io.Sort(words)
		//Print if palindromes == true then print the non palindromes after
		for(Word word: words) {
			if(word.isPalindrome) {
				print(word.letters);
			}
		}
		for(Word word: nonPalin) {
			print(word);
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
			New List<Word> words; 
			//Lets just focus on the letters
			for(Word word: words) {
				StripNonLetters(word.letters);
			}
	
		}
		private String StripNonLetters(String input) {
			//COnvert to String are so that 
		}

		public Word[] Sort(Word[] words) {

		}
	}

	public class Word {		
		//Attributes
		public String letters;
		public bool isPalindrome;

		//Constructor
		public Word(String letters) {
			this.letters = letters;
		}
		//Methods
		public void CheckIfPalindrome(Word word) {

		}
	}

	public class Log {
		String logFilePath;

	}
}