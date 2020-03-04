package JAVA_assignment_final;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingUtilities;

import javafx.application.Platform;


/**
 * This class will run linechat panel and show a new window including line chat
 * 
 */
public class MarketGraphicsGUI extends JFrame implements ActionListener {
	static List<String> a = new ArrayList<String>();
	static List<Double> b = new ArrayList<Double>();

	public static void initAndShowGUI(List<String> a, List<Double> b) {

		
		JFrame f = new JFrame("LineChart");
		f.setSize(1000, 1000);
		GraphicsPanel graphpanel = new GraphicsPanel();//instancing line chart class
		f.add(graphpanel);//add line chat panel to this window
		f.setVisible(true);

		//runable for line chart panel
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				graphpanel.initMyLineChart(graphpanel, a, b);
			}
		});
	}
	
	//run function
	public static void run() {
		initAndShowGUI(a, b);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}

}
