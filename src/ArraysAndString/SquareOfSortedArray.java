package ArraysAndString;

import java.util.Scanner;

/**
 *
 * Find of the square of sorted array, result should be also sorted as well
 * Input can contain -ve numbers as well
 *
 * Approach 1 - Square the elements than sort the array, but it takes time of O(n*log(n)) we want it in O(n)
 * for O(n) we can use extra space
 * if no extra space it will take O(n*log(n))
 *
 */
public class SquareOfSortedArray {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];

        for(int i=0; i<arr.length; i++){
            arr[i] = scn.nextInt();
        }

        squareOfSorted(arr);
    }

    public static void squareOfSorted(int[] arr){
        int i = 0;
        int j = arr.length - 1;
        int k = arr.length - 1;
        int [] res = new int[k + 1];

        while(i<=j){
            int val1 = arr[i]*arr[i];
            int val2 = arr[j]*arr[j];

            if(val1 < val2){
                res[k] = val2;
                j--;
            }
            else{
                res[k] = val1;
                i++;
            }
            k--;
        }

        System.out.println("Sorted array is : ");
        for(i=0; i<res.length; i++){
            System.out.print(res[i] + " ");
        }
    }
}
