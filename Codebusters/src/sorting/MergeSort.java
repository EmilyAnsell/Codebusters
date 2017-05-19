package sorting;

import java.util.ArrayList;

import adt.Model;

/**
 * The {@code MergeSort} class provides an implementation of merge sort.
 * The sort method will be used to sort a list of doubles.
 * 
 * @author Olivia Tinios 
 * Date Revised: 12/05/2017
 */
public class MergeSort {
	
	private static ArrayList<Double> aux;
	private static ArrayList<Double> x; // list of values to be sorted
	
	/**
	 * Merge Sort for a list of doubles contained in an object of type Model. Returns a new 
	 * sorted list without modifying the list of values contained in the Model type object.
	 * @param model - the input object of type Model.
	 */
	public static ArrayList<Double> sort(Model model) {
		x = model.getValues(); 
		aux = new ArrayList<Double>();
		for (int i = 0; i < x.size(); i++) 
			aux.add(null);
		sort(x, 0, x.size()-1);
		
		return x;
	}
	
	/**
	 * Merge Sort for a list of doubles
	 * @param x - the list of values to be sorted.
	 */
	public static void sort(ArrayList<Double> x) {
		aux = new ArrayList<Double>();
		for (int i = 0; i < x.size(); i++) 
			aux.add(null);
		sort(x, 0, x.size()-1);
	}
	
	/******************************************************************************
	 * Helper function that sorts sub arrays using recursive calls and merges the
	 * sorted sub arrays.
	 ******************************************************************************/
	private static void sort(ArrayList<Double> x, int lo, int hi) {
		if (hi <= lo) return;
		int mid = lo + (hi - lo)/2;
		sort(x, lo, mid);
		sort(x, mid+1, hi);
		merge(x, lo, mid, hi);
	}
	
	/******************************************************************************
	 * Helper function that performs an abstract in-place merge.
	 ******************************************************************************/
	private static void merge (ArrayList<Double> x, int lo, int mid, int hi) {
		int i = lo, j = mid+1;
		
		for (int k = lo; k <= hi; k++) {
			aux.set(k, x.get(k));
		}
		
		for (int k = lo; k <= hi; k++) {
			if (i > mid) x.set(k, aux.get(j++));
			else if (j > hi) x.set(k, aux.get(i++));
			else if (less(aux.get(j), aux.get(i))) x.set(k, aux.get(j++));
			else x.set(k, aux.get(i++));
		}
	}
	
	/******************************************************************************
	 * Helper function that compares two values.
	 ******************************************************************************/
	private static boolean less (Double v, Double w ) {
		return v < w; 
	}

}


