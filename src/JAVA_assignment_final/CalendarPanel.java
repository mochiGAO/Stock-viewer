package JAVA_assignment_final;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Calendar;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * This class is a calender panel
 * including 3 jcombox for selecting year,month and day
 */

public class CalendarPanel extends JPanel implements ActionListener{
	
	private int start = 2000;
	private int end = 2018;
	private JComboBox<String> yearbox;
	private JComboBox<String> monthbox;
	private JComboBox<String> daybox;
	private int y;
	private int m;
	private int d;
	
	int year;
	int month;
	double day;
		
	String YearSelect;
	String MonthSelect;
	String DaySelect;
	String selectDate;
	int days;
		
	public CalendarPanel() {
		
		yearbox = new JComboBox();
		yearbox.setModel(new DefaultComboBoxModel(getModel(start, end)));
		yearbox.setBorder(BorderFactory.createTitledBorder("year"));
		yearbox.setMaximumRowCount(6);
		add(yearbox);
		
		monthbox = new JComboBox();
		monthbox.setModel(new DefaultComboBoxModel(getModel(1, 12)));
		monthbox.setBorder(BorderFactory.createTitledBorder("month"));
		monthbox.setMaximumRowCount(6);
		add(monthbox);
		
		
		daybox = new JComboBox();	
		daybox.setBorder(BorderFactory.createTitledBorder("day"));
		daybox.setMaximumRowCount(6);
		add(daybox);		 
		 

		//update day after selest year
		yearbox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				setDay(yearbox, monthbox, daybox);
				YearSelect = yearbox.getSelectedItem().toString();
				}
			});
		
		//update day after selest month
		monthbox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				setDay(yearbox, monthbox, daybox);
				MonthSelect = monthbox.getSelectedItem().toString();
				}
			});
		
		//get day after selest month
		daybox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				DaySelect = daybox.getSelectedItem().toString();
				selectDate = MonthSelect + "/" + DaySelect + "/" + YearSelect;
				}
			});
		
		
		setDay(yearbox, monthbox, daybox);
		YearSelect = yearbox.getSelectedItem().toString();
		MonthSelect = monthbox.getSelectedItem().toString();
		
	}
	
	 /**
	 * calculate days in select month & year
	 */
	private void setDay(JComboBox yearbox, JComboBox monthbox, JComboBox daybox) {
		int y = Integer.parseInt((String) yearbox.getSelectedItem());
		int m = Integer.parseInt((String) monthbox.getSelectedItem());
		Calendar c = Calendar.getInstance();
		c.set(Calendar.YEAR, y);
		c.set(Calendar.MONTH, m - 1);
		days = c.getActualMaximum(Calendar.DAY_OF_MONTH);
		daybox.setModel(new DefaultComboBoxModel(getModel(1, days)));
		YearSelect = yearbox.getSelectedItem().toString();
		MonthSelect = monthbox.getSelectedItem().toString();
		DaySelect = daybox.getSelectedItem().toString();

	}

		 
		 
	/**
	 * get String array [start, end]
	 */
	private String[] getModel(int start, int end) {
		String[] m = new String[end - start + 1];
		String item;
		for (int i = 0; i < m.length; i++) {
			if (i + start > 9) {
				item = String.valueOf(i + start);
				m[i] = item;
			} else {
				item = "0" + String.valueOf(i + start);
				m[i] = item;
			}
		}
		return m;
	}

	@Override
	public void actionPerformed(ActionEvent event) {

	}
}	 


