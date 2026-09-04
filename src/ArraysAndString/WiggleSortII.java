package ArraysAndString;

import java.util.Arrays;
import java.util.Scanner;

public class WiggleSortII {
    /**
     *
     * Given an array sort it in such a way that if array is
     * [a1 a2 a3 a4 a5 ....an]
     * after sorting or reordering the array looks such that
     *
     * a1 < a2 > a3 < a4 > a5.... so on
     * so if we observe that odd index greater than even nearby indexes
     *
     * Approach
     * swap values proactively if at even index check if it is greater than next index swap
     * in case of odd index check if value is less than next index swap the value in that case
     *
     * time complexity O(n) with space as O(1)
     * this is the most efficient approach
     *
     * we can think of other approach where we sort the array and create a new array and on odd indexes put values from
     * last and on the even put the remaining values
     * this approach takes time complexity of O(n*log(n)) and space extra O(n)
     * [9 5 6 8 6 4] -> [5 9 6 8 6]
     *
     */

    public static void wiggleSort(int[] arr){
        Arrays.sort(arr);
        int[] help = new int[arr.length];
        int j = arr.length - 1;
        int i = 1;
        while(i<arr.length){
            help[i] = arr[j];
            i += 2;
            j--;
        }
        i = 0;
        while(i<arr.length){
            help[i] = arr[j];
            i+=2;
            j--;
        }

        for(i=0; i<arr.length; i++){
            arr[i] = help[i];
        }
    }
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];

        for(int i=0; i<arr.length; i++){
            arr[i] = scn.nextInt();
        }

        System.out.println("Array before wiggle sort");
        for (int j : arr) {
            System.out.print(j + " ");
        }
        wiggleSort(arr);
        System.out.println();
        System.out.println("Array after wiggle sort");
        for (int j : arr) {
            System.out.print(j + " ");
        }
    }
}
