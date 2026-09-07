package ArraysAndString.MaxMin;

import java.util.Scanner;

/**
 * Element is a majority element if element appears more than n/2 in an array (n is the size of array)
 * here max one element can be majority element
 *
 * We can think of doing this with the help of hashmap by stroring the frequency of the element and then again
 * traversing the hashmap and check if the element is having freq greater than n/2
 * this will take extra O(n) space
 * we want solution without extra space
 *
 * (Think of something like pairing)
 * in case of pairing if an element is paired with other element, then it is not a potenential majority element
 * give change to the current element if its freq is 0 think in that way
 * this approach takes no extra space first finds potential candidate and then we can confirm
 *
 */
public class MajorityElementI {
    public static int findPotential(int[] arr){
        int val = arr[0];
        int count = 1;

        for(int i=1; i<arr.length; i++){
            if(arr[i] == val){
                count++;
            }
            else{
                count--;
            }

            if(count == 0){
                val = arr[i];
                count = 1;
            }
        }

        return val;
    }

    public  static void findMajority(int[] arr){
        int potential = findPotential(arr);
        int count = 0;
        for(int i=0; i<arr.length; i++){
            if(arr[i] == potential){
                count++;
            }
        }

        if(count > arr.length/2){
            System.out.println("Majority element is " + potential);
        }
        else{
            System.out.println("No majority element");
        }
    }

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];

        for(int i=0; i<arr.length; i++){
            arr[i] = scn.nextInt();
        }

        findMajority(arr);
    }
}
