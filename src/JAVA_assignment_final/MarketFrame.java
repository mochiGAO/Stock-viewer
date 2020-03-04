package JAVA_assignment_final;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.time.Month;
import java.util.Calendar;
import java.util.List;

import javax.swing.*;



import java.time.*;


/**
 * This class will show the the fist window 
 * for selecting tickerSymbol & date.
 */

public class MarketFrame extends JFrame implements ActionListener{
	private String string;
	private JButton quitButton;
	private JButton searchButton;
	private JLabel tickerSymbolLable;
	String [] company = {"AAPL","MSFT","WUBA","BBB"};
	
	private JComboBox<String> tickerSelect;
	private JLabel DateLableStart;
	private JLabel DateLableEnd;
	private CalendarPanel DateStart;
	private CalendarPanel DateEnd;
	String companySymbol;

	public MarketFrame() {
		
		//set window's title,size,location and so on
		
		setTitle("MarketGUI");
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension dimension = toolkit.getScreenSize();
		setSize(500, 300);
		setLocation(new Point(dimension.width/4, dimension.height/4));
		Container container = this.getContentPane();
		
		//this panel for tickerSymbol selecting
		JPanel P = new JPanel();
		container.add(P,BorderLayout.NORTH);

		tickerSymbolLable = new JLabel("company ticker Symbol:" );		
		P.add(tickerSymbolLable);
			
		tickerSelect = new JComboBox<String>(company);
		tickerSelect.setBorder(BorderFactory.createTitledBorder("please select a ticker symbol"));
		
		tickerSelect.insertItemAt("please select a ticker symbol", 0);
		tickerSelect.setMaximumRowCount(3);
		P.add(tickerSelect);

		
		//this panel for startdate & enddate selecting
		P = new JPanel(new GridLayout(2,5,0,0));
		container.add(P,BorderLayout.CENTER);
		DateLableStart = new JLabel("date From");
		P.add(DateLableStart);
		DateStart = new CalendarPanel();
		P.add(DateStart,"South");
		 
		DateLableEnd = new JLabel("To");
		P.add(DateLableEnd);
		DateEnd = new CalendarPanel();
		P.add(DateEnd,"South");
		
		//this panel for search button & quit button
		P = new JPanel();
		container.add(P,BorderLayout.SOUTH);
		searchButton = new JButton("Search");
		searchButton.addActionListener(this);		 
		P.add(searchButton);
		 
		quitButton = new JButton("Quit");
		quitButton.addActionListener(this);
		P.add(quitButton);
		
	}
	
	public void actionPerformed(ActionEvent event) {
		Object source = event.getSource();
		if (source == quitButton) {
			System.exit(0);
			}
		else if(source == searchButton) {
			companySymbol = tickerSelect.getSelectedItem().toString();
			
			//get the date of date from jcombox
			String selectDateStart = DateStart.selectDate;
			String selectDateEnd = DateEnd.selectDate;
			
//			int year1 = DateStart.year;
//			int month1 = DateStart.month;
//			int day1 = DateStart.day;
//			
//			int year2 = DateEnd.year;
//			int month2 = DateEnd.month;
//			int day2 = DateEnd.day;
			
			
	
			//System.out.println(year1);
			System.out.println(selectDateStart);
			System.out.println(selectDateEnd);
			System.out.println(companySymbol);
			
			
			
			//instancing ConnURL class to get connection with download path
			String linkstr = "https://quotes.wsj.com/"+companySymbol+"/historical-prices/download?MOD_VIEW=page&num_rows=300&startDate="+selectDateStart+"&endDate="+selectDateEnd;
			ConnURL link = new ConnURL(linkstr);
			
			//open new window which show drawing line chat
			MarketGraphicsFrame newWindow = new MarketGraphicsFrame();
			newWindow.setVisible(true);
			
			}
			
		}
		 
}

