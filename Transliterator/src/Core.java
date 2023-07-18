// header files
import java.io.*;

public class Core {

	// global object to read user input at command line
	public static BufferedReader bf;
	
	// define references to transliteration index
	static Index index = Index.values()[0]; static Index[] arabic = Index.values();
	
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
			
			// user chooses to show list of alphabetical conversions
			if (ans.equals("S") || ans.equals("s")) { index.displayAlphaList(); }
			
			
			// user chooses to show list of numerical conversions
			else if (ans.equals("W") || ans.equals("w")) { index.displayNumList(); }
			
			
			// user chooses to convert English text into Arabic
			else if (ans.equals("A") || ans.equals("a")) { transliterate(); }
			
			
			// user terminates the program
			else if (ans.equals("Q") || ans.equals("q")) { running = false; }
			
			
			// user enters invalid choice
			else { System.out.println("\nERROR: Invalid menu choice!\n"); }
			
		} // end of main loop

		// close buffered reader and end program
		bf.close(); System.out.println(index.peace);
		
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

	
	// transliterate English text into Arabic
	public static void transliterate() throws IOException {
		
		// boolean variable for loop
		Boolean running = true;
		
		// main loop
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
				if ((c == 'a' || c == 'i' || c == 'u') && (i == 0 || p == ' ')) { output += arabic[0]; }
				
				else if ((c == 'a' && ( p != 'a' && p != 'w')) && (i == length || n == ' ')) { output += arabic[0]; }
				
				else if ((c == 'a' && p == 'a') && (i != length && n != ' ')) { output += arabic[0]; }
				
				else if (c == 'b') { output += arabic[1]; }
				
				else if (c == 't' && n != 'h') { output += arabic[2]; }
				
				else if (c == 't' && n == 'h') { output += arabic[3]; i++; }
				
				else if (c == 'j' || (c == 'g' && n != 'h')) { output += arabic[4]; }
				
				else if (c == 'H') { output += arabic[5]; }
				
				else if (c == 'k' && n == 'h') { output += arabic[6]; i++; }
				
				else if (c == 'd' && n != 'h') { output += arabic[7]; }
				
				else if (c == 'd' && n == 'h') { output += arabic[8]; i++; }
				
				else if (c == 'r') { output += arabic[9]; }
				
				else if (c == 'z') { output += arabic[10]; }
				
				else if (c == 's' && n != 'h') { output += arabic[11]; }
				
				else if ((c == 's' || c == 'c') && n == 'h') { output += arabic[12]; i++; }
				
				else if (c == 'S') { output += arabic[13]; }
				
				else if (c == 'D') { output += arabic[14]; }
				
				else if (c == 'T') { output += arabic[15]; }
				
				else if (c == 'Z') { output += arabic[16]; }
				
				else if (c == '"') { output += arabic[17]; }
				
				else if (c == 'g' && n == 'h') { output += arabic[18]; i++; }
				
				else if (c == 'f') { output += arabic[19]; }
				
				else if (c == 'q') { output += arabic[20]; }
				
				else if (c == 'k' && n != 'h') { output += arabic[21]; }
				
				else if (c == 'l') { output += arabic[22]; }
				
				else if (c == 'm') { output += arabic[23]; }
				
				else if (c == 'n') { output += arabic[24]; }
				
				else if (c == 'h') { output += arabic[25]; }
				
				else if (c == 'w' && n != 'h') { output += arabic[26]; }
				
				else if (c == 'w' && n == 'h') { output += arabic[26]; i++; }
				
				else if ((c == 'o' || c == 'u') && n == 'y') { output += arabic[26]; }
				
				else if (c == 'u' && (i == length || n == ' ')) { output += arabic[33]; }
				
				else if ((c == 'o' || c == 'u') && (p == 'o' || p == 'u')) {
					
					if (i == length || n == ' ') { output += arabic[33]; }
					
					else { output += arabic[26]; }
				}
				
				else if (c == 'y') { output += arabic[27]; }
				
				else if ((c == 'a' || c == 'e' || c == 'i') && (n == 'e' || n == 'i')) { output += arabic[27]; i++; }
				
				else if (c == 'i' && (i == length || n == ' ')) { output += arabic[27]; }
				
				else if (c == '\'' && n != 'a' && n != 'i' && n != 'u') { output += arabic[28]; }
				
				else if (c == '\'' && (n == 'a' || n == 'u')) { output += arabic[29]; }
				
				else if (c == '\'' && n == 'i') { output += arabic[30]; }
				
				else if (c == 'h' && (i == length || n == ' ')) { output += arabic[31]; }
				
				else if ((c == 'a' && p == 'a') && (i == length || n == ' ')) { output += arabic[32]; }
				
				// concatenate numerals to output
				else if (c == '0') { output += index.numerals[0]; }
				
				else if (c == '1') { output += index.numerals[1]; }
				
				else if (c == '2') { output += index.numerals[2]; }
				
				else if (c == '3') { output += index.numerals[3]; }
				
				else if (c == '4') { output += index.numerals[4]; }
				
				else if (c == '5') { output += index.numerals[5]; }
				
				else if (c == '6') { output += index.numerals[6]; }
				
				else if (c == '7') { output += index.numerals[7]; }
				
				else if (c == '8') { output += index.numerals[8]; }
				
				else if (c == '9') { output += index.numerals[9]; }
				
				else if (c == ' ') { output += ' '; }
				
			}
			
			System.out.println("\nArabic transliteration: " + output);
			
		} // end of main loop
		
		// user cancels process
		System.out.println("\nTransliteration canceled.\n");
		
	} // end of function
	
	
	// convert input into UTF-8 character encoding from default ASCII character set
	public static void convertTo(String input) throws UnsupportedEncodingException, IOException { System.out.write(input.getBytes("UTF-8")); }
	
} // end of class


