/**
 * Not actually a sort - more like a filter.
 * Used to separate a "Model" object into sublists for each season.
 * 
 * @author Evan Ansell
 */
package sorting;

import java.util.ArrayList;

import adt.Model;

public class SortToSeasons {

	/**
	 * 
	 * @param name - Winter, Spring, Summer, Fall are the only acceptable names
	 * @param source - Model to split into seasons
	 * @return a Model object containing all (and only) data for the chosen season
	 */
	public static Model makeSeason(String name, Model source){
		Model season = new Model(name);
		
		if (name.equals("Winter")) {
			for (int i = 0; i < source.getValues().size(); i++){
				int month = Integer.parseInt(source.getDate(i).split("/")[1]);
				if ((month == 12) | (month == 01) | (month == 02)) {
					season.addDate(source.getDate(i));
					season.addValue(source.getValue(i));
				}
			}
		}
		
		if (name.equals("Spring")) {
			for (int i = 0; i < source.getValues().size(); i++){
				int month = Integer.parseInt(source.getDate(i).split("/")[1]);
				if ((month == 03) | (month == 04) | (month == 05)) {
					season.addDate(source.getDate(i));
					season.addValue(source.getValue(i));
				}
			}
		}
		
		if (name.equals("Summer")) {
			for (int i = 0; i < source.getValues().size(); i++){
				int month = Integer.parseInt(source.getDate(i).split("/")[1]);
				if ((month == 06) | (month == 07) | (month == 8)) {
					season.addDate(source.getDate(i));
					season.addValue(source.getValue(i));
				}
			}
		}
		
		if (name.equals("Fall")) {
			for (int i = 0; i < source.getValues().size(); i++){
				int month = Integer.parseInt(source.getDate(i).split("/")[1]);
				if ((month == 9) | (month == 10) | (month == 11)) {
					season.addDate(source.getDate(i));
					season.addValue(source.getValue(i));
				}
			}
		}
		
		
		return season;
	}
	
}
