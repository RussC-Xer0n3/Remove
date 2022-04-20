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
//import java.util.ArrayList;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class remove_2 {
    
    public static void main(String[] args) throws IOException{
    
        File myFile = new File("/media/russell/_HBK^/eclipse-workspace/Remcovert/"
        		+ "About"
        		+ ".java");

        // read in file
		Scanner fileScan = new Scanner(myFile);
		
		// write to file
		PrintWriter fileOut = new PrintWriter(new BufferedWriter(new FileWriter("outFile.txt")));
	
		//ArrayList?
		//ArrayList<String> myArrayList = new ArrayList<String>();
		
        do {/*remove all numbers and symbols and just print the alpha characters*/
                fileOut.println(fileScan);
        } while(fileScan.hasNext());
        
        System.out.println("done");
        
        fileOut.close();
        fileScan.close();
    }

}
