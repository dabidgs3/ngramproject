/**
 * BCE -Copyright 2014
 * ngramproject
 */
package ngramproject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * @author David Guzman
 *
 */
public class NGramClass {

	private String words[]; // Initial Text
	private HashMap<String, List<String>> nGramsMap; // NGram Map
	private int counter = 0; // Counter value
	private int n = 2; // Value for NGram default 2

	/**
	 * Constructor Text parsing and splitting
	 * 
	 * @param text
	 *            , input text
	 * @param n
	 *            , n-gram value [Default = 2]
	 */
	NGramClass(String text, int n) {

		if (text == null || text.length() == 0)
			throw new IllegalArgumentException("Not valid text inserted");

		text.toLowerCase().replaceAll("[.,;]", "");
		words = text.split(" ");
		nGramsMap = new HashMap<String, List<String>>();

		if (n > 2)
			this.n = n;
	}

	/**
	 * Method to generate Ngrams
	 * @return Map with ngrams - Defaul n = 2
	 */
	public Map<String, List<String>> generateNgrams() {
		
		for (int i = 0; i <= words.length - n; i++) {
			counter = 0;
			StringBuilder sb = new StringBuilder();
			int j = 0;
			while (j < n - 1) {
				sb.append(words[i + j].trim());
				j++;
				if (j < n - 1)
					sb.append(" ");
				//System.out.println(sb.toString());
			}
			String key = sb.toString();
			if (!nGramsMap.containsKey(key)) {
				ArrayList<String> list = new ArrayList<>();
				list.add(words[i + j]);
				nGramsMap.put(key, list);
				

			} else {

				List<String> list = nGramsMap.get(key);
				if(list.contains(words[i+j]))
					counter++;
				list.add(words[i + j]);
				
			}
			System.out.println("(( " + key + "," + words[i + j] + ")" + ","+counter +")");
		}

		return nGramsMap;

	}
	
	
}
