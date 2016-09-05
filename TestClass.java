/**
 * BCE -Copyright 2014
 * ngramproject
 */
package ngramproject;


/**
 * @author David Guzman
 *
 */
public class TestClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
		NGramClass n = new NGramClass("As we wound on our endless way, as we that the our endless. we wound wound we", 2);
		n.generateNgrams();
		}catch(Exception e)
		{
			System.out.print(e.getMessage());
		}
	}

}
