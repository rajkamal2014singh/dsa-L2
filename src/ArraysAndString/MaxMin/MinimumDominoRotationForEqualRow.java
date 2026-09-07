package ArraysAndString.MaxMin;

import java.util.Scanner;

/**
 *
 * Give two arrays both represents the domino first(top) and other represent domino 2(bottom)
 *
 * we need to find minimum no of rotations needed such that in a row every domino have same value
 * if no such value present such that each have same value return -1
 *
 * we can have two numbers num1 and num2
 * either num1 from top(r1) makes all the value in top(r1) as num1 or bottom(r2) as num1
 * or num2 from bottom will make all the values in top(r1) as num2 or bottom(r2) as num2
 *
 * for any of the swapping either the domino will have that value or if on top bottom have that value if not that number
 * can't be make that condition possible
 * we will have four scenarios
 *
 * we want to do it in a efficient way in O(n)
 *
 *
 tops = [2 1 2 4 2 2]
 bottom = [5 2 6 2 3 2]

 tops = [3 5 1 2 3]
 bottom = [3 6 3 3 4]
 *
 */
public class MinimumDominoRotationForEqualRow {
    public static int countMinRotation(int[] r1, int[] r2){
        int count1 = 0;
        int count2 = 0;
        int count3 = 0;
        int count4 = 0;

        int num1 = r1[0];
        int num2 = r2[0];

        for(int i=0; i<r1.length; i++){
            // no of rotations required to make r1 as num1
            if(count1 != Integer.MAX_VALUE){
                if(r1[i] == num1){
                    // nothing
                }else if(r2[i] == num1){
                    count1++;
                }
                else{
                    count1 = Integer.MAX_VALUE;
                }
            }
            // no of rotations required to make r2 as num1
            if(count2 != Integer.MAX_VALUE){
                if(r2[i] == num1){
                    // nothing
                }else if(r1[i] == num1){
                    count2++;
                }
                else{
                    count2 = Integer.MAX_VALUE;
                }
            }
            // no of rotations required to make r1 as num2
            if(count3 != Integer.MAX_VALUE){
                if(r1[i] == num2){
                    //nothing
                }else if(r2[i] == num2){
                    count3++;
                }
                else{
                    count3 = Integer.MAX_VALUE;
                }
            }
            // no of rotations required to make r2 as num2
            if(count4 != Integer.MAX_VALUE){
                if(r2[i] == num2){

                }else if(r1[i] == num2){
                    count4++;
                }
                else{
                    count4 = Integer.MAX_VALUE;
                }
            }
        }

        int val = Math.min(Math.min(count1, count2), Math.min(count2, count3));

        return val == Integer.MAX_VALUE ? -1: val;
    }
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] r1 = new int[n];
        int[] r2 = new int[n];

        for(int i=0; i<r1.length; i++){
            r1[i] = scn.nextInt();
        }
        for(int i=0; i<r2.length; i++){
            r2[i] = scn.nextInt();
        }
        int minRotation = countMinRotation(r1, r2);

        if(minRotation == -1){
            System.out.println("No rotation possible to make a row's all value as same");
        }else {
            System.out.println("Minimum no of rotations required is " + minRotation);
        }
    }
}
