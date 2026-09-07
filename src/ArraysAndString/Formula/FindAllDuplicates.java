package ArraysAndString.Formula;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * Give an array find the list of all the duplicate values.
 * values are in [1, n]
 *
 * Approach 0
 * - Select an element and check if it is present again or not - O(n^2)
 * Approach 1
 * - Sort the array and check if prev value is equal to current or not or next value any one - O(n*log(n))
 * Approach 2
 * - Since we know that value will be 1 to n
 * that means index 0 represents value 1
 * will we go on every value and mark there valid index valid as -ve if value is already -ve then value is duplicate
 * add that to list and return it
 *
 * 9
 * 5 6 2 3 5 8 2 3 7
 *
 */
public class FindAllDuplicates {
    public static List<Integer> findDuplicates(int[] arr){
        List<Integer> ans = new ArrayList<>();

        for(int i=0; i<arr.length; i++){
            int idx = Math.abs(arr[i]) - 1;

            if(arr[idx] < 0){
                ans.add(idx+1);
            }else{
                arr[idx] *= -1;
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

        List<Integer> dup = findDuplicates(arr);

        System.out.println("Duplicate values in array are : ");
        for (int d: dup){
            System.out.print(d + " ");
        }
    }
}
