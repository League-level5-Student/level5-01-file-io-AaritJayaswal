package _02_File_Encrypt_Decrypt;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileEncryptor {
	/*
	 * Encryption is the process of encoding a message or information in such a way
	 * that only authorized parties can access it and those who are not authorized
	 * cannot.
	 *
	 * A simple shift cipher works by shifting the letters of a message down based
	 * on a key. If our key is 4 then:
	 * 
	 * a b c d e f g h i j k l m n o p q r s t u v w x y z
	 * 
	 * becomes:
	 *
	 * e f g h i j k l m n o p q r s t u v w x y z a b c d
	 * 
	 * "Hello World" changes to "Lipps Asvph"
	 *
	 * Create a program that takes a message and a key from the user. Use the key to
	 * shift each letter in the users input and save the final result to a file.
	 */

	public static void main(String[] args) {
		try {
	
			Scanner scan = new Scanner(System.in);
			System.out.println("Write a message to encrypt: ");
			String write = scan.nextLine();
			System.out.println("Enter a key to shift by: ");
			int key = scan.nextInt();
			
			String writeCrypt = "";
			for (int i = 0; i < write.length(); i++) {
				if (write.charAt(i) != ' ') {
					char shift = (char) (write.charAt(i) + key);
					writeCrypt = writeCrypt + shift;
				} else {
					writeCrypt = writeCrypt + " ";
				}
			}
			System.out.println(writeCrypt);
			
			FileWriter fw = new FileWriter("src/_02_File_Encrypt_Decrypt/FileEncryptor",true);
			fw.write(writeCrypt);
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
