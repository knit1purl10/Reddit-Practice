package palindrome;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PalindromeFinder {

	public static boolean isPalindrome(String s) {
		boolean detected = false;
		if (!s.isEmpty()) {
			//to lowercase
			s = s.toLowerCase();
			//removes all special characters
			s = s.replaceAll("\\s+|\\W","");
			//System.out.println("Original string: "+s);

			StringBuilder worker = new StringBuilder(s);
			worker.reverse();

			//System.out.println(worker);
			//System.out.println("StringBuilder reversal: "+worker.toString());
			//System.out.println(s.equalsIgnoreCase(worker.toString()));

			detected = (s.equalsIgnoreCase(worker.toString())) ? true : false;
		}
		return detected;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int line = 1;
		int maxLine = 0;
		String input;
		String palinput = "";

		try {
			maxLine = Integer.valueOf(br.readLine());
			input = br.readLine();
			while (input != null) {
				//System.out.println("Line: " + line);
				//System.out.println("Max Lines: " + maxLine);
				if (line == maxLine) {
					palinput += input;
					System.out.println("Before method: "+palinput);
					//determine if this is a palindrome or not
					String output = (isPalindrome(palinput) ? "Palindrome" : "Not a palindrome");
					System.out.println(output);
					//read in new input
					maxLine = Integer.valueOf(br.readLine());
					//clears out string
					palinput = "";
					//reset line counter
					line = 1;
				} else {
					palinput += input;
					line++;
				}
				input = br.readLine();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NumberFormatException e) {
			System.err.println("Sorry your first input should be the number of lines of the palindrome. Try again!");
		}

	}

}
