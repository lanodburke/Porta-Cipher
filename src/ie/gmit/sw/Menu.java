package ie.gmit.sw;

import java.util.Scanner;

public class Menu {
	
	public static Scanner console = new Scanner(System.in);
	
	public Menu(){
		initMenu();
	}
	
	// starts the menu
	public void initMenu(){
		int option;
		String key;
		String file;
		do{
			System.out.println("----- PortaCipher ------");
			System.out.println("1) Encrypt a File or URL\n2) Decrypt a file or URL\n");
			System.out.print("Enter option: ");
			option = console.nextInt();
			
			switch(option){
			case 1:
				System.out.print("1) Enter the key you wish to use to encrypt: ");
				key = console.next();
				System.out.print("2) Enter the name of the file or URL you want to encrypt: ");
				file = console.next();
				Parser.writeFile(file, "encrypt.txt", key);				
				break;
			case 2:
				System.out.print("1) Enter the key you wish to use to decrypt: ");
				key = console.next();
				System.out.print("2) Enter the name of the file or URL you want to decrypt: ");
				file = console.next();
				Parser.writeFile(file, "decrypt.txt", key);
				break;
			default:
				System.out.println("That is not a valid option!");
			}
		}while(option != 4);
	}
}

