package ArraysAndString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 *
 * Extend target sum triplet use target sum triplet
 * Iterate on array and get all the unique triplet for the give value to match condition
 * with all the triplets form our quadruple
 *
 */
public class FourSumQuadruple {
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
    public static List<List<Integer>> targetSumTriplet(int[] arr, int st, int tar){
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=st; i<=arr.length - 3; i++){
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
    public static List<List<Integer>> fourSum(int[] arr, int tar){
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(arr);

        if(arr.length < 4){
            return ans;
        }

        for(int i=0; i<=arr.length - 4; i++){
            if(i!=0 && arr[i] == arr[i-1]){
                continue;
            }
            int val1 = arr[i];
            int tar3 = tar - val1;
            List<List<Integer>> tans = targetSumTriplet(arr, i+1, tar3);
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

        List<List<Integer>> ans = fourSum(arr, target);

        for(List<Integer> l: ans){
            System.out.print(l + " ");
        }
    }
}
