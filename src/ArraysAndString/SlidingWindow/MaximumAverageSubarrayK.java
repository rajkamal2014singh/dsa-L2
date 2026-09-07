package ArraysAndString.SlidingWindow;

import java.util.Scanner;

/**
 *
 * Given an array and a value k(size of subarray)
 * we need to find the maximum average of subarray of size k
 *
 * Approach 0
 * For every subarray of size k calculate sum and check if it has max average or not
 * Time Complexity - O(n^2)
 *
 * Approach 1
 * Use sliding window approach
 * For first k elements calculate sum and then move/slid the window to next i.e., calculate sum of
 * next subarray of size k by adding current value and removing the value which is not part of subarray
 * also maintain the max subarray sum so far
 *
 * example -> [-10 5 6 8 -7 2 -4 8 -6 7], k = 3 -> 6
 * [-10 5 -6 8 -7 2 -4 8 -6 7], k = 3 -> 3
 */
public class MaximumAverageSubarrayK {
    public static int maximumAverageSubarrayK(int[] nums, int k){
        int currentSum = 0;
        int maxSum = Integer.MIN_VALUE;

        for(int i=0; i<nums.length; i++){
            if(i < k){
                currentSum += nums[i];
            }
            else{
                currentSum = currentSum + nums[i] - nums[i-k];
            }

            maxSum = Math.max(maxSum, currentSum);
        }

        System.out.println("Max sum " + maxSum);
        return maxSum/k;
    }
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];

        for(int i=0; i<arr.length; i++){
            arr[i] = scn.nextInt();
        }
        int k = scn.nextInt();
        int maxAverage = maximumAverageSubarrayK(arr, k);

        System.out.println("Maximum average for subarray of size " + k + " is " + maxAverage);
    }
}
