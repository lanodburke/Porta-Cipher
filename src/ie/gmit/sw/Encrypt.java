package ie.gmit.sw;

public class Encrypt {
	
	// O(n) linear because the for loops runs along the length of the plain text
	public static String encrypt(String plain, String key){
		StringBuilder sb = new StringBuilder();
		plain = plain.toUpperCase();
		key = key.toUpperCase();
		
		for(int i = 0; i < plain.length(); i++){
			// encrypting each character and appending them to a string builder
			sb.append(encryptChar(plain.charAt(i), key.charAt(i % key.length()))); 
		}
		return sb.toString();
	}
	
	// O(1) because of calculation - uses unicode to encrypt the characters
	public static char encryptChar(char c, char key) {
		int cNum = (int)(c - 65); // converting to unicode
		int keyNum = (int)(key - 65) / 2; // converting to unicode
		
		// if not in the range of A - Z return the character
		if(c < 65 || c > 91){
			return c;
		} else { 
			if(c - 77 > 0) { 
				c = (char)(65 + (cNum-keyNum) % 13);
			}
			else {			
				c = (char)((cNum+keyNum) % 13 + 78);
			}
		}
		return c;
	}
}
