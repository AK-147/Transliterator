// header files
import java.io.*;

// enumeration class to behave as a database
public enum AppIndex {

	// Arabic alphabet
	ا, أ, إ, ب, ت, ث, ج, ح, خ, د, ذ, ر, ز, س, ش, ص, ض, ط, ظ, ع, غ, ف, ق, ك, ل, م, ن, ه, ة, و, وا, ؤ, ي, ئ, ى, ء;
	
	// phonetic conversions
	public String[] phonetics = {"ā, aa", "a, u", "i, e", "b", "t", "th, ṯ", "j, ǧ", "ḥ", "kh, ḵ", "d", "dh, ḏ", "r", "z",
								"s", "sh, š, ch", "ṣ", "ḍ", "ṭ", "ẓ", "-", "gh", "f", "q", "k", "l", "m", "n", "h",
								"t, h (ending)", "w", "ū, oo (ending)", "u-", "y, ī, ee, ai, ay", "-ī, -i", "ā, aa (ending)", "-"};
	
	// English alphabet equivalents
	public String[] english = {"a", "a, u", "i, e", "b", "t", "th", "j, g", "H", "kh", "d", "dh", "r", "z", "s",
								"sh, ch", "S", "D", "T", "Z", "\"", "gh", "f", "q", "k", "l", "m", "n", "h",
								"t, h (ending)", "w", "oo (ending)", "u'", "y, ee, ai, ay", "'i", "aa (ending)", "'"};
	
	// standard numerals
	public String[] stdNums = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
	
	// Arabic numerals
	public String[] arNums = {"٠", "١", "٢", "٣", "٤", "٥", "٦", "٧", "٨", "٩"};

} // end of enumeration class
