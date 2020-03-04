package JAVA_assignment_final;

import java.util.ArrayList;



public class HistoricalPrices {
	
	private String date;
	private double open;
	private double close;
	private double high;
	private double low;
	private double volume;

	/**
	 * Constructor method of HistoricalPrices.
	 *
	 * @param data  HistoricalPrices's data.
	 * @param open HistoricalPrices's open price of one day.
	 * @param close HistoricalPrices's close price of one day.
	 * @param high HistoricalPrices's highest price of one day.
	 * @param low HistoricalPrices's lowest price of one day.
	 * @param volume HistoricalPrices's volume of one day.
	 * 
	 */

	HistoricalPrices(String date, double open, double close, double high, double low, double volume) {
		this.date = date;
		this.open = open;
		this.close = close;
		this.high = high;
		this.low = low;
		this.volume = volume;
	}
	
	/**
	 * Getter method.
	 *
	 */

	
	String getDate() {
		return date;
	}
	double getOpen() {
		return open;
	}
	double getClose() {
		return close;
	}
	double getHigh() {
		return high;
	}
	double getLow() {
		return low;
	}
	double getVolume() {
		return volume;
	}

}
