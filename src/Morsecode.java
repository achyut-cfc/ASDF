import java.io.*;
import java.util.*;
	
public class Morsecode {
	
		public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			char[] English = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
					's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0' };

			String[] Morse = { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--",
					"-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..", "|" };
			System.out.println("Please enter MC if you want to translate Morse Code into English, or Eng if you want to translate from English into Morse Code");
			String a = br.readLine();
			if (a.equals("MC")) {
				morse(Morse,English);
			}
			

			else if (a.equals("Eng")) {
				eng(Morse,English);
			}

			else {
				System.out.println("Invalid Input");

			}
		}
		// function to convert morse to english//
public static void morse(String Morse[],char English[])throws IOException
{
	String build;
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Please enter a sentence in Morse Code. Separate each letter/digit with a single space and delimit multiple words with a | .");
		String b = br.readLine();
		
		
		StringTokenizer stok = new StringTokenizer(b, " |");
		while (stok.hasMoreTokens()) {
			build = stok.nextToken(" |");
			for (int m = 0; m < Morse.length; m++) {
				if (build.equals(Morse[m]))
					System.out.print(English[m] + " ");
			}
		}
		
	}
 	// Function to convert english to morse//
		public static void eng(String Morse[],char English[])throws IOException
		{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Please enter a sentence in English, and separate each word with a blank space.");
			String c = br.readLine();
			c = c.toLowerCase();

			for (int x = 0; x < c.length(); x++) {
				for (int y = 0; y < English.length; y++) {
					if (c.charAt(x) == English[y])

						System.out.print(Morse[y] + " ");

				}

			}

		}
		}
