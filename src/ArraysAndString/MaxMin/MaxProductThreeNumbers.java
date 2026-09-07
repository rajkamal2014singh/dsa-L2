package ArraysAndString.MaxMin;

import java.util.Scanner;

public class MaxProductThreeNumbers {
    /**
     *  when thinking of max product we think of having max top three values and calculate the value
     *  but this holds true only when all numbers are positive
     *  remember product two negative numbers make positive number
     *
     *  so to solve this we need to check if product of two negative smallest number is it greater than our
     *  max2 and max3 or not if yes answer might be different
     *
     *
     * [2 3 4 10 -7 9 2 -8] -> 560
     *  so result is maxOf(max1*min1*min2, max1*max2*max3)
     *
     */

    public static int productOfThreeNumbers(int[] arr){
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;

        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;

        for(int i=0; i<arr.length; i++){
            /* calculate the min value */
            if(arr[i] < min1){
                min2 = min1;
                min1 = arr[i];
            }else if(arr[i] < min2){
                min2 = arr[i];
            }

            /* calculate the max value */
            if(arr[i] > max1){
                max3 = max2;
                max2 = max1;
                max1 = arr[i];
            }else if(arr[i] > max2){
                max3 = max2;
                max2 = arr[i];
            }else if(arr[i] > max3){
                max3 = arr[i];
            }
        }

        return Math.max(max1*min1*min2, max1*max2*max3);
    }
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];

        for(int i=0; i<arr.length; i++){
            arr[i] = scn.nextInt();
        }

        System.out.println("Max product of three numbers is " + productOfThreeNumbers(arr));
    }
}
