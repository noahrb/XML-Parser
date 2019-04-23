package parser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class main {
	static File input = new File("C:\\Users\\nbeverly\\Desktop\\input.txt");

	public static void main(String[] args) throws IOException {
		ArrayList<String> list = new ArrayList<>(readEachLine(input, "<target_mapping"));

		for (int i = 0; i < list.size(); i++) {
			System.out.println(getName(list.get(i)));
		}
		
	}

	/**
	 * Method to read and return each line of file as an ArrayList<String> type
	 * 
	 * @param file Input to be read
	 * @return An arraylist of type string to hold each line of file.
	 * @throws IOException
	 */
	private static ArrayList<String> readEachLine(File file) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(file));
		ArrayList<String> list = new ArrayList<String>();
		String st;
		while ((st = br.readLine()) != null)
			list.add(st);
		// System.out.println(st);

		br.close();

		return list;
	}

	/**
	 * Method to read and return each line of file as an ArrayList<String> type.
	 * Modification of readEachLine to add the option to specify an additional
	 * string parameter that must be contained for line to be read.
	 * 
	 * @param file Input to be read
	 * @return An ArrayList of type string to hold each line of file.
	 * @throws IOException
	 */
	private static ArrayList<String> readEachLine(File file, String condition) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(file));
		ArrayList<String> list = new ArrayList<String>();
		String st;
		while ((st = br.readLine()) != null)
			if (st.toLowerCase().contains(condition))
				list.add(st);
		// System.out.println(st);

		br.close();

		return list;
	}

	/**
	 * Helper Method to Grab name attribute values from xml
	 * 
	 * @param str Input string (one line of xml)
	 * @return the value returned for name="<returned String>"
	 */
	private static String getName(String str) {
		str = str.substring(str.indexOf("name=\"") + 6);
		str = str.substring(0, str.indexOf("\""));
		return str;
	}

	/**
	 * Helper Method to Grab datatype attribute values from xml
	 * 
	 * @param str Input string (one line of xml)
	 * @return the value returned for datetype="<returned String>"
	 */
	private static String getType(String str) {
		str = str.substring(str.indexOf("datatype=\"") + 6);
		str = str.substring(0, str.indexOf("\""));
		return str;
	}
}
