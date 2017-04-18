package com.chandresh.practice.programs.designPatterns.creational;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
//IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
//SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
//DEFINE ANY CLASS AND METHOD NEEDED
//CLASS BEGINS, THIS CLASS IS REQUIRED

public class FrequencySort {
	// METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
	public static int[] frequenySortArray(int arr[]) {
		int[] result = new int[arr.length];
		if (arr == null)
			return result;

		Map<Integer, Integer> inpMap = new HashMap<Integer, Integer>();
		for (int i = 0; i < arr.length; i++) {
			if (inpMap.get(arr[i]) != null) {
				inpMap.put(arr[i], inpMap.get(i) + 1);
			} else {
				inpMap.put(arr[i], 1);
			}
		}
		
		TreeMap<Integer, List<Integer>> sortInp = new TreeMap<Integer, List<Integer>>();
		for (Entry<Integer, Integer> each : inpMap.entrySet()) {
			if (sortInp.get(each.getValue()) != null) {
				List<Integer> temp = sortInp.get(each.getValue());
				temp.add(each.getKey());
				sortInp.put(each.getValue(), temp);
			} else {
				List<Integer> temp = new ArrayList<Integer>();
				temp.add(each.getKey());
				sortInp.put(each.getValue(), temp);
			}
		}

		sortInp.descendingMap();
		int counter = 0;
		for (Entry<Integer, List<Integer>> each : sortInp.entrySet()) {
			List<Integer> l = each.getValue();
			for (int i = 0; i < l.size(); i++) {
				for (int j = 0; j < each.getKey(); j++) {
					result[counter] = l.get(i);
					counter++;
				}
			}
		}
		return result;

	}
	// METHOD SIGNATURE ENDS
	static int i;
	public static void main(String args[]){
		
		while(i<0){
			i--;
		}
		int[] c = {1};
		c[13] = 1;
		System.out.println(c[1]);
		int[] arr = {1,2,3,4,1};
		 int[] result = FrequencySort.frequenySortArray(arr);
		 System.out.println(result.length);
		 
		 for(Integer e:result){
			 System.out.println(e);
		 }
	}

}