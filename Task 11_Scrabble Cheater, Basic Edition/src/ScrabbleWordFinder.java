import java.math.BigInteger;
import java.util.Set;

public class ScrabbleWordFinder {
	
	
	public static void main(String[] args) throws Exception {
		
		//Filling dictionary
		MyHashTable<String> dictionary = new MyHashTable<String>();
		System.out.println("TableSize: " + dictionary.M);
		String filePath = "f:/Alles Mögliche/Uni/Computerscience2_tasks/Task 11_Scrabble Cheater, Basic Edition/src/dictionary.txt";
		
	
		
		for(String word : UM.FileToString(filePath).split("\\s+")) {
			dictionary.add(word);
		}
		//Seach for words with letters (sequence irrelevant)
		String bench = "test";
		
		for(String permute : dictionary.lookup(bench)) {
			System.out.println(permute);
		}
		dictionary.printListsSize();
		System.out.println("Amount of empty lists: " +dictionary.getEmptyLists() + "%");
		System.out.println("On Average the lists are filled to " +dictionary.getAverageFilled() + "%");
	}
}
