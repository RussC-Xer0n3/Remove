package remove;
//Modded from Lewis Loftus Java Software Solutions Foundations of program design 7th ed.pg. 522-525
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.io.File;

public class DisplayFile {

	public static void main(String[] args) {
		display();
		set();
	}

	public static void display() throws NullPointerException {

		JFrame frame = new JFrame("Browse - Source File");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JFileChooser chooser = new JFileChooser();
		int status = chooser.showOpenDialog(null);

		if(status != JFileChooser.APPROVE_OPTION) {
			JOptionPane.showMessageDialog(null, "You have not selected a file.");
		} else {
			File file = chooser.getSelectedFile();
			remove_8.getFile();
			remove_8.setFile(file);
		}

		frame.pack();
		frame.setVisible(true);
	}

	public static void set() throws NullPointerException {

		JFrame frame = new JFrame("Browse - Destination File");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JFileChooser chooser = new JFileChooser();
		int status = chooser.showOpenDialog(null);

		if(status != JFileChooser.APPROVE_OPTION) {
			JOptionPane.showMessageDialog(null, "You have not selected an output file.");
		} else {
			File file = chooser.getSelectedFile();
			remove_8.getOutFile();
			remove_8.setOutFile(file);
		}

		frame.pack();
		frame.setVisible(true);
	}
}