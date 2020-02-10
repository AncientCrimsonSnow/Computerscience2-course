
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;

public class Histofgram {
	
	static String Historows;
	static String ZuZählendeWörter;
	static String Quelle;
	
	static String Addtext;
	static HashMap<Character, Integer> Histo = new HashMap<>();
	static int min = 32;
	static int max = 591+1;
	
	public static void main(String[] args) throws Exception {
		long start = System.currentTimeMillis();
		System.out.println(start);
		Historows = "f:/Alles Mögliche/Uni/Informatik 2/Übung2/frequency.txt";
		ZuZählendeWörter = "f:/Alles Mögliche/Uni/Informatik 2/Übung2/Gedicht.txt";
		Quelle = "f:/Alles Mögliche/Uni/Informatik 2/Übung2/Source.txt";		
		
		FillMap();
				
		CreateFile(ZuZählendeWörter);
		
		Addtext = new String(reader(Quelle));
		writer(ZuZählendeWörter,Addtext, 1);
		
		
		reduce(Arraynorm(reader(ZuZählendeWörter)));
		
		printHistoHori();
		//printHistoVerti();
		
		long end = System.currentTimeMillis();
		double stop = ( end-start)/60000;
		System.out.println(stop);
	}
	public static char[] reader (String file_name) throws Exception {
						
		FileReader fr = new FileReader(file_name);
		BufferedReader br = new BufferedReader(fr);
		
		System.out.println("Copied from the file to the console:");
		System.out.println("File = " + file_name);		
		
		ArrayList<Character> File = new ArrayList<Character>();		
		String line;
		char[] lineChar;
		
		while(br.ready()) {
			line = br.readLine();
			lineChar = line.toCharArray();
			
			for(int i = 0; i< lineChar.length;i++) {
				File.add(lineChar[i]);	
			}						
		}		
		char[] Array = new char[File.size()];
			
			for(int i = 0; i < Array.length; i++) {
				Array[i] = File.get(i);
			}
		return Array;
	}
	
	/*first param: Name of File u want 2 write in
	*sec param: Text u want 2 write in the file
	*third param:
	*x = 1 Overwriting everything, 
	*x = 2 Add Text simple behind last Char,
	*x = 3 Add Text at the bottom in a new Line,
	*x = 4 Add Text at the bottom behind the last char
	*/
	public static void writer (String file_name, String Text, int x) throws IOException {
		
		switch(x) {
		case 1:
			FileWriter fw = new FileWriter(file_name);
			fw.write(Text);
			fw.close();
			
			break;
		case 2:
			FileWriter fw1 = new FileWriter(file_name, true);
			fw1.write(Text);
			fw1.close();
			
			break;
		case 3:
			FileWriter fw2 = new FileWriter(file_name, true);
			BufferedWriter bw = new BufferedWriter(fw2);
			PrintWriter pw = new PrintWriter(bw);
			
			pw.println(Text);
			pw.close();
			
			break;
		case 4:	
			FileWriter fw3 = new FileWriter(file_name, true);
			BufferedWriter bw1 = new BufferedWriter(fw3);
			PrintWriter pw1 = new PrintWriter(bw1);
			
			pw1.print(Text);
			pw1.close();
			
			break;
		}			
	}
	
	public static void reduce(char[] BigCharArray) {
		
		for(int i = 0; i<BigCharArray.length ; i++) {
			if(Histo.get(BigCharArray[i]) != null) {
				int value = Histo.get(BigCharArray[i]);
				Histo.put((BigCharArray[i]), value+1);	
			}					
		}	
		Histo.values().removeAll(Collections.singleton(0));
	}

	public static char[] Arraynorm(char[] ListNotNorm) {
		
		char[] notnorm = new char[ListNotNorm.length];
		
		for(int i = 0; i < notnorm.length; i++) {
			notnorm[i] = Character.toUpperCase(ListNotNorm[i]);
		}		
		return notnorm;		
	}

	public static void FillMap() {
		for (int i = min; i<max;i++) {
			Histo.put((char) i, 0);
		}
	}

	public static void CreateFile(String file_name) throws IOException {
		File file = new File(file_name);
		
		file.createNewFile();
	}

	public static void printHistoHori() throws IOException {
		String line;
		
		writer(Historows,"",1);
		
		for (Entry<Character, Integer> entry : Histo.entrySet()) {
		    int power = entry.getValue();
		    line = String.valueOf(entry.getKey());
		    
		    for(int j = 0; j < power;j++) {
				line = line + "*";
			}
		    writer(Historows,line,3);
		}
	}
	
	public static void printHistoVerti() throws IOException {
		
		int maxLetter = 0;
		
		for (Entry<Character, Integer> entry : Histo.entrySet()) {
			if(maxLetter<entry.getValue()) {
				maxLetter= entry.getValue();
			}
		    
		}
		// Histo.size == Columns; maxLetter == Rows
		char [][] Histogramm = new char[Histo.size()][maxLetter+1];
		
		int index = 0;
		
		
		for (Entry<Character, Integer> entry : Histo.entrySet()) {
		    Histogramm[index][0] = entry.getKey();
		    index++;
		}
		
		index=0;

		for(int i = 1; i <= maxLetter;i++) {
			
			for (Entry<Character, Integer> entry : Histo.entrySet()) {
			    
				if(i <= entry.getValue()) {
					Histogramm[index][i] = '*';
				}
				else {
					Histogramm[index][i] = ' ';
				}
				index++;
			}
			index = 0;
		}
		writer(Historows,"",1);
		String Text = "";
		for(int i = maxLetter; i >= 0;i--) {
			
			
			Text = Text + "\r\n";
			for (Entry<Character, Integer> entry : Histo.entrySet()) {
				Text = Text + String.valueOf(Histogramm[index][i]) + " ";				
				index++;
			}
			index=0;
		}
		writer(Historows,Text,3);
	}
}