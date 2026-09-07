package ArraysAndString.Formula;

import java.util.Scanner;

/**
 *
 * Given an array and values low and high
 * find the count of possible subarrays such that max of the subarray is greater than or equal to low
 * and less than or equal to high
 *
 * Approach 0
 * Generate all the subarray and
 * create a count variable
 * for each sub-array calculate max and check if max is in range increase the count
 * but this approach takes O(n^2) time and extra space
 *
 *
 * Approach 1
 * use two pointers start-index and end-index
 * create a count variable and previous-count variable
 * increment end index on each iteration
 * there will three possible scenario
 *  1 low <= arr[ei] <= high
 *       prevc = ei - si + 1
 *       count += prevc
 *  2. arr[ei] < low
 *      count += prevc
 *  3. arr[ei] > high
 *      prevc = 0
 *      si = ei + 1
 *
 *  this approach take O(n) time and constant space complexity
 *
 *  [2, 1, 4, 3]
 *  2
 *  4
 *  -> 9
 * [2, 1, 4, 3]
 *  2
 *  3
 *  -> 3
 */
public class NoOfSubarrayBounded {

    public  static int noOfSubarrayBounded(int[] arr, int low, int high){
        int count = 0;
        int prevc = 0;
        int si = 0;
        int ei = 0;
        while (ei < arr.length){
            if(low <= arr[ei] && arr[ei] <= high){
                prevc = ei - si + 1;
                count += prevc;
            }
            else if(arr[ei] < low){
                count += prevc;
            }
            else{
                si = ei + 1;
                prevc = 0;
            }
            ei++;
        }
        return count;
    }
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];

        for(int i=0; i<arr.length; i++){
            arr[i] = scn.nextInt();
        }

        int low = scn.nextInt();
        int high = scn.nextInt();

        int count = noOfSubarrayBounded(arr, low, high);

        System.out.println("Count of bounded subarray is " + count);
    }
}
