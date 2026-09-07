package ArraysAndString.MaxMin;

import java.util.Scanner;

/**
 * Given a array we need to find the max possible product from subarray
 * Element can be -ve 0 or +ve
 *
 * Approach
 *
 * 1. Find every subarray and calculate the product and store the max of it
 * but this takes O(n^2) time complexity
 *
 * 2. Think that we will get max product either from the subarray from start or from end
 * +(ans) + -> if ans is +ve final answer is a*ans*b
 *  ->  if ans is -ve it cannot be max either a or b is ans
 * - (ans) + -> if ans is +ve final answer will be ans*b
 *  -> if ans is -ve final answer will be ans*a
 * +(ans)- -> if ans is +ve final answer will be ans*a
 *   -> if ans is -ver final answer will be ans*b
 * -(ans)- -> if ans is +ve final answer is ans
 *  -> if ans is -ve final answer is maxOf(a*ans, b*ans)
 *
 *  so we can say answer will be either start from first and some subarray or start from last and subaary
 *
 *  Note whenever we encounter we will reset the product value as 1 as zero will make product as zero
 *
 */
public class MaxProductSubarray {
    public static int subarrayMaxProduct(int[] arr){
        int maxProduct = Integer.MIN_VALUE;
        int p = 1;
        //left to right max subarray product
        for(int i=0;i<arr.length; i++){
            p *= arr[i];
            maxProduct = Math.max(maxProduct, p);
            if(p == 0){
                p = 1;
            }
        }
        p = 1;
        // right to left max subarray product
        for(int i=arr.length - 1; i>=0; i--){
            p*= arr[i];
            maxProduct = Math.max(maxProduct, p);
            if(p == 0){
                p = 1;
            }
        }
        return maxProduct;
    }
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];

        for(int i=0; i<arr.length; i++){
            arr[i] = scn.nextInt();
        }

        int maxProduct = subarrayMaxProduct(arr);
        System.out.println("Subarray max product is " + maxProduct);
    }
}
