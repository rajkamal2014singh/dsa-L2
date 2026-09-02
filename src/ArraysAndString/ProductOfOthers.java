package ArraysAndString;

import java.util.Scanner;

/**
 * Given an array return an array such that index at i contains product of all the elements in array except element at i
 * Example
 * [4 5 1 2 3] -> [30 24 120 60 40]
 * [4 5 0 2 3] -> [0 0 120 0 0]
 * [4 5 0 3 0] -> [0 0 0 0 0]
 *
 *
 * two approaches
 * 1. use extra space O(n) maintain two array left and right product and calculate for the product
 *      one array and one variable with left product
 * 2. count of zero -> if count greater than 1 all elements zero
 *      if one zero calculate product without zero(for zero value index) and for others put zero
 *      if no zero divide the product with current index value
 */
public class ProductOfOthers {

    public static int[] productOfValues(int[] arr){
        int n = arr.length;
        int[] res = new int[n];
        int[] right = new int[n];
        int left = 1;

        right[n-1] = arr[n-1];
        for(int j=n-2; j>=0;j--){
            right[j] = arr[j]*right[j+1];
        }

        for(int i=0; i<n; i++){
            if(i==n-1){
                res[i] = left;
            }
            else{
                res[i] = left * right[i+1];
            }
            left = left * arr[i];
        }

        return res;
    }

    public static int[] productOfValues1(int[] arr){
        int zc = 0;
        int zi = -1;
        int product = 1;
        for(int i=0; i<arr.length; i++){
            if(arr[i] == 0){
                zc++;
                zi = i;
            }
            else{
                product = product * arr[i];
            }
        }

        int n = arr.length;
        int[] res = new int[n];
        if(zc > 1){
            return res;
        }
        if(zc == 1){
            res[zi] = product;
        }
        else{
            for(int i=0; i<arr.length; i++){
                res[i] = product/arr[i];
            }
        }

        return res;
    }

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];

        for(int i=0; i<arr.length; i++){
            arr[i] = scn.nextInt();
        }

        System.out.println("Result of product is : ");
        int[] res1 = productOfValues(arr);
        for (int val: res1){
            System.out.print(val + " ");
        }

        System.out.println();
        int[] res2 = productOfValues1(arr);
        for (int val: res2){
            System.out.print(val + " ");
        }
    }
}
