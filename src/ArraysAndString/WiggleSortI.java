package ArraysAndString;

import java.util.Scanner;

/**
 *
 * Given an array sort it in such a way that if array is
 * [a1 a2 a3 a4 a5 ....an]
 * after sorting or reordering the array looks such that
 *
 * a1 <= a2 >= a3 <= a4 >= a5.... so on
 * so if we observe that odd index greater than even nearby indexes
 *
 * Approach
 * swap values proactively if at even index check if it is greater than next index swap
 * in case of odd index check if value is less than next index swap the value in that case
 *
 * time complexity O(n) with space as O(1)
 *
 * [9 5 6 8 6 4] -> [5 9 6 8 6]
 *
 */
public class WiggleSortI {
    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void wiggleSort(int[] arr){
        for(int i=0; i<arr.length - 1; i++){
            if(i % 2 == 0){
                if(arr[i] > arr[i+1]){
                    swap(arr, i, i+1);
                }
            }
            else{
                if(arr[i] < arr[i+1]){
                    swap(arr, i, i+1);
                }
            }
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
