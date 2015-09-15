package cullingnumbers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class CullingNumbers {
	
	public static void filterInput(String[] input) {
		StringBuilder sb = new StringBuilder();
		HashSet<String> reduced = new HashSet<String>();
		
		for (String s : input) {
			try{
				//int check = Integer.parseInt(s);
				if (!reduced.contains(s)) {
					reduced.add(s);
					sb.append(s + " ");
				}
			} catch (NumberFormatException e) {
				System.out.println("Error. Was not an integer. Skipping to next input.");
			}
			
		}
		
		System.out.println(sb.toString().trim());
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			String[] adjustedinput = null;
			String input = br.readLine();
			while (input != null) {
				if (input.equals("q")) {
					break;
				} else {
					adjustedinput = input.split(" ");
					filterInput(adjustedinput);
				}
				input = br.readLine();

			}
			br.close();
			System.out.println("Thank you. Program exited.");
			System.exit(0);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Unable to read the sequence. Please try again.");
		}

	}

}
