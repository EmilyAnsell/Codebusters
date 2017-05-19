/**
 * A temporary "main" class which I used to check how the code I was writing would perform.
 * Not a part of our program.
 * 
 * @author Evan Ansell
 */
package tests;

import adt.Period;
import adt.Model;
import input.ReadFile;

import java.io.IOException;
import java.util.ArrayList;

import output.toCSV;
import sorting.SortToSeasons;
import sorting.SortToYears;

public class simpleTester {

	public static void main(String args[]) throws IOException{
		ArrayList<Period> temps= new ArrayList<Period>();
		temps = ReadFile.readCSV("data/Climate Dataset Precipitation.csv");//"data/Climate Dataset Precipitation.csv");//"data/Climate Dataset Temperatures.csv");
		
		
		System.out.println(temps.size());
		System.out.println(temps.get(0).getPeriod());
		System.out.println(temps.get(0).getSize());
		temps.get(0).sumValues();
		System.out.println(temps.get(0).getAvgValue());
		System.out.println(temps.get(1).getPeriod());
		temps.get(0).printSample();
		
		
		
		ArrayList<Model> tempModels;
		tempModels = temps.get(1).processToModels();
		toCSV.makeSeasonCSV(tempModels);
		toCSV.makeCSV(tempModels);
		System.out.println(tempModels.size());
		tempModels.get(0).printSample();
		tempModels.get(1).printSample();
		
		System.out.println(temps.get(0).findMin() + "  " + temps.get(1).findMin());
		/*
		System.out.println(tempModels.get(0).getName() + "  " + tempModels.get(0).getValues().size() + "  " + tempModels.get(0).getDates().size());
		System.out.println(tempModels.get(1).getName() + "  " + tempModels.get(1).getValues().size() + "  " + tempModels.get(1).getDates().size());
		System.out.println(tempModels.get(2).getName() + "  " + tempModels.get(2).getValues().size() + "  " + tempModels.get(2).getDates().size());
		System.out.println(tempModels.get(3).getName() + "  " + tempModels.get(3).getValues().size() + "  " + tempModels.get(3).getDates().size());
		System.out.println(tempModels.get(4).getName() + "  " + tempModels.get(4).getValues().size() + "  " + tempModels.get(4).getDates().size());
		*/
		
		Model canESM2Summer = SortToSeasons.makeSeason("Summer", tempModels.get(0));
		canESM2Summer.printSample();
		
		Model year2045 = SortToYears.yearlySort((tempModels.get(0))).get(6);
		year2045.printSample();
		System.out.println(year2045.getDates().size());
		
		System.out.println(temps.get(1).findMax());
		
	}
}
