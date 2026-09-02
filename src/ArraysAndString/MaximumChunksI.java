package ArraysAndString;

import java.util.Scanner;

/**
 *
 * Given an array with distinct elements give the maximum chucks required to sort the array
 * minimum chunks always - 1
 * max chunks != size of array as can't sort single element
 * use the chaining technique
 * example
 * [3 2 1 0 5 4 6 7 9 8] -> 5
 * [3 2 1 0 5 6 4 7 9 8] -> 4
 * [3 2 1 0 5 6 4 8 9 7] -> 3
 *
 */
public class MaximumChunksI {
    public static int maxChunks(int[] arr){
        int maxChunk = 0;
        int count = 0;
        for(int i=0; i<arr.length; i++){
            maxChunk = Math.max(maxChunk, arr[i]);
            if(maxChunk == i){
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
