package ArraysAndString.MaxMin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * General Element
 * Find the list of elements which are majority elements if element appears more than n/k in an array (n is the size of array)
 * k is given input
 * here since k can be dynamic we will use hashmap here
 * HashMap will take extra max O(n) space but time complexity is same
 * we were using pairing and creating triplets for less space complexity
 *
 */
public class MajorityElementIII {
    public static ArrayList<Integer> majorityElement(int[] arr, int k){
        HashMap<Integer, Integer> freqMp = new HashMap<>();
        for(int val: arr){
            freqMp.put(val, freqMp.getOrDefault(val,0) + 1);
        }

        ArrayList<Integer> res = new ArrayList<>();
        int n = arr.length;
        for(int key: freqMp.keySet()){
            int val = freqMp.get(key);
            System.out.println("key " +key + " val " + val);
            if(val > n/k){
                res.add(key);
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
        int k = scn.nextInt();

        ArrayList<Integer> res = majorityElement(arr, k);

        System.out.println("majority elements for more than " + (int)(arr.length/k) + " time : ");
        for(int val: res){
            System.out.print(val + " ");
        }
    }
}
