package JAVA_assignment_final;

import javax.swing.JFrame;

/**
 * This class will show the Market GUI.
 */

public class MarketGUI {
	
	/**
	 * Program starts here.
	 *
	 * @param args command line arguments
	 */
	public static void main(String[] args) {

		JFrame marketframe = new MarketFrame();
		marketframe.pack();
		marketframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Set the frame visible
		marketframe.setVisible(true);
		
	}

}
