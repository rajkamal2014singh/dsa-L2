package ArraysAndString.Sum;

import java.util.*;

/**
 *
 * Given an array consisting of numbers and a target value find unique pairs whose sum is equal to target
 *
 * Approach
 * 1-> sort the array and use two pointers one at left and one at right
 * calculate the sum and move the pointer based on the sum we got
 * this approach takes O(n*log(n)) time and no extra space
 *
 * 2-> use hashmap to store the values and there frequency
 * check for remaining values for each value if matches remove both the keys as we want unique value
 *
 13
 [2 2 4 3 1 6 6 7 5 9 1 8 9], 10
 */
public class TwoSumPair {
    public static List<List<Integer>> targetSumPair(int[] arr, int tar){
        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(arr);
        int l = 0;
        int r = arr.length - 1;
        while (l<r){
            if(l!=0 && arr[l] == arr[l-1]){
                l++;
                continue;
            }

            int sum = arr[l] + arr[r];
            if(sum == tar){
                List<Integer> sans = new ArrayList<>();
                sans.add(arr[l]);
                sans.add(arr[r]);
                res.add(sans);
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

        return res;
    }
    public static List<List<Integer>> targetSumPairHash(int[] arr, int tar){
        List<List<Integer>> ans = new ArrayList<>();
        HashMap<Integer, Integer> mp = new HashMap<>();

        for(int i=0; i<arr.length; i++){
            mp.put(arr[i], mp.getOrDefault(arr[i], 0) + 1);
        }

        for(int i=0; i<arr.length; i++){
            int rem = tar - arr[i];
            if(mp.containsKey(rem)){
                List<Integer> rans = new ArrayList<>();
                if(rem == arr[i] && mp.get(rem) > 1){
                    rans.add(arr[i]);
                    rans.add(arr[i]);
                    ans.add(rans);
                    mp.remove(rem);
                }
                else if (rem != arr[i]){
                    rans.add(rem);
                    rans.add(arr[i]);
                    ans.add(rans);
                    mp.remove(rem);
                    mp.remove(arr[i]);
                }
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

        List<List<Integer>> ans = targetSumPair(arr, target);
        List<List<Integer>> ansh = targetSumPairHash(arr, target);

        System.out.println("From array");
        for(List<Integer> l: ans){
            System.out.print(l + " ");
        }
        System.out.println();
        System.out.println("From hashmap");
        for(List<Integer> l: ansh){
            System.out.print(l + " ");
        }
    }
}
