package ie.gmit.sw;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;

public class Parser {
	
	private static long benchmarkTime = 0;
	
	// O(n) because buffered reader runs through a file
	public static BufferedReader parseFile(String file){
		BufferedReader br = null;
		
		try { // if the string contains a http or www it is a URL otherwise its a normal file
			if(file.contains("http") || file.contains("www")){
				URL url = new URL(file);
				br = new BufferedReader(new InputStreamReader(url.openStream()));
			}
			else {
				br = new BufferedReader(new FileReader(file));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return br;
	}
	
	// O(n) linear because it reads the file line by line and encrypts each line and writes it to the output file
	public static void writeFile(String readFile, String outputFile, String key) {
		BufferedReader br = parseFile(readFile);
		String s = "";
		try {
			PrintWriter pw = new PrintWriter(outputFile);
			benchmarkTime = System.currentTimeMillis(); 
			while((s = br.readLine()) != null){
				// calling the encrypt method and passing the text and key
				String c = Encrypt.encrypt(s, key);
				// printing out to output file
				pw.println(c);
			}
			// time takes to encrypt
			System.out.println("Encryption time (in milliseconds): "+(System.currentTimeMillis() - benchmarkTime));
			br.close();
			pw.close();
		} catch (FileNotFoundException foe) {
			foe.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
