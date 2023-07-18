// header files
import java.io.*;

// enumeration class to behave as a database
public enum Index {

	// Arabic alphabet
	ا, ب, ت, ث, ج, ح, خ, د, ذ, ر, ز, س, ش, ص, ض, ط, ظ, ع, غ, ف, ق, ك, ل, م, ن, ه, و, ي, ء, أ, إ, ة, ى, وا;
		
	// phonetic conversions
	public String[] phonetics = {"ā", "b", "t", "th", "j", "ḥ", "kh", "d", "dh",
								"r", "z", "s", "sh", "ṣ", "ḍ", "ṭ", "ẓ", "-", "gh",
								"f", "q", "k", "l", "m", "n", "h", "w", "y", "-"};
	
	// English alphabet equivalents
	public String[] english = {"a", "b", "t", "th", "j", "H", "kh", "d", "dh", "r",
								"z", "s", "sh", "S", "D", "T", "Z", "\"", "gh",
								"f", "q", "k", "l", "m", "n", "h", "w", "y", "'"};
	
	// Arabic numerals
	public char[] numerals = {'٠', '١', '٢', '٣', '٤', '٥', '٦', '٧', '٨', '٩'};
	
	
	// define farewell message
	public String peace = "\nالسلام عليكم\n";
	
	
	// display list of alphabetical transliterations
	public void displayAlphaList() throws IOException {
		
		// print column header
		System.out.println("\n----------------------------");
		System.out.println("Phonetics   English   Arabic");
		System.out.println("----------------------------");
		
		for (int i = 0; i < phonetics.length && i < english.length; i++) {
			
			if (!phonetics[i].equals(english[i]) && i != 0 && !phonetics[i].equals("-")) {
				
				System.out.format("%6s%11s%9s%n", phonetics[i], english[i], Index.values()[i]);
			}
			
			else { System.out.format("%5s%11s%9s%n", phonetics[i], english[i], Index.values()[i]); }
		}
		
		System.out.println("");
		
	} // end of function
	
	
	// display list of numerical transliterations
	public void displayNumList() throws IOException {
		
		// print column header
		System.out.println("\n-----------------");
		System.out.println("Standard   Arabic");
		System.out.println("-----------------");
		
		for (int i = 0; i < numerals.length; i++) {
			
			if (i != numerals.length - 1) { System.out.format("%5s%9s%n", i, numerals[i]); }
			
			else { System.out.format("%5s%9s%n%n", i, numerals[i]); }
		}
	
	} // end of function

} // end of enumeration class
