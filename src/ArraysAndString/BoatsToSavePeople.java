package ArraysAndString;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * Given a list of people with there weights
 * A boat can at max carry two people
 * find minimum no of rounds boat need to save all people
 * capacity of boat is always greater than the max weight from the list of people
 *
 * Approach 0
 * For each element check if with what max we can pair up
 * here we will need to maintain extra array that this person have already crossed the river
 * time complexity O(n^2) and extra space as well
 *
 * Approach 1
 * Same as target sum
 * Sort the arrays
 * Use two pointer to check if the weight of current two people is less than or equal to capacity
 * if yes move both pointers and increase count if no only move right counter and increase count
 *
 * Example -
 [7 9 3 2 8 6 4 5]
 10
 -> 5
 */
public class BoatsToSavePeople {
    public static int maxRoundTrip(int[] wt, int cap){
        int cont = 0;
        Arrays.sort(wt);
        int l = 0;
        int r = wt.length - 1;
        while (l <= r){
            int ws = wt[l] + wt[r];
            if(ws <= cap){
                cont++;
                l++;
                r--;
            }
            else{
                cont++;
                r--;
            }
        }
        return cont;
    }
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] wt = new int[n];

        for(int i=0; i<wt.length; i++){
            wt[i] = scn.nextInt();
        }
        int capacity = scn.nextInt();

        int maxRounds = maxRoundTrip(wt, capacity);
        System.out.println("Max no of round trips to make everyone cross the river " + maxRounds);
    }
}
