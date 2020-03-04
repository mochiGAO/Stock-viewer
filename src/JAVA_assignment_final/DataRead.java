package JAVA_assignment_final;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

//import com.sun.media.jfxmedia.events.NewFrameEvent;

import sheffield.*;


/**
 * This class for reading doc from local
 * 
 */

public class DataRead {

	private EasyReader easyReaders;
	ArrayList<HistoricalPrices> hplist = new ArrayList<>();

	ArrayList<String> dateList = new ArrayList<>();
	ArrayList<Double> openList = new ArrayList<>();
	ArrayList<Double> closeList = new ArrayList<>();
	ArrayList<Double> highList = new ArrayList<>();
	ArrayList<Double> lowList = new ArrayList<>();
	ArrayList<Double> vulomeList = new ArrayList<>();
	HistoricalPrices s;

	public DataRead(String docName) {

		try {

			
			easyReaders = new EasyReader(docName);//read doc
			boolean sign = false; //jump the first line
			while (easyReaders.ready()) {
				String line = easyReaders.readLine();
				StringTokenizer st = new StringTokenizer(line, ",");//  ,  as sign
				String date;
				double open, close, high, low, volume;

				if (st.hasMoreTokens() && sign) {
					
					
					date = String.valueOf(st.nextToken().trim());
					open = Double.valueOf(st.nextToken().trim());
					close = Double.valueOf(st.nextToken().trim());
					high = Double.valueOf(st.nextToken().trim());
					low = Double.valueOf(st.nextToken().trim());
					volume = Double.valueOf(st.nextToken().trim());//iterate and get value

					
					HistoricalPrices HP = new HistoricalPrices(date, open, close, high, low, volume);
					hplist.add(HP);
					
				
					/**
					 * save date in list by category
					 * 
					 */
					dateList.add(HP.getDate());
					openList.add(HP.getOpen());
					closeList.add(HP.getClose());
					highList.add(HP.getHigh());
					lowList.add(HP.getLow());
					vulomeList.add(HP.getVolume());

				} else {
					sign = true;
				}
			}
			easyReaders.close();
		}

		catch (FileNotFoundException ee) {
			ee.printStackTrace();
		} catch (IOException ee2) {
			ee2.printStackTrace();
		}
	}

}
