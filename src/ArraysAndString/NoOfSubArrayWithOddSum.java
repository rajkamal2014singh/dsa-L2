package ArraysAndString;

import java.util.Scanner;

/**
 *
 * Given an array containing numbers we need to find the count of subarrays whose sum is odd
 *
 * Approach 0
 * Find all the subarrays and calculate there sum whose so ever sum is odd increment the count
 *
 * Approach 1
 * we know odd = even + odd
 * so odd = odd - even or odd = even - odd
 * we will use this logic
 * we will calculate prefix sum and will also keep count of no of odd and evens
 * based on that we will create our answer
 *
 *
 */

public class NoOfSubArrayWithOddSum {
    public static int countOddSumSubArray(int[] arr){
        int ans = 0;
        int even = 0;
        int odd = 0;
        int sum = 0;

        for(int val : arr){
            sum += val;

            if(sum % 2 == 0){
                // even
                // at this position sum will make (this even will make odd no of subarray)
                ans += odd;
                even++;
            }
            else{
                ans += even + 1;
                odd++;
            }
        }

        return ans;
    }
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];

        for(int i=0; i<arr.length; i++){
            arr[i] = scn.nextInt();
        }
    }
}
