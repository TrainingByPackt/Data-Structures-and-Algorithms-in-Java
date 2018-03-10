package com.packt.datastructuresandalg.lesson4.activity.maxsubarray.solution;

public class MaximumSubarray {
    public int maxSubarrayCross(int[] a, int l, int m, int h) {
        int leftSum = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = m; i >= l; i--) {
            sum += a[i];
            if (sum > leftSum)
                leftSum = sum;
        }
        int rightSum = Integer.MIN_VALUE;
        sum = 0;
        for (int i = m + 1; i <= h; i++) {
            sum += a[i];
            if (sum > rightSum)
                rightSum = sum;
        }
        return leftSum + rightSum;
    }

    public int maxSubarrayAux(int[] a, int l, int h) {
        if (l == h)
            return a[l];
        else {
            int m = (l + h) / 2;
            int bl = maxSubarrayAux(a, l, m);
            int br = maxSubarrayAux(a, m + 1, h);
            int bc = maxSubarrayCross(a, l, m, h);
            int best = Math.max(Math.max(bl, br), bc);
            return best;
        }
    }

    public Integer maxSubarray(int[] a) {
        return maxSubarrayAux(a, 0, a.length - 1);
    }

    public static void main(String[] args) {
        int[] a = {13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7};
        MaximumSubarray maxSubarray = new MaximumSubarray();
        System.out.println("Maximum subarray = " + maxSubarray.maxSubarray(a));
    }
}
