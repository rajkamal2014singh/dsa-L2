package ArraysAndString;

import java.util.Scanner;

/**
 * Same question as partitionArrayIntoDisjointInterval_I
 * but that approach took time complexity of O(n) and extra space of O(n)
 *
 * will here try to solve it without extra space
 * maintain a greater variable and a leftMax and ans
 * here greater stores the max value till now
 * leftMax contains the max value of first partition/interval
 * ans contains the index at which first partition can be done
 *
 * so two conditions
 * if(arr[i] > greater){
 *      greater = arr[i];
 * } else if(arr[i] < leftMax){
 *     leftMax = greater;
 *     ans = i;
 * }
 *
 *  * [30 10 20 40 60 50 75 70] -> 3 as 2nd index is the spot
 *  * [30 10 40 20 60 50 75 70] -> 4 as 3rd index is the spot
 *
 */
public class PartitionArrayIntoDisjointInterval_II {
    public static int partitionArrayIntoDisjointInterval(int[] arr){
        int n = arr.length;
        int ans = 0;
        int leftMax = arr[0];
        int greater = arr[0];

        for(int i=0; i<arr.length; i++){
            if(arr[i] > greater){
                greater = arr[i];
            }
            else if(arr[i] < leftMax){
                leftMax = greater;
                ans = i;
            }
        }

        return ans + 1;
    }

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];

        for(int i=0; i<arr.length; i++){
            arr[i] = scn.nextInt();
        }

        System.out.println("Array disjoint interval is " + partitionArrayIntoDisjointInterval(arr));
    }
}
