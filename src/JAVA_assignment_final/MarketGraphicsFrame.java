package JAVA_assignment_final;

import java.awt.BorderLayout;
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
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import javafx.application.Platform;


/**
 * This class will show a window for 
 * selecting which data be wanted to 
 * drawing a line chart
 */

public class MarketGraphicsFrame extends JFrame implements ActionListener {

	static List<String> a = new ArrayList<String>();
	static List<Double> b = new ArrayList<Double>();
	String docName = "test.csv";//the doc which saving data
	private JButton openRButton, closeRButton, highRButton, lowRButton, volumeRButton;
	private JButton quitButton;

	public MarketGraphicsFrame() {
		
		//set window's title,size,location and so on
		setTitle("please select a colume data you want view");
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension dimension = toolkit.getScreenSize();
		setSize(500, 300);
		setLocation(new Point(dimension.width / 4, dimension.height / 4));
		Container container = this.getContentPane();

		JPanel p = new JPanel();

		//add 5 button to this panel for selecting data type
		p = new JPanel(new GridLayout(6, 1));
		container.add(p);
		
		
		openRButton = new JButton("OpenPrice");
		openRButton.addActionListener(this);
		p.add(openRButton);

		closeRButton = new JButton("ClosePrice");
		closeRButton.addActionListener(this);
		p.add(closeRButton);

		lowRButton = new JButton("LowPrice");
		lowRButton.addActionListener(this);
		p.add(lowRButton);

		highRButton = new JButton("HighPrice");
		highRButton.addActionListener(this);
		p.add(highRButton);

		volumeRButton = new JButton("Volume");
		volumeRButton.addActionListener(this);
		p.add(volumeRButton);

		quitButton = new JButton("Quit");
		quitButton.addActionListener(this);
		p.add(quitButton);

	}


	@Override
	public void actionPerformed(ActionEvent event) {
		Object source = event.getSource();
		if (source == quitButton) {
			System.exit(0);
		}
		if (source == openRButton) {
			
			//if press openbutton, y axis's data is open price of one day
			DataRead testreader = new DataRead(docName);
			a = testreader.dateList;
			b = testreader.openList;

			MarketGraphicsGUI newGraphWindow = new MarketGraphicsGUI();
			newGraphWindow.initAndShowGUI(a, b);

		} else if (source == closeRButton) {
			
			//if press closebutton, y axis's data is close price of one day

			DataRead testreader = new DataRead(docName);
			a = testreader.dateList;
			b = testreader.closeList;

			MarketGraphicsGUI newGraphWindow = new MarketGraphicsGUI();
			newGraphWindow.initAndShowGUI(a, b);

		}

		else if (source == lowRButton) {

			//if press lowbutton, y axis's data is lowest price of one day
			DataRead testreader = new DataRead(docName);
			a = testreader.dateList;
			b = testreader.lowList;

			MarketGraphicsGUI newGraphWindow = new MarketGraphicsGUI();
			newGraphWindow.initAndShowGUI(a, b);

		}

		else if (source == highRButton) {

			//if press high button, y axis's data is highest price of one day
			DataRead testreader = new DataRead(docName);
			a = testreader.dateList;
			b = testreader.highList;

			MarketGraphicsGUI newGraphWindow = new MarketGraphicsGUI();
			newGraphWindow.initAndShowGUI(a, b);

		}

		else if (source == volumeRButton) {
			
			//if press volumeRButton, y axis's data is volume of one day
			DataRead testreader = new DataRead(docName);
			a = testreader.dateList;
			b = testreader.vulomeList;

			MarketGraphicsGUI newGraphWindow = new MarketGraphicsGUI();
			newGraphWindow.initAndShowGUI(a, b);

		}

	}

}
