/**
 * Data type for the different climate models.
 * Used to store and access the data which is read in from the dataset - created from each period.
 * In hindsight, this should should have inherited from the Period class (or just had its functionality rolled into one class),
 * but this is how I chose to organize the data in my haste.
 * 
 * @author Evan Ansell
 */
package adt;

import java.util.ArrayList;

public class Model {
	private String name;
	
	private ArrayList<String> dates = new ArrayList<String>();
	private ArrayList<Double> values = new ArrayList<Double>();
	
	private double uncertainty;
	private double median;
	
	
	public Model(String modelName){
		name = modelName;
	}

	public String getName(){
		return name;
	}
	
	public ArrayList<Double> getValues(){
		return values;
	}
	
	public Double getValue(int index){
		return values.get(index);
	}
	
	public ArrayList<String> getDates(){
		return dates;
	}
	
	public String getDate(int index){
		return dates.get(index);
	}
	
	public void addDate(String date) {
		dates.add(date);
	}


	public void addValue(Double value) {
		values.add(value);	
	}
	
	//this method, and the ones below it, didn't end up being used in our prototype.
	//some of this functionality is performed by the CombineModels class.
	public void setUncertainty(double uncertainty){
		this.uncertainty = uncertainty;
	}
	
	public double getUncertainty(){
		return uncertainty;
	}
	
	public void setMedian(double median){
		this.median = median;
	}
	
	public double getMedian(){
		return median;
	}
	
	public void printSample(){
		for (int i = 0; i < 10; i++) {
			System.out.println(dates.get(i) + " " + values.get(i));
		}
		System.out.println(dates.get(dates.size()-1) + "  " + values.get(values.size()-1));
	}

	public double findMin(){
		double min = 99.99;
		for (int i = 0; i < values.size(); i++) {
			if (values.get(i) < min)
				min = values.get(i);
		}
		return min;
	}
	
	public double findMax(){
		double max = -99.99;
		for (int i = 0; i < values.size(); i++) {
			if (values.get(i) > max)
				max = values.get(i);
		}
		return max;
	}
	
	
}
