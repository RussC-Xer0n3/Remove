package remove;
/**
* A Parser to parse through a java file 
* and write out all the alpha characters
* into a separate output file.
* String BUilder solution from Nureinik - https://stackoverflow.com/questions/21795550/replacing-a-character-in-a-scanner-string
* @Author Russell A E Clarke
* @Created 24.10.2020
* @Listening Linkin Park - Hybrid Theory
*/

import java.util.Scanner;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;

public class remove_8 {

	private static File file;
	private static File outFile;

	//Getters
    public static File getFile() {
		return remove_8.file;
	}

	public static File getOutFile() {
		return remove_8.outFile;
	}

	//Setters
	public static void setFile(File iFile) {
		remove_8.file = iFile;
	}

	public static void setOutFile(File oFile) {
		remove_8.outFile = oFile;
	}

	public static void parse() throws NullPointerException, FileNotFoundException, IndexOutOfBoundsException, IOException {
		// read in file
		Scanner fileScan = new Scanner(remove_8.file);

		// write to file
		PrintWriter fileOut = new PrintWriter(new BufferedWriter(new FileWriter(remove_8.outFile)));

		while (fileScan.hasNext()) {
			//CReate an ArrayList and store the line of Text
			StringBuilder builder = new StringBuilder();

			//Scan the next line of information
			String code = fileScan.nextLine();

			//Parse through the list and remove certain characters
			for (char c : code.toCharArray()) {
				// If it's a letter, you need another copy (total of 2)
			    if (Character.isLetter(c)) {
			        builder.append(c);
			    }
			}

			//Print the information left over to file
			fileOut.println(builder);
		}

		fileOut.close();
        fileScan.close();
	}

	public static void main(String[] args) throws FileNotFoundException, IndexOutOfBoundsException, IOException {

		parse(); //Call the method
    }
}