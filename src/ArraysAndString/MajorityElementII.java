package ArraysAndString;


import java.util.ArrayList;
import java.util.Scanner;

/**
 * Find the list of elements which are majority elements if element appears more than n/3 in an array (n is the size of array)
 * here max 2 element can be majority element
 *
 * (Think of something like pairing) similar as MajorityElementI but here we need to create a combination of unique three elements
 *
 */
public class MajorityElementII {
    public static ArrayList<Integer> findMajority2(int[] arr){
        int val1 = arr[0];
        int count1 = 1;
        int val2 = arr[0];
        int count2 = 0;

        for(int i=1; i<arr.length; i++){
            if(arr[i] == val1){
                count1++;
            }else if(arr[i] == val2){
                count2++;
            }
            else{
                if(count1 == 0){
                    val1 = arr[i];
                    count1 = 1;
                }else if(count2 == 0){
                    val2 = arr[i];
                    count2 = 1;
                }else {
                    count1--;
                    count2--;
                }
            }
        }

        count1 = 0;
        count2 = 0;
        for(int i=0; i<arr.length; i++){
            if(arr[i] == val1){
                count1 ++;
            }
            else if(arr[i] == val2){
                count2++;
            }
        }

        int n = arr.length;
        ArrayList<Integer> res = new ArrayList<>();
        if(count1 > n/3){
            res.add(val1);
        }
        if(count2 > n/3){
            res.add(val2);
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

        ArrayList<Integer> res = findMajority2(arr);

        System.out.println("Majority elements are : ");
        for(int val: res){
            System.out.print(val + " ");
        }
    }
}
