/**
 * Data type for the two periods we were given.
 * Used to store and access the data which is read in from the dataset.
 * 
 * @author Evan Ansell
 */
package adt;

import java.util.ArrayList;

public class Period {
	private String period;
	
	// all of the elements will be String for now - can process when needed?
	private ArrayList<String> dates = new ArrayList<String>();
	private ArrayList<Double> values = new ArrayList<Double>();
	private ArrayList<String> models = new ArrayList<String>();
	
	private double valueSum = 0;
	
	public Period(){
		period = "";
	}
	
	public Period(String name){
		period = name;
	}
	
	public void setPeriod(String newPeriod){
		period = newPeriod;
	}
	
	public String getPeriod(){
		return period;
	}
	
	public void addDate(String date){
		dates.add(date);
	}
	
	public void addValue(String value){
		values.add(Double.parseDouble(value));
	}
	
	public void addModel(String model){
		models.add(model);
	}
	
	public int getSize(){
		return dates.size();
	}
	
	public void sumValues(){
		for (int i = 0; i < values.size(); i++) {
			valueSum += values.get(i);
		}
	}
	
	public double getAvgValue(){
		return valueSum / values.size();
	}
	
	public void printValues(){
		for (int i = 0; i < values.size(); i++) {
			System.out.println(values.get(i));
		}
	}

	public void printSample(){
		for (int i = 0; i < 10; i++) {
			System.out.println(dates.get(i) + " " + values.get(i));
		}
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
	
	/**
	 * Creates a list of Model objects for each model in the period.
	 */
	public ArrayList<Model> processToModels(){
//		String prevModel = "";
//		int modelCount = 0;
		Model model1 = new Model("CanESM2");
		Model model2 = new Model("GFDL-ESM2M");
		Model model3 = new Model("HadGEM2-ES");
		Model model4 = new Model("IPSL-CM5A-LA");
		Model model5 = new Model("MPI-ESM-MR");
		for (int i = 0; i < values.size(); i++) {
			
			/*if (models.get(i) != prevModel){
				prevModel = models.get(i);
				modelCount++;
			}*/
			if (models.get(i).equals("CanESM2")){
				model1.addDate(dates.get(i));
				model1.addValue(values.get(i));
			} else if (models.get(i).equals("GFDL-ESM2M"))	{
					model2.addDate(dates.get(i));
					model2.addValue(values.get(i));
			}else if (models.get(i).equals("HadGEM2-ES")) {
				model3.addDate(dates.get(i));
				model3.addValue(values.get(i));
			}else if (models.get(i).equals("IPSL-CM5A-LA")) {
					model4.addDate(dates.get(i));
					model4.addValue(values.get(i));
			} else if (models.get(i).equals("MPI-ESM-MR")) {
					model5.addDate(dates.get(i));
					model5.addValue(values.get(i));
			}
		}
		ArrayList<Model> dataModels = new ArrayList<Model>();
		dataModels.add(model1);
		dataModels.add(model2);
		dataModels.add(model3);
		dataModels.add(model4);
		dataModels.add(model5);
		return dataModels;
	}
}
