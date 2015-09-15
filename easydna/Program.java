package easydna;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Program {
	public HashMap<String,String> pairs;
	public String otherhalf;
	public HashMap<String,String> proteins;
	
	public Program() {
		pairs = new HashMap<>();
		otherhalf = null;
		proteins = new HashMap<>();
	}
	
	public void initializePairs() {
		pairs.put("A", "T");
		pairs.put("T","A");
		pairs.put("G","C");
		pairs.put("C","G");
	}
	
	public void initializeProteins() {
		proteins.put("GCT","ALA");
		proteins.put("GCC","ALA");
		proteins.put("GCA","ALA");
		proteins.put("GCG","ALA");
		proteins.put("CGT","ARG");
		proteins.put("CGC","ARG");
		proteins.put("CGA","ARG");
		proteins.put("CGG","ARG");
		proteins.put("AGA","ARG");
		proteins.put("AGG","ARG");
		proteins.put("AAT","ASN");
		proteins.put("AAC","ASN");
		proteins.put("GAT","ASP");
		proteins.put("GAC","ASP");
		proteins.put("TGT","CYS");
		proteins.put("TGC","CYS");
		proteins.put("CAA","GLN");
		proteins.put("CAG","GLN");
		proteins.put("GAA","GLU");
		proteins.put("GAG","GLU");
		proteins.put("GGT","GLY");
		proteins.put("GGC","GLY");
		proteins.put("GGA","GLY");
		proteins.put("GGG","GLY");
		proteins.put("CAT","HIS");
		proteins.put("CAC","HIS");
		proteins.put("ATT","ILE");
		proteins.put("ATC","ILE");
		proteins.put("ATA","ILE");
		proteins.put("ATG","MET");
		proteins.put("TTA","LEU");
		proteins.put("TTG","LEU");
		proteins.put("CTT","LEU");
		proteins.put("CTC","LEU");
		proteins.put("CTA","LEU");
		proteins.put("CTG","LEU");
		proteins.put("AAA","LYS");
		proteins.put("AAG","LYS");
		proteins.put("TTT","PHE");
		proteins.put("TTC","PHE");
		proteins.put("CCT","PRO");
		proteins.put("CCC","PRO");
		proteins.put("CCA","PRO");
		proteins.put("CCG","PRO");
		proteins.put("TCT","SER");
		proteins.put("TCC","SER");
		proteins.put("TCA","SER");
		proteins.put("TCG","SER");
		proteins.put("AGT","SER");
		proteins.put("AGC","SER");
		proteins.put("ACT","THR");
		proteins.put("ACC","THR");
		proteins.put("ACA","THR");
		proteins.put("ACG","THR");
		proteins.put("TGG","TRP");
		proteins.put("TAT","TYR");
		proteins.put("TAC","TYR");
		proteins.put("GTT","VAL");
		proteins.put("GTC","VAL");
		proteins.put("GTA","VAL");
		proteins.put("GTG","VAL");
		proteins.put("TAA","STOP");
		proteins.put("TGA","STOP");
		proteins.put("TAG","STOP");
	}
	
	public String parsePairs(String[] input) {
		StringBuilder result = new StringBuilder();
		
		for(String s: input) {
			if (pairs.get(s) != null){
				result.append(pairs.get(s)+ " ");
			} else {
				return "Error. Symbol in sequence not recognized.";
			}
		}
		
		return result.toString();	
	}

	public String parseProteins(String input) {
		StringBuilder sb = new StringBuilder();
		if (input.length() % 3 != 0) {
			return "Sequence is not of the correct length. Try another sequence.";
		} else {
			int i = 0;
			while ((i+3) <= input.length()) {
				sb.append(proteins.get(input.substring(i,i+3))+" ");
				i += 3;
			}
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Program p = new Program();
		p.initializePairs();
		p.initializeProteins();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			String sequence = br.readLine();
			String[] boom = null;
			while (sequence != null) {
				//System.out.println(sequence);
				sequence = sequence.toUpperCase();
				boom = sequence.split(" ");
				System.out.println(p.parsePairs(boom));
				System.out.println(p.parseProteins(sequence.replaceAll("\\s","")));
				sequence = br.readLine();
				if (sequence.equals("exit")) {
					break;
				}
			}
			br.close();
			System.out.println("Thank you. Sequences processed.");
			System.exit(0);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Unable to read the sequence. Please try again.");
		}

	}

}
