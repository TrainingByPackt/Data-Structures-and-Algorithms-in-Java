package com.packt.datastructuresandalg.lesson2.activity.selectionsort;

public class SelectionSort {

    public void sort(int[] array) {
        // the index of the minimum value
		int minIndex = -1;
		
		// perform the operation n-1 times
		for(int k = 0; k < arr.length; k++) {
			// initial minimum value
			int min = Integer.MAX_VALUE;
			//loop through the values of the unsorted partition
			for(int i = k; i < arr.length; i++) {
				min = Math.min(min, arr[i]);
				//update the index of the minimum value in the array
				if(min == arr[i]) {
					minIndex = i;
				}
			}
			//swap
			int temp = arr[k];
			arr[k] = arr[minIndex];
			arr[minIndex] = temp;
		}
    }
}
