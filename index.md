<nav class="w3-container w3-teal w3-center w3-margin-top">
<br>
  <a href="https://www.facebook.com/profile.php?id=100075972987666"><i class="fa fa-facebook-official w3-hover-opacity"></i></a>
  <a href="https://www.instagram.com/russellclarke821"><i class="fa fa-instagram w3-hover-opacity"></i></a>
  <a href="https://www.pinterest.co.uk/russellclarke821/"><i class="fa fa-pinterest-p w3-hover-opacity"></i></a>
  <a href="https://twitter.com/Developing821"><i class="fa fa-twitter w3-hover-opacity"></i></a>
  <a href="https://www.linkedin.com/in/russell-clarke-09a1a5238"></a><i class="fa fa-linkedin w3-hover-opacity"></i>
<br>
</nav>
# Remove
## Leaves only Letters and Numbers

### But why?
Initially the project was part of another project regarding music; The plan and idea was to find out what all my or someone eleses code sounds like once all of the parenthesis and semicolons etc had been removed. The non-alphanumeric symbols would be removed and the resulting data would be typed or fed into the music program such as QBase or something like that through the keyboard syth and find out what it sounds like.

### Interface
I chose to write it in Java because the interfaces are fairly simple to build using the JFX.

```
package remove;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class remove_Interface {

	public static void main(String[] args){

        JFrame frame = new JFrame ("Remove - File Parser");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        frame.getContentPane().add(new NavigationPanel());
        frame.pack();
        frame.setVisible(true);
    }
}
```

### Navigation Panel in the Interface
Adding the Navigation Panel was simple when reading through Lewis & Loftus Java programming 2nd Ed.
```
@SuppressWarnings("serial")
public class NavigationPanel extends JPanel {

	Scanner scan = new Scanner(System.in);
	private JButton parse, exit, locate, destined;
	JTextField loc, dst;
    private JLabel loc_label, dst_label;

    public NavigationPanel () {

        locate = new JButton("Browse");
        locate.addActionListener(new FileSystemListener());
        loc = new JTextField();
        
        loc.setPreferredSize(new Dimension(250, 20));
        loc_label = new JLabel ("Source File: ");
        locate.setVisible(true);

        destined = new JButton("Browse");
        destined.addActionListener(new FileSystemSetter());
        dst = new JTextField();
        //dst.setText(remove_8.getOutFile().getAbsoluteFile().toString());
        dst.setPreferredSize(new Dimension(250, 20));
        dst_label = new JLabel ("Output File: ");
        destined.setVisible(true);

        exit = new JButton("Cancel");
        exit.addActionListener(new ExitHandler());
        exit.setVisible(true);

        parse = new JButton("Parse");
        parse.addActionListener(new ParseHandler());
        parse.setVisible(true);

        add(loc_label, BorderLayout.WEST);
        add(loc, BorderLayout.CENTER);
        add(locate, BorderLayout.EAST);

        add(dst_label, BorderLayout.WEST);
        add(dst, BorderLayout.CENTER);
        add(destined, BorderLayout.EAST);

        add(exit, BorderLayout.SOUTH);
        add(parse, BorderLayout.SOUTH);

        setPreferredSize(new Dimension(500, 100));
        setBackground(Color.white);

        scan.hasNext();

        while (scan.hasNext() && ((loc.getText().toString() == null && remove_8.getFile() == null) || (dst.getText().toString() == null && remove_8.getOutFile() == null))) {
        	if (loc.getText().toString() == null && remove_8.getFile() == null) {
        		String written_location = scan.nextLine();
        		File file = new File(written_location); //https://stackoverflow.com/questions/11583364/convert-string-to-file-in-java
        		loc.setText(written_location);
        		remove_8.setFile(file);
        	} else {continue;}

        	if (dst.getText().toString() == null && remove_8.getOutFile() == null) {
        		String written_destination = scan.nextLine();
        		File oFile = new File(written_destination);
        		loc.setText(written_destination);
        		remove_8.setOutFile(oFile);
        	} else {continue;}
        }
    }

```

### Functionality
and of course the functionality, that was the hard part moving forward
```
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
```
<head>
    <meta content="text/html; charset=utf-8" http-equiv="Content-Type">
    <meta charset="UTF-8">
    <meta name="description" content="Projects and Portfolio">
    <meta name="keywords" content="HTML, CSS, JavaScript, PHP, MySQLi, Python, Java, C, C++, C#, Time, Shapes">
    <meta name="author" content="Russell Clarke">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<footer class="w3-container w3-teal w3-center w3-margin-top">
  <p>Find me on social media.</p>
  <a href="https://www.facebook.com/profile.php?id=100075972987666"><i class="fa fa-facebook-official w3-hover-opacity"></i></a>
  <a href="https://www.instagram.com/russellclarke821"><i class="fa fa-instagram w3-hover-opacity"></i></a>
  <a href="https://www.pinterest.co.uk/russellclarke821/"><i class="fa fa-pinterest-p w3-hover-opacity"></i></a>
  <a href="https://twitter.com/Developing821"><i class="fa fa-twitter w3-hover-opacity"></i></a>
  <a href="https://www.linkedin.com/in/russell-clarke-09a1a5238"></a><i class="fa fa-linkedin w3-hover-opacity"></i>
  <p>Powered by <a href="https://www.w3schools.com/w3css/default.asp" target="_blank">w3.css</a></p>
</footer>
