package ArraysAndString.MaxMin;

import java.util.Scanner;

/**
 *
 * Given an array with non-distinct elements give the maximum chucks required to sort the array
 * minimum chunks always - 1
 * max chunks != size of array as can't sort single element
 * same chaining but elements are non-distinct
 * example ()
 * [30 10 20 40 60 50 75 70] -> 4
 * [30 10 40 20 60 50 75 70] -> 3
 *
 * here maintain two array with left max and right min and where ever left max is less than index+1 right min then
 * increase the chunk count as that implies we have one chunk
 *
 * we can do with one array right min and left max variable
 */
public class MaximumChunksII {
    public static int maxChunks(int[] arr){
        int n = arr.length;
        int[] rightMin = new int[n+1];
        rightMin[n] = Integer.MAX_VALUE;
        for(int i=n-1; i>=0; i--){
            if(arr[i] < rightMin[i+1]){
                rightMin[i] = arr[i];
            }
            else{
                rightMin[i] = rightMin[i+1];
            }
        }

        int leftMax = Integer.MIN_VALUE;
        int count = 0;
        for(int i=0; i<arr.length; i++){
            leftMax = Math.max(leftMax, arr[i]);
            if(leftMax < rightMin[i+1]){
                count++;
            }
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

        int maxChunks = maxChunks(arr);
        System.out.println("max chunks to sort array " + maxChunks);
    }
}
