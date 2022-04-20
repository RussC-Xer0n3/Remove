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