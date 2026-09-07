package ArraysAndString.Sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 *
 * Similar as 3sum and 4sum but here k can be any value
 * So think of iterative solution and keep 2sum as base condition
 * Sort the array
 * create a recursive helper function
 * create a base condition for 2 size
 */
public class KSumUniqueSet {
    public static List<List<Integer>> twoSum(int[] arr, int si, int tar){
        List<List<Integer>> ans = new ArrayList<>();
        int l = si;
        int r = arr.length - 1;
        while(l < r){
            if(l!=si && arr[l]==arr[l-1]){
                l++;
                continue;
            }

            int sum = arr[l] + arr[r];
            if(sum == tar){
                List<Integer> bans = new ArrayList<>();
                bans.add(arr[l]);
                bans.add(arr[r]);
                ans.add(bans);
                l++;
                r--;
            }
            else if(sum > tar){
                r--;
            }
            else{
                l++;
            }
        }
        return ans;
    }
    public static List<List<Integer>> kSumHelper(int[] arr, int tar, int k, int si){
        if(k==2){
            return twoSum(arr, si, tar);
        }
        int n = arr.length;
        List<List<Integer>> res = new ArrayList<>();
        if(n-k < 0){
            return res;
        }

        for(int i=si; i<=n-k; i++){
            if(i!=si && arr[i] == arr[i-1]){
                continue;
            }
            List<List<Integer>> sans = kSumHelper(arr, tar - arr[i], k- 1, i+1);
            for(List<Integer> l: sans){
                l.add(arr[i]);
                res.add(l);
            }
        }
        return res;
    }
    public static List<List<Integer>> kSum(int[] arr, int tar, int k){
        Arrays.sort(arr);
        return kSumHelper(arr, tar, k, 0);
    }
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];

        for(int i=0; i<arr.length; i++){
            arr[i] = scn.nextInt();
        }

        int tar = scn.nextInt();
        int k = scn.nextInt();

        List<List<Integer>> ans = kSum(arr, tar, k);

        System.out.println("Target sum for " + k + " with target " + tar + " is ");
        for(List<Integer> l: ans){
            System.out.print(l);
        }
    }
}
