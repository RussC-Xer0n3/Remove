package remove;
/**
* A Parser to parse through a java file 
* and write out all the alpha characters
* into a separate output file.
* @Author Russell A E Clarke
* @Created 24.10.2020
* @Listening Linkin Park - Hybrid Theory
*/

import java.util.Scanner;
import java.util.ArrayList;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class remove_6 {

    public static void main(String[] args) throws IndexOutOfBoundsException, IOException{

        File myFile = new File("/media/russell/_HBK^/eclipse-workspace/Remcovert/"
        		+ "About"
        		+ ".java");

        // read in file
		Scanner fileScan = new Scanner(myFile);

		// write to file
		PrintWriter fileOut = new PrintWriter(new BufferedWriter(new FileWriter("outFile.txt")));

		while (fileScan.hasNext()) {
			//CReate an ArrayList and store the line of Text
			ArrayList<String> myArrayList = new ArrayList<String>();
			
			//Scan the next line of information
			String code = fileScan.nextLine();
			
			//Add the information to the ArrayList
			myArrayList.add(code);
			
			//Parse through the list and remove certain characters
			for (int i = 0; i <= myArrayList.size(); i++) {
				myArrayList.remove("*");
				myArrayList.remove("/");
				myArrayList.remove(".");
				myArrayList.remove("{");
				myArrayList.remove("}");
				myArrayList.remove("<");
				myArrayList.remove(">");
				myArrayList.remove("[");
				myArrayList.remove("]");
				myArrayList.remove("(");
				myArrayList.remove(")");
				myArrayList.remove("=");
				myArrayList.remove(",");
				
				//Print the information left over to file
				fileOut.println(myArrayList);
			}
			
			/** Some delimiters mostly used in url data processing pg.243 lewis and loftus
			fileScan.useDelimiter("¬");
			fileScan.useDelimiter("`");
			fileScan.useDelimiter(" ");
			fileScan.useDelimiter("=");
			//fileScan.useDelimiter("+");
			fileScan.useDelimiter("_");
			fileScan.useDelimiter("-");
			//fileScan.useDelimiter("(");
			//fileScan.useDelimiter(")");
			//fileScan.useDelimiter("*");
			fileScan.useDelimiter("&");
			fileScan.useDelimiter("^");
			fileScan.useDelimiter("%");
			fileScan.useDelimiter("$");
			fileScan.useDelimiter("£");
			fileScan.useDelimiter("\"");
			fileScan.useDelimiter("!");
			fileScan.useDelimiter("\'");
			fileScan.useDelimiter("~");
			fileScan.useDelimiter("#");
			fileScan.useDelimiter("@");
			fileScan.useDelimiter(";");
			fileScan.useDelimiter(":");
			fileScan.useDelimiter("|");
			//fileScan.useDelimiter("\\");
			fileScan.useDelimiter("/");
			fileScan.useDelimiter(",");
			fileScan.useDelimiter(".");
			fileScan.useDelimiter("]");
			//fileScan.useDelimiter("[");
			fileScan.useDelimiter(">");
			fileScan.useDelimiter("<");
			fileScan.useDelimiter("}");
			//fileScan.useDelimiter("{");
			*/
		}
		
        System.out.println("done");

        fileOut.close();
        fileScan.close();
    }

}