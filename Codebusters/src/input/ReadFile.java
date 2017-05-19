/**
 * Used to read the dataset for the climate data.
 * Currently it's only usable for 2 periods, but can be expended for more.
 * Based off of the csv-reader used in my previous group project LyricsByU which can be found here: https://gitlab.cas.mcmaster.ca/2xb3_Group8/LyricsByU
 * 
 * @author Evan Ansell
 */
package input;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
//import java.util.regex.Pattern;

import adt.Period;

public class ReadFile {
 
		/**
		 * Reads through a designated csv file to extract the climate data into Period objects
		 * @param dataset - String representing the relative path to the file
		 * @return an ArrayList of Period objects - one for each period in the dataset
		 */
		public static ArrayList<Period> readCSV(String dataset){
			int countPreLines = 0;
			BufferedReader reader = null;
			String line = "";
			String arr[] = null;
			ArrayList<Period> periodList = new ArrayList<Period>();
			Period period1 = new Period();
			period1.setPeriod("1986-2005");
			Period period2 = new Period();
			period2.setPeriod("2040-2069");
			try {
				reader = new BufferedReader(new FileReader(dataset)); 
				reader.readLine();
				while((line=reader.readLine())!=null){
					if (countPreLines < 2)
						++countPreLines;
					else {
						arr = line.split(",");
						if (arr[2].equals("1986-2005")){//period.getPeriod() != arr[2]) {
							//periodList.add(period);
							//period = new Period();
							//period.setPeriod(arr[2]);
						//}
						period1.addDate(arr[0]);
						period1.addValue(arr[1]);
						period1.addModel(arr[3]);
						} else if (arr[2].equals("2040-2069")) {
							period2.addDate(arr[0]);
							period2.addValue(arr[1]);
							period2.addModel(arr[3]);
					}
				}
				}
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			periodList.add(period1);
			periodList.add(period2);
			return periodList;	
		}
}