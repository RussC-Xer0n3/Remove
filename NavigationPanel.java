package remove;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

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

    private static class FileSystemListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent event) {

			DisplayFile.display(); //Call the method.
        }
    }

    private static class FileSystemSetter implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent event) {

			DisplayFile.set(); //Call the method.
		}
    }

    private class ParseHandler implements ActionListener {

        @Override
		public void actionPerformed(ActionEvent event) {

            if (remove_8.getFile() == null || remove_8.getOutFile() == null) {
            	JOptionPane.showMessageDialog(null, "Please make a selection and set your output file");
            	scan.hasNext();
            } else {
            	try {
					remove_8.parse();
				} catch (FileNotFoundException e) {
					JOptionPane.showMessageDialog(null, "The file no longer exists.");
					e.printStackTrace();
				} catch (IndexOutOfBoundsException e) {
					JOptionPane.showMessageDialog(null, "There has been an error parseing the file, either there is no information to parse in the file or there has been a programming error. Please contact the developer(s) developing82@gmail.com.");
					e.printStackTrace();
				} catch (IOException e) {
					JOptionPane.showMessageDialog(null, "Please make a selection and set your output file.");
					e.printStackTrace();
				}

            	String output = remove_8.getOutFile().toString();
            	JOptionPane.showMessageDialog(null, "Done, the output file is: " + output);
            	scan.close();
            }
        }
    }

    private class ExitHandler implements ActionListener {

    	// Exit button Action: provide an option dialog./
		JFrame exitFrame;

		public ExitHandler() {

			exitFrame = new JFrame();
			exitFrame.setLocation(600, 400);
			exitFrame.setVisible(true);
		}

		@Override
		public void actionPerformed(ActionEvent e) {

			int n = JOptionPane.showConfirmDialog(exitFrame, "Are you sure you want to close the program?", "Close?",
					JOptionPane.YES_NO_OPTION);

			if (n == JOptionPane.YES_OPTION) {
				System.exit(0);
			}
		}
    }
}