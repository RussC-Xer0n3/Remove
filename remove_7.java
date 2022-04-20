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

public class remove_7 {

    public static void main(String[] args) throws IndexOutOfBoundsException, IOException{

        File myFile = new File("/media/russell/_HBK^/eclipse-workspace/Remcovert/"
        		+ "index"
        		+ ".html");

        // read in file
		Scanner fileScan = new Scanner(myFile);

		// write to file
		PrintWriter fileOut = new PrintWriter(new BufferedWriter(new FileWriter("outFile.txt")));

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