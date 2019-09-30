package com.packt.datastructuresandalg.lesson2.activity.selectionsort;

public class SelectionSort {

    public void sort(int[] array) {
        int small_index, temp=0;
        for(int i=0  ; i<array.length ; i++)
        {
            small_index=i;
            for(int j=i+1 ; j<array.length ; j++)
            if(array[j]<array[small_index])
            small_index=j;
            
            temp=array[i];
            array[i]=array[small_index];
            array[small_index]=temp;
        }
    }
}
