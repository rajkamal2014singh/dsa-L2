package ArraysAndString.TwoPointer;

import java.util.Scanner;

/**
 *
 * Given an array and sum value need to calculate the minimum size of subarray that have sum equal to or greater than
 * sum value
 *
 * Approach 0
 * Create all the possible subarray and calculate the sum and check the subarray that satisfies the sum condition
 * among those subarrays get the one with the smallest size
 * Time Complexity - O(n^2)
 *
 * Approach 1
 * Use two pointers start and end and a sum variable and minLen value
 * calculate minLen by end - start + 1
 * when sum >= target check for len and recalculate sum and move start pointer
 * If no such subarray return value as 0.
 * Time Complexity - O(n)
 *
 * Example
 * [1 4 2 2 1 4], sum = 5 -> 2
 * [1 2 5 3 4 1 6], sum = 7 -> 2
 */
public class MinimumSizeSubarraySum {
    public static int minSizeSubarray(int[] arr, int sum){
        int st = 0;
        int end = 0;
        int minLen = Integer.MAX_VALUE;
        int currentSum = 0;
        while(end < arr.length){
            currentSum += arr[end];

            while (currentSum >= sum){
                int len = end - st + 1;
                if(len < minLen){
                    minLen = len;
                }
                currentSum -= arr[st];
                st++;
            }

            end++;
        }

        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];

        for(int i=0; i<arr.length; i++){
            arr[i] = scn.nextInt();
        }
        int sum = scn.nextInt();
        int subArrayLength = minSizeSubarray(arr, sum);

        if(subArrayLength == 0){
            System.out.println("No subarray sum possible for " + sum);
        }
        else{
            System.out.println("Size of min subarray that have sum equal to " + sum + " is " + subArrayLength);
        }
    }
}
