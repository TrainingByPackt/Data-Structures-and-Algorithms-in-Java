package com.packt.datastructuresandalg.lesson2.sorting;


public class BinarySearchRecursive {
    public boolean binarySearch(int x, int[] sortedNumbers) {
        return binarySearch(x, sortedNumbers, 0, sortedNumbers.length);
    }

    public boolean binarySearch(int x, int[] sortedNumbers, int start, int end) {
        if (start <= end) {
            int mid = (end - start) / 2 + start;
            if (sortedNumbers[mid] == x) return true;
            if (sortedNumbers[mid] > x)
                return binarySearch(x, sortedNumbers, start, mid - 1);
            return binarySearch(x, sortedNumbers, mid + 1, end);
        }
        return false;
    }

    public static void main(String args[]) {
        BinarySearchRecursive binarySearch = new BinarySearchRecursive();
        System.out.println(binarySearch.binarySearch(7, new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}));
        System.out.println(binarySearch.binarySearch(0, new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}));
    }

}
