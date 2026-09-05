package ArraysAndString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Given an array consisting of numbers and a target value find triplet whose sum is equal to target
 * build it on the top of target sum pairs
 * sort the array
 * for every element get the target sum pair for remaining sum and then add the current element to list
 *
 *
 13
 [2 2 4 3 1 6 6 7 5 9 1 8 9]
 8
 */
public class ThreeSumTriplet {
    public static List<List<Integer>> targetSumPair(int[] arr, int st, int tar){
        List<List<Integer>> res = new ArrayList<>();
        int left = st;
        int right = arr.length - 1;
        while(left < right){
            if(left != st && arr[left] == arr[left-1]){
                left++;
                continue;
            }
            int sum = arr[left] + arr[right];
            if(sum == tar){
                List<Integer> sans = new ArrayList<>();
                sans.add(arr[left]);
                sans.add(arr[right]);
                res.add(sans);
                left++;
                right--;
            }
            else if(sum > tar){
                right--;
            }
            else{
                left++;
            }
        }

        return res;
    }
    public static List<List<Integer>> targetSumTriplet(int[] arr, int tar){
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(arr);
        for(int i=0; i<=arr.length - 3; i++){
            if(i!=0 && arr[i] == arr[i-1]){
                continue;
            }
            int val1 = arr[i];
            int tar2 = tar - val1;
            List<List<Integer>> tans = targetSumPair(arr, i+1, tar2);
            for(List<Integer> l1 : tans){
                l1.add(val1);
                ans.add(l1);
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
        int target = scn.nextInt();

        List<List<Integer>> ans = targetSumTriplet(arr, target);

        for(List<Integer> l: ans){
            System.out.print(l + " ");
        }
    }
}
