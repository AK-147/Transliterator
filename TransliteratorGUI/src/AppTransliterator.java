// header files
import java.io.*; import java.awt.*; import java.awt.event.*; import javax.swing.*; import java.util.*;


// class object responsible for transliteration logic
public class AppTransliterator {
	
	// define references to transliteration index
	static AppIndex index = AppIndex.values()[0]; static AppIndex[] arabic = AppIndex.values();
	
	
	// driver method
	public static void main(String[] args) throws IOException {
		
		// initialize application
		AppCore program = new AppCore();
		
		// define text submission action to map key
		final String SUBMIT_TEXT = "submit-text";
		
		// add binding to enter key submitting action
		program.engText.getInputMap().put(KeyStroke.getKeyStroke("ENTER"), SUBMIT_TEXT);
		
		// add new action upon detecting key stroke
		program.engText.getActionMap().put(SUBMIT_TEXT, new AbstractAction() {
			
			// define arraylist and index counter to keep track of lines
			ArrayList<String> lines = new ArrayList<String>(); int lineNum;
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				// user presses enter key
				try {
					
					// instantiate index counter as line number
					lineNum = program.engText.getLineCount() - 1;
					
					// add carriage return and add text to arraylist
					program.engText.append("\n"); lines.add(program.engText.getText().split("\n")[lineNum]);
					
					// transliterate appended text and add carriage return
					program.arText.append(transliterate(lines.get(lineNum)) + "\n");
				
				// handle exception
				} catch (IOException | ArrayIndexOutOfBoundsException ex) { ex.printStackTrace(); }
			}
		});
		
	} // end of main function
	
	
	// transliterate English text into Arabic
	public static String transliterate(String input) throws IOException {
		
		// initialize output string
		String output = "";

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
			
			else if (c == '\'' && p == n) { output += arabic[0]; }
			
			else if (c == '\'' && (i == 0 || p == ' ') && (n == 'a' || n == 'u')) { output += arabic[1]; }

			else if (c == '\'' && (i == 0 || p == ' ') && n == 'i') { output += arabic[2]; }

			else if (c == 'b') { output += arabic[3]; }

			else if (c == 't' && n != 'h') { output += arabic[4]; }

			else if (c == 't' && n == 'h') { output += arabic[5]; i++; }

			else if (c == 'j' || (c == 'g' && n != 'h')) { output += arabic[6]; }

			else if (c == 'H') { output += arabic[7]; }

			else if (c == 'k' && n == 'h') { output += arabic[8]; i++; }

			else if (c == 'd' && n != 'h') { output += arabic[9]; }

			else if (c == 'd' && n == 'h') { output += arabic[10]; i++; }

			else if (c == 'r') { output += arabic[11]; }

			else if (c == 'z') { output += arabic[12]; }

			else if (c == 's' && n != 'h') { output += arabic[13]; }

			else if ((c == 's' || c == 'c') && n == 'h') { output += arabic[14]; i++; }

			else if (c == 'S') { output += arabic[15]; }

			else if (c == 'D') { output += arabic[16]; }

			else if (c == 'T') { output += arabic[17]; }

			else if (c == 'Z') { output += arabic[18]; }

			else if (c == '"') { output += arabic[19]; }

			else if (c == 'g' && n == 'h') { output += arabic[20]; i++; }

			else if (c == 'f') { output += arabic[21]; }

			else if (c == 'q') { output += arabic[22]; }

			else if (c == 'k' && n != 'h') { output += arabic[23]; }

			else if (c == 'l') { output += arabic[24]; }

			else if (c == 'm') { output += arabic[25]; }

			else if (c == 'n') { output += arabic[26]; }

			else if (c == 'h') { output += arabic[27]; }

			else if (c == 'h' && (i == length || n == ' ')) { output += arabic[28]; }
			
			else if (c == 'w' && n != 'h') { output += arabic[29]; }

			else if (c == 'w' && n == 'h') { output += arabic[29]; i++; }

			else if ((c == 'o' || c == 'u') && n == 'y') { output += arabic[29]; }

			else if (c == 'u' && (i == length || n == ' ')) { output += arabic[30]; }

			else if ((c == 'o' || c == 'u') && (p == 'o' || p == 'u')) {

				if (i == length || n == ' ') { output += arabic[30]; }

				else { output += arabic[29]; }
			}
			
			else if (c == 'u' && (i != 0 || p != ' ') && n == '\'') { output += arabic[31]; i++; }
			
			else if (c == 'y') { output += arabic[32]; }

			else if ((c == 'a' || c == 'e' || c == 'i') && (n == 'e' || n == 'i')) { output += arabic[32]; i++; }

			else if (c == 'i' && (i == length || n == ' ')) { output += arabic[32]; }
			
			else if (c == '\'' && (i != 0 || p != ' ') && n == 'i') { output += arabic[33]; }

			else if ((c == 'a' && p == 'a') && (i == length || n == ' ')) { output += arabic[34]; }
			
			else if (c == '\'' && n != 'a' && n != 'i' && n != 'u') { output += arabic[35]; }

			// concatenate numerals to output
			else if (c == '0') { output += index.arNums[0]; }

			else if (c == '1') { output += index.arNums[1]; }

			else if (c == '2') { output += index.arNums[2]; }

			else if (c == '3') { output += index.arNums[3]; }

			else if (c == '4') { output += index.arNums[4]; }

			else if (c == '5') { output += index.arNums[5]; }

			else if (c == '6') { output += index.arNums[6]; }

			else if (c == '7') { output += index.arNums[7]; }

			else if (c == '8') { output += index.arNums[8]; }

			else if (c == '9') { output += index.arNums[9]; }

			else if (c == ' ') { output += ' '; }
		}

		// return final result
		return output;
		
	} // end of function
	
} // end of class


