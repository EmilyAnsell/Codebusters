package processing;

import java.util.ArrayList;

import adt.Model;
import adt.Period;
import input.ReadFile;
import sorting.MergeSort;

/**
 * The {@code CombineModels} class uses the list of values from objects of type Model to calculate
 * several statistics including median, maximum, minimum, the average of multiple medians and median 
 * absolute deviation.
 * 
 * @author Olivia Tinios 
 * Date Revised: 12/05/2017
 */
public class CombineModels {
	 
	/**
	  * Finds the median value of a list of doubles.
	  * 
	  * @param x - the input list of doubles.
	  * @return - the median.
	  */
	public static double findMedian(ArrayList<Double> x){
		int i = x.size();
		if (x.size() % 2 == 0) {
			return (x.get(i/2 - 1) + x.get(i/2))/2;
		}
		else {
			return x.get(i/2);
		}		
	}
	
	/**
	 * Takes a list of Model objects and returns the average of a list of medians from each model, the minimum 
	 * value from all models combined and the maximum value from all models combined.
	 * 
	 * @param models - the input list of Model objects.
	 * @return - a list containing the average of medians, the minimum value and the maximum value in that order.
	 */
	public static ArrayList<Double> findStats(ArrayList<Model> models) {
		
		ArrayList<Double> stats = new ArrayList<Double>();
		
		// find medians for each model and find overall max and min from all models combined
		double min = 99;
		double max = -99;
		ArrayList<Double> medians = new ArrayList<Double>();
		for (int i = 0; i < models.size(); i++) {
			ArrayList<Double> sortedValues = MergeSort.sort(models.get(i));
			medians.add(findMedian(sortedValues));
			if (sortedValues.get(0) < min)
				min = sortedValues.get(0);
			if (sortedValues.get(sortedValues.size()-1) > max)
				max = sortedValues.get(sortedValues.size()-1);
		}
		
		// find average of medians
		double sum = 0;
		for (int i = 0; i < medians.size(); i++) {
			sum += medians.get(i);
		}
		stats.add(sum/medians.size());
		
		stats.add(min);
		stats.add(max);
		
		return stats;
	}
	
	/**
	 * Finds the median absolute deviation for each model.
	 * 
	 * @param models - a list of Model type objects.
	 * @param medians - a list of the medians for each model.
	 * @return - a list of the median absolute deviations for each model.
	 */
	public static ArrayList<Double> absoluteDeviations(ArrayList<Model> models, ArrayList<Double> medians) {
		
		ArrayList<Double> deviations = new ArrayList<Double>();
		
		ArrayList<Double> temp;
		for (int i = 0; i < models.size(); i++) {
			temp = new ArrayList<Double>();
			for (int j = 0; j < models.get(i).getValues().size(); j++) {
				temp.add(Math.abs(models.get(i).getValue(j) - medians.get(i)));
			}
			MergeSort.sort(temp);
			deviations.add(findMedian(temp));
		}
		return deviations;
	}
	
}
