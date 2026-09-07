package ArraysAndString.MaxMin;

import java.util.Scanner;

public class ShortestUnsortedSubarray {
    /**
     * need to find size of the shorted subarray sorting which will give make array sorted
     *
     * example [ 2 3 6 4 5 9 8 10 12]
     * here sorting 6,4,5,9,8 will give make array sorted
     * so the size of that subarray is 5
     * [2 6 4 8 10 9 15] -> 5
     *
     */

    public static int sortedUnsortedSubArray(int[] arr){
        int end = -1;
        int max = arr[0];
        for(int i=1; i<arr.length; i++){
            if(max > arr[i]){
                end = i;
            }else {
                max = arr[i];
            }
        }
        int st = 0;
        int n = arr.length - 1;
        int min = arr[n-1];
        for(int i = n-2; i>=0; i--){
            if(min < arr[i]){
                st = i;
            }
            else{
                min = arr[i];
            }
        }
        return end - st + 1;
    }
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];

        for(int i=0; i<arr.length; i++){
            arr[i] = scn.nextInt();
        }

        System.out.println("Size of subarray sorting which will give sorted array " + sortedUnsortedSubArray(arr));
    }
}
