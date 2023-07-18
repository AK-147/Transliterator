// header files
import java.io.*;

public class All_In_One {

	// global object to read user input at command line
	public static BufferedReader bf;
	
	// driver method
	public static void main(String[] args) throws IOException {
		
		// boolean variable for main loop
		Boolean running = true;
		
		//
		bf = new BufferedReader(new InputStreamReader(System.in));
		
		// main loop
		while (running) {
			
			// print menu to screen
			displayMenu();
			
			// get the entered choice
			String ans = bf.readLine();
			
			// user chooses to show list of alphabet conversions
			if (ans.equals("S") || ans.equals("s")) { displayAlphaList(); }
			
			
			// user chooses to show list of alphabet conversions
			else if (ans.equals("W") || ans.equals("w")) { displayNumList(); }
			
			
			// user chooses to convert English text into Arabic
			else if (ans.equals("A") || ans.equals("a")) { transliterate(); }
			
			
			// user terminates the program
			else if (ans.equals("Q") || ans.equals("q")) { running = false; }
			
			
			// user enters invalid choice
			else { System.out.println("\nERROR: Invalid menu choice!\n"); }
			
		} // end of main loop

		// close buffered reader and end program
		bf.close(); convertTo("\nالسلام عليكم\n");
		
	} // end of main function
	
	
	// display the menu
	public static void displayMenu() {
		
		System.out.println("   JAVA TRANSLITERATION PROGRAM (ARABIC)");
		System.out.println("S - Show list of alphabetical transliterations");
		System.out.println("W - Show list of numerical transliterations");
		System.out.println("A - Convert English text into Arabic");
		System.out.println("Q - Quit\n");
		System.out.print("Enter choice: ");
		
	} // end of function
	
	
	// display list of alphabetical transliterations
	public static void displayAlphaList() throws UnsupportedEncodingException, IOException {
		
		// print column header
		System.out.println("\n----------------------------");
		System.out.println("Phonetics   English   Arabic");
		System.out.println("----------------------------");
		
		// print alphabets
		convertTo("    ā"); System.out.format("%11s%9s","a",""); convertTo("ا");
		
		System.out.format("%n%5s%11s%9s","b","b",""); convertTo("ب");
		
		System.out.format("%n%5s%11s%9s","t","t",""); convertTo("ت");
		
		System.out.format("%n%5s%11s%9s","th","th",""); convertTo("ث");
		
		System.out.format("%n%5s%11s%9s","j","j",""); convertTo("ج");
		
		convertTo("\n    ḥ"); System.out.format("%11s%9s","H",""); convertTo("ح");
		
		System.out.format("%n%5s%11s%9s","kh","kh",""); convertTo("خ");
		
		System.out.format("%n%5s%11s%9s","d","d",""); convertTo("د");
		
		System.out.format("%n%5s%11s%9s","dh","dh",""); convertTo("ذ");
		
		System.out.format("%n%5s%11s%9s","r","r",""); convertTo("ر");
		
		System.out.format("%n%5s%11s%9s","z","z",""); convertTo("ز");
		
		System.out.format("%n%5s%11s%9s","s","s",""); convertTo("س");
		
		System.out.format("%n%5s%11s%9s","sh","sh",""); convertTo("ش");
		
		convertTo("\n    ṣ"); System.out.format("%11s%9s","S",""); convertTo("ص");
		
		convertTo("\n    ḍ"); System.out.format("%11s%9s","D",""); convertTo("ض");
		
		convertTo("\n    ṭ"); System.out.format("%11s%9s","T",""); convertTo("ط");
		
		convertTo("\n    ẓ"); System.out.format("%11s%9s","Z",""); convertTo("ظ");
		
		System.out.format("%n%5s%11s%9s","-","\"",""); convertTo("ع");
		
		System.out.format("%n%5s%11s%9s","gh","gh",""); convertTo("غ");
		
		System.out.format("%n%5s%11s%9s","f","f",""); convertTo("ف");
		
		System.out.format("%n%5s%11s%9s","q","q",""); convertTo("ق");
		
		System.out.format("%n%5s%11s%9s","k","k",""); convertTo("ك");
		
		System.out.format("%n%5s%11s%9s","l","l",""); convertTo("ل");
		
		System.out.format("%n%5s%11s%9s","m","m",""); convertTo("م");
		
		System.out.format("%n%5s%11s%9s","n","n",""); convertTo("ن");
		
		System.out.format("%n%5s%11s%9s","h","h",""); convertTo("ه");
		
		System.out.format("%n%5s%11s%9s","w","w",""); convertTo("و");
		
		System.out.format("%n%5s%11s%9s","y","y",""); convertTo("ي");
		
		System.out.format("%n%5s%11s%9s","-","'",""); convertTo("ء\n\n");
		
	} // end of function
	
	
	// display list of numerical transliterations
	public static void displayNumList() throws UnsupportedEncodingException, IOException {
			
		// print column header
		System.out.println("\n-----------------");
		System.out.println("Standard   Arabic");
		System.out.println("-----------------");
		
		// print numerals
		System.out.format("%5s%9s","0",""); convertTo("٠");
		
		System.out.format("%n%5s%9s","1",""); convertTo("١");
		
		System.out.format("%n%5s%9s","2",""); convertTo("٢");
		
		System.out.format("%n%5s%9s","3",""); convertTo("٣");
		
		System.out.format("%n%5s%9s","4",""); convertTo("٤");
		
		System.out.format("%n%5s%9s","5",""); convertTo("٥");
		
		System.out.format("%n%5s%9s","6",""); convertTo("٦");
		
		System.out.format("%n%5s%9s","7",""); convertTo("٧");
		
		System.out.format("%n%5s%9s","8",""); convertTo("٨");
		
		System.out.format("%n%5s%9s","9",""); convertTo("٩\n\n");
		
	} // end of function
	
	
	// transliterate English text into Arabic
	public static void transliterate() throws IOException {
		
		// boolean variable for loop
		Boolean running = true;
		
		while (running) {
			
			// prompt input string
			System.out.print("\n\nEnter English text to transliterate (0 to cancel): ");
			
			// store input and initialize output string
			String input = bf.readLine(); String output = "";
			
			// user cancels transliteration
			if (input.equals("0")) { break; }
			
			// form output via concatenation
			for (int i = 0; i < input.length(); i++) {
				
				// define variable characters for iteration
				char c = input.charAt(i); char p; char n; int length = input.length() - 1;
				
				// set previous and initial character in iteration
				if (i == 0) { p = c; }
				else { p = input.charAt(i - 1); }
				
				// set next and final character in iteration
				if (i == input.length() - 1) { n = c; }
				else { n = input.charAt(i + 1); }
				
				// concatenate alphabet to output
				if ((c == 'a' || c == 'i' || c == 'u') && (i == 0 || p == ' ')) { output += 'ا'; }
				
				else if ((c == 'a' && ( p != 'a' && p != 'w')) && (i == length || n == ' ')) { output += 'ا'; }
				
				else if ((c == 'a' && p == 'a') && (i != length && n != ' ')) { output += 'ا'; }
				
				else if (c == 'b') { output += 'ب'; }
				
				else if (c == 't' && n != 'h') { output += 'ت'; }
				
				else if (c == 't' && n == 'h') { output += 'ث'; i++; }
				
				else if (c == 'j' || (c == 'g' && n != 'h')) { output += 'ج'; }
				
				else if (c == 'H') { output += 'ح'; }
				
				else if (c == 'k' && n == 'h') { output += 'خ'; i++; }
				
				else if (c == 'd' && n != 'h') { output += 'د'; }
				
				else if (c == 'd' && n == 'h') { output += 'ذ'; i++; }
				
				else if (c == 'r') { output += 'ر'; }
				
				else if (c == 'z') { output += 'ز'; }
				
				else if (c == 's' && n != 'h') { output += 'س'; }
				
				else if ((c == 's' || c == 'c') && n == 'h') { output += 'ش'; i++; }
				
				else if (c == 'S') { output += 'ص'; }
				
				else if (c == 'D') { output += 'ض'; }
				
				else if (c == 'T') { output += 'ط'; }
				
				else if (c == 'Z') { output += 'ظ'; }
				
				else if (c == '"') { output += 'ع'; }
				
				else if (c == 'g' && n == 'h') { output += 'غ'; i++; }
				
				else if (c == 'f') { output += 'ف'; }
				
				else if (c == 'q') { output += 'ق'; }
				
				else if (c == 'k' && n != 'h') { output += 'ك'; }
				
				else if (c == 'l') { output += 'ل'; }
				
				else if (c == 'm') { output += 'م'; }
				
				else if (c == 'n') { output += 'ن'; }
				
				else if (c == 'h') { output += 'ه'; }
				
				else if (c == 'w' && n != 'h') { output += 'و'; }
				
				else if (c == 'w' && n == 'h') { output += 'و'; i++; }
				
				else if ((c == 'o' || c == 'u') && n == 'y') { output += 'و'; }
				
				else if (c == 'u' && (i == length || n == ' ')) { output += "وا"; }
				
				else if ((c == 'o' || c == 'u') && (p == 'o' || p == 'u')) { 
					
					if (i == length || n == ' ') { output += "وا"; }
					
					else { output += 'و'; }
				}
				
				else if (c == 'y') { output += 'ي'; }
				
				else if ((c == 'a' || c == 'e' || c == 'i') && (n == 'e' || n == 'i')) { output += 'ي'; i++; }
				
				else if (c == 'i' && (i == length || n == ' ')) { output += 'ي'; }
				
				else if (c == '\'' && n != 'a' && n != 'i' && n != 'u') { output += 'ء'; }
				
				else if (c == '\'' && (n == 'a' || n == 'u')) { output += 'أ'; }
				
				else if (c == '\'' && n == 'i') { output += 'إ'; }
				
				else if (c == 'h' && (i == length || n == ' ')) { output += 'ة'; }
				
				else if ((c == 'a' && p == 'a') && (i == length || n == ' ')) { output += 'ى'; }
				
				// concatenate numerals to output
				else if (c == '0') { output += '٠'; }
				
				else if (c == '1') { output += '١'; }
				
				else if (c == '2') { output += '٢'; }
				
				else if (c == '3') { output += '٣'; }
				
				else if (c == '4') { output += '٤'; }
				
				else if (c == '5') { output += '٥'; }
				
				else if (c == '6') { output += '٦'; }
				
				else if (c == '7') { output += '٧'; }
				
				else if (c == '8') { output += '٨'; }
				
				else if (c == '9') { output += '٩'; }
				
				else if (c == ' ') { output += ' '; }
				
			}
			
			System.out.println("\nArabic transliteration: " + output);
		}
		
		// user cancels process
		System.out.println("\nTransliteration canceled.\n");
		
	} // end of function
	
	
	// convert input into UTF-8 character encoding from default ASCII character set
	public static void convertTo(String input) throws UnsupportedEncodingException, IOException { System.out.write(input.getBytes("UTF-8")); }
	
} // end of class


