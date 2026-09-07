package ArraysAndString.PatternMatching;

import java.util.Scanner;

/**
 *  In a given array which can contain negative number find the fist missing positive no
 *
 *  Approach 0
 *  Start from 1 and check if it is present or not check like this for 2 and so on till you find any if not than n+1 is number
 *  time complexity - O(n^2)
 *
 *  Approach 1
 *  Sort the array go till +ve number check whichever no is missing
 *  time complexity - O(n*log(n))
 *
 *  Appraoch 2
 *  keep a flag if one is present or not and also for the element out of bound update there value to 1
 *  for each value(absolute) go and mark there index as -ve value if that is(map index)
 *  positive
 *  iterate and check whichever first index value is positive that index+1 value is missing
 *  time complexity - O(n) Space - O(1)
 *
 *  [9 2 3 4 5 1] -> 6
 *  [9 2 3 4 5 1 7 6 -3 10] -> 8
 */
public class FirstMissingPositiveNo {

    public static int findFirstMissingNo(int[] arr){
        int n = arr.length;
        boolean one = false;
        //mark elements which are out of range
        for(int i=0; i<arr.length; i++){
            if(arr[i] == 1){
                one = true;
            }
            if(arr[i]< 1 || arr[i] > n){
                arr[i] = 1;
            }
        }
        if(one == false){
            return 1;
        }

        //map the indexes
        for(int i=0; i<n; i++){
            int idx = Math.abs(arr[i]);
            arr[idx - 1] = -Math.abs(arr[idx - 1]);
        }
        //find the missing no
        for(int i=0; i<n; i++){
            if(arr[i] > 0){
                return i+1;
            }
        }

        return n+1;
    }
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];

        for(int i=0; i<arr.length; i++){
            arr[i] = scn.nextInt();
        }

        int missing = findFirstMissingNo(arr);

        System.out.println("First missing positive no is " + missing);
    }
}
