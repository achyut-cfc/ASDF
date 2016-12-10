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
			String b, build;
			int z = 0, i = 0;

			if (a.equals("MC")) {
				System.out.println("Please enter a sentence in Morse Code. Separate each letter/digit with a single space and delimit multiple words with a | .");
				b = br.readLine();
				// b = b +" ";
				/*while (z < b.length() - 1) {
					System.out.println("After while: " + z);
					build = "";
					if (b.charAt(z) == ' ') {
						System.out.println("In if: " + z);
						build = build + b.substring(i, z);
						i = z + 1;
						System.out.println("After i: " + z);
						for (int m = 0; m < Morse.length; m++) {
							if (build.equals(Morse[m]))

								System.out.print(English[m] + " ");

						}

					} else
						z++;

				}*/
				
				StringTokenizer stok = new StringTokenizer(b, " |");
				while (stok.hasMoreTokens()) {
					build = stok.nextToken(" |");
					for (int m = 0; m < Morse.length; m++) {
						if (build.equals(Morse[m]))
							System.out.print(English[m] + " ");
					}
				}
			}

			else if (a.equals("Eng")) {
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

			else {
				System.out.println("Invalid Input");

			}

		
	}
}

