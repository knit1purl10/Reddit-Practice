package oncebutton;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;

public class OnceButton {
	private String infile;
	private HashMap<Double,String> users;
	
	
	public OnceButton(String inputfile) {
		infile = inputfile;
		users = new HashMap<Double,String>();
	}
	
	public void readFile() {
		try {
			FileReader fr = new FileReader(infile);
			BufferedReader br = new BufferedReader(fr);
			
			int lineno = 0;
			String line = br.readLine();
			double[] times = null;
			
			while(line != null) {
				//System.out.println(line);
				if (lineno == 0) {
					times = new double[Integer.parseInt(line)];
					//System.exit(0);
				} else {
					times[lineno-1] = mapTimes(line);
				}
				lineno++;
				line = br.readLine();
			}
			br.close();
			
			Arrays.sort(times);
			printOutput(times);
		} catch (FileNotFoundException e) {
			System.out.println("Error. File not found. Please try again.");
			System.exit(1);
		} catch (IOException e) {
			System.out.println("Unable to read file.");
			System.exit(1);
		}
	}

	public double mapTimes(String line) {
		String[] pieces = line.split(" ");
		String username = pieces[0];
		
		Double timein = Double.parseDouble(pieces[1]);				
		users.put(timein, username);
		
		return timein;
	}
	
	public void printOutput(double[] times) {
		double timeleftover = 0;
		for (double i : times) {
			String username = users.get(i);
			int timeout = (int) (Math.floor( 60-i + timeleftover));
			timeleftover = i;
			System.out.println(username + " " + timeout);
		}
	}
	
	public static void main(String[] args) {
		if (args.length == 1) {
			OnceButton test = new OnceButton(args[0]);
			test.readFile();
			System.exit(0);
		} else {
			System.out.println("Error. File path not specified.");
			System.exit(1);
		}
	}
	
}
