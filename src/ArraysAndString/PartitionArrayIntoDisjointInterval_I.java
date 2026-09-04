package ArraysAndString;

import java.util.Scanner;

/**
 *
 * Given an array with non-distinct elements give the first index where we can split the array such that first interval
 * after sorting is sorted (Approach is fully similar as MaximumChunksII but here need to give the first index of chunk pt)
 *
 * same chaining but elements are non-distinct
 * example ()
 * [30 10 20 40 60 50 75 70] -> 3 as 2nd index is the spot
 * [30 10 40 20 60 50 75 70] -> 4 as 3rd index is the spot
 *
 * here maintain two array with left max and right min and where ever left max is less than index+1 right min then we
 * found the index first such instance gives the point where we can split the array
 *
 * we can do with one array right min and left max variable
 */
public class PartitionArrayIntoDisjointInterval_I {
    public static int partitionArrayIntoDisjointInterval(int[] arr){
        int n = arr.length;
        int[] rightMin = new int[n+1];
        rightMin[n] = Integer.MAX_VALUE;
        for(int i = n-1; i>=0; i--){
            rightMin[i] = Math.min(rightMin[i+1], arr[i]);
        }

        int leftMax = Integer.MIN_VALUE;
        int ans = 0;
        for(int i=0; i<arr.length; i++){
            leftMax = Math.max(leftMax, arr[i]);
            if(leftMax < rightMin[i+1]){
                ans = i;
                break;
            }
        }

        return ans + 1;
    }

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];

        for(int i=0; i<arr.length; i++){
            arr[i] = scn.nextInt();
        }

        System.out.println("Array disjoint interval is " + partitionArrayIntoDisjointInterval(arr));
    }
}
