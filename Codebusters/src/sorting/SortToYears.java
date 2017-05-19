/**
 * Not actually a sort - more like a filter.
 * Used to separate a "Model" object into sublists for each year.
 * 
 * @author Evan Ansell
 */
package sorting;

import java.util.ArrayList;

import adt.Model;

public class SortToYears {
	
	public static ArrayList<Model> yearlySort(Model source){
		//go through all items and for each new year create a new period -> add to list
		//maybe start at a new year jan 01? so that only full years
		
		ArrayList<Model> years = new ArrayList<Model>();
		Model tempModel = new Model("yearly");
		int yearCount = 0;
		int index = 0;
		int initialYear = Integer.parseInt(source.getDate(0).split("/")[0]); //this parses the year from the date
		
		while (index < source.getValues().size()){
			//System.out.println(yearCount + "  " + index);
			if (Integer.parseInt(source.getDate(index).split("/")[0]) == (initialYear + yearCount)) {
				tempModel.addDate(source.getDate(index));
				tempModel.addValue(source.getValue(index));
				index++;
			} else {
				years.add(tempModel);
				tempModel = new Model("yearly");
				yearCount++;
			}
			
		}
		
		return years;
		
	}
	
	
}
