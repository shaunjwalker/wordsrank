import java.util.Scanner;
import java.util.Arrays;
import java.io.*;

public class WordsRank {
	public static ProbeHashMap<String, String> hashDict = new ProbeHashMap<>(1866200);
	public static int best;		// number of dictionary words in best segmentation found
	public static int omittedChars;	// number of characters left out of dictionary words in best segmentation found
	public static String bestSeg = null;	// best segmentation found

	// support method that stores all words from wordsLarge.txt in dic
	private static void storeDict() {
		try {
			int wc = 0;
			Scanner filescan = new Scanner(new File("wordsLarge.txt"));
			while (filescan.hasNext()) {
				String word = filescan.nextLine().toLowerCase();
				// dict[wc] = word;
				hashDict.put(word, word);
				wc++;
			}
			System.out.println(wc + " words stored");
		} catch (IOException e) {System.out.println(e);}
	}
	
	// support method that returns true if word appears in dic
	private static boolean checkDict(String word) {
		return (hashDict.get(word) != null) ;
	}	
	
	// to use, initialize best to the length of the input
	public static void rank(int count, String segment, int omitted) {
		if (omitted<omittedChars || (omitted==omittedChars && count<best)) {
			best = count;
			bestSeg = segment;
			omittedChars = omitted;
			// System.out.println("New best: " + segment);
		}
	}
		
	public static void split(String head, String in) {	
		// head + " " + in is a segmentation 
		String segment = head + " " + in;
		// System.out.println(segment);

		// count number of dictionary words within the segmentation
		String[] tokens = segment.split(" ");
		int count = 0;
		int omitted = 0;

		for (int i=0; i<tokens.length; i++) {
			if (tokens[i].length()>1) {
				if (checkDict(tokens[i])) count++;
				else omitted+=tokens[i].length();
			} else omitted++;
		}
		// System.out.println(count + " " + omitted);

		// update best and bestSeg if new best segmentation has been found
		rank(count, segment, omitted);
		
		// recursive calls
		for (int i=1; i<in.length(); i++) {
			split(head+" "+in.substring(0,i), in.substring(i,in.length()));
		}	
	}

	public static void main (String[] args) {
		// get input string from user
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter a string: ");
		String input = scan.next().toLowerCase();
		scan.close();
		
		// test inputs
		/*String[] inputs = {"INOUTSIDE", "AREWETHEREYET", "CHARACTERLENGTH", "OCEANOFJELLYFISH", "ILIKETOSINGANDDANCE",
							"SUNFLOWERSINTHEGARDEN", "WEAREGOINGTONEEDABIGGERBOAT",
							"SHEDANCEDGRACEFULLYUNDERTHEMOON"};
		*/
		
		System.out.println();
		
		// preload all dictionary words into array
		storeDict();


		// recursively generate all segmentations of input
		for (int j=0; j<3; j++) {

			omittedChars = input.length();
			best = 0;

			long start = System.nanoTime();
			split("", input.toLowerCase());
			long end = System.nanoTime();

			// print out best segmentation found including number of dictionary
			// words within that segmentation
			System.out.println("Run " + (j+1) + " for segment \"" + input + "\"");
			System.out.println("Best Segmentation: " + bestSeg + " with " + best + " words");
			System.out.println("Time to Segment: " + (end - start));
			System.out.println();
		}
	}
}