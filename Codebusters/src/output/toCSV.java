/**
 * A class (made in a rush) to create a csv document that would be read by the graph-making component of our project.
 * Two methods - one for making a csv for the yearly data, one for the seasonal data.
 * 
 * @author Evan Ansell
 */
package output;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import processing.CombineModels;

import sorting.SortToSeasons;
import sorting.SortToYears;

import adt.Model;

public class toCSV {

	/**
	 * Creates a csv with the first column representing the year and the second representing the temperature/precipitation (value)
	 * @param allModels - list of all model objects, one for each climate model
	 * @throws IOException
	 */
	public static void makeCSV(ArrayList<Model> allModels) throws IOException{
		 File out = new File("annual.csv");
		 FileWriter output = new FileWriter(out);
		 
		 ArrayList<Model> tempModels1;
		 ArrayList<Model> tempModels2;
		 ArrayList<Model> tempModels3;
		 ArrayList<Model> tempModels4;
		 ArrayList<Model> tempModels5;
		 tempModels1 = SortToYears.yearlySort(allModels.get(0));
		 tempModels2 = SortToYears.yearlySort(allModels.get(1));
		 tempModels3 = SortToYears.yearlySort(allModels.get(2));
		 tempModels4 = SortToYears.yearlySort(allModels.get(3));
		 tempModels5 = SortToYears.yearlySort(allModels.get(4));
		 
		 ArrayList<Double> yearStats = new ArrayList<Double>();
		 for (int i = 1; i < tempModels1.size(); i++){
			 ArrayList<Model> yearModel = new ArrayList<Model>();
			 yearModel.add(tempModels1.get(i));
			 yearModel.add(tempModels2.get(i));
			 yearModel.add(tempModels3.get(i));
			 yearModel.add(tempModels4.get(i));
			 yearModel.add(tempModels5.get(i));
			 
			 yearStats = CombineModels.findStats(yearModel);
			 output.write( tempModels1.get(i).getDate(i).split("/")[0]+ "," + yearStats.get(0) + "\n");
		 }
		 
		 for (int i = 0; i < tempModels1.size(); i++) {
			
		 }
		
		 output.close();
	}
	
	
	/**
	 * Creates a csv with the first column representing the season and the second representing the temperature/precipitation (value)
	 * @param allModels - list of all model objects, one for each climate model
	 * @throws IOException
	 */
	public static void makeSeasonCSV(ArrayList<Model> allModels) throws IOException{
		 File out = new File("seasons.csv");
		 FileWriter output = new FileWriter(out);
		 
		 ArrayList<Model> tempModels1 = new ArrayList<Model>();
		 ArrayList<Model> tempModels2= new ArrayList<Model>();
		 ArrayList<Model> tempModels3= new ArrayList<Model>();
		 ArrayList<Model> tempModels4= new ArrayList<Model>();
		 ArrayList<Model> tempModels5= new ArrayList<Model>();
		 tempModels1.add(SortToSeasons.makeSeason("Winter", allModels.get(0)));
		 tempModels1.add(SortToSeasons.makeSeason("Spring", allModels.get(0)));
		 tempModels1.add(SortToSeasons.makeSeason("Summer", allModels.get(0)));
		 tempModels1.add(SortToSeasons.makeSeason("Fall", allModels.get(0)));
		 tempModels2.add(SortToSeasons.makeSeason("Winter", allModels.get(1)));
		 tempModels2.add(SortToSeasons.makeSeason("Spring", allModels.get(1)));
		 tempModels2.add(SortToSeasons.makeSeason("Summer", allModels.get(1)));
		 tempModels2.add(SortToSeasons.makeSeason("Fall", allModels.get(1)));
		 tempModels3.add(SortToSeasons.makeSeason("Winter", allModels.get(2)));
		 tempModels3.add(SortToSeasons.makeSeason("Spring", allModels.get(2)));
		 tempModels3.add(SortToSeasons.makeSeason("Summer", allModels.get(2)));
		 tempModels3.add(SortToSeasons.makeSeason("Fall", allModels.get(2)));
		 tempModels4.add(SortToSeasons.makeSeason("Winter", allModels.get(3)));
		 tempModels4.add(SortToSeasons.makeSeason("Spring", allModels.get(3)));
		 tempModels4.add(SortToSeasons.makeSeason("Summer", allModels.get(3)));
		 tempModels4.add(SortToSeasons.makeSeason("Fall", allModels.get(3)));
		 tempModels5.add(SortToSeasons.makeSeason("Winter", allModels.get(4)));
		 tempModels5.add(SortToSeasons.makeSeason("Spring", allModels.get(4)));
		 tempModels5.add(SortToSeasons.makeSeason("Summer", allModels.get(4)));
		 tempModels5.add(SortToSeasons.makeSeason("Fall", allModels.get(4)));
		 
		 ArrayList<Double> yearStats = new ArrayList<Double>();
		 for (int i = 0; i < tempModels1.size(); i++){
			 ArrayList<Model> yearModel = new ArrayList<Model>();
			 yearModel.add(tempModels1.get(i));
			 yearModel.add(tempModels2.get(i));
			 yearModel.add(tempModels3.get(i));
			 yearModel.add(tempModels4.get(i));
			 yearModel.add(tempModels5.get(i));
			 
			 yearStats = CombineModels.findStats(yearModel);
			 output.write( tempModels1.get(i).getDate(i).split("/")[1]+ "," + yearStats.get(0) + "," +  yearStats.get(1) + "," + yearStats.get(2) + "\n");
		 }
		 
		 for (int i = 0; i < tempModels1.size(); i++) {
			
		 }
		
		 output.close();
	}
}
