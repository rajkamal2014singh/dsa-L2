package ArraysAndString.MaxMin;

import java.util.Scanner;

/**
 *
 * find max area for water storage
 * kind of same as histogram problem from stack l1
 *
 */
public class MaxWater {
    /**
     * n^2 time complexity
     */
    public static int maxWater(int[] water){
        int maxArea = 0;
        for(int i=0; i < water.length - 1; i++){
            // check for other value and calculate the area and save max area
            for(int j = i+1; j<water.length; j++){
                int area = (j-i)* Math.min(water[i], water[j]);
                if(area > maxArea){
                    maxArea = area;
                }
            }
        }

        return maxArea;
    }

    /**
     * n time complexity
     */
    public static int maxWater2(int[] water){
        int maxArea = 0;
        int i = 0;
        int j = water.length - 1;
        while (i < j){
            int ht = Math.min(water[i], water[j]);
            int wd = j - i;
            maxArea = Math.max(maxArea, ht*wd);

            if(water[i] < water[j]){
                i++;
            }
            else{
                j--;
            }
        }

        return maxArea;
    }
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];

        for(int i=0; i<arr.length; i++){
            arr[i] = scn.nextInt();
        }

        int maxWater = maxWater(arr);
        int maxWater1 = maxWater2(arr);
        System.out.println("Max area of water that can be contained " + maxWater + "@" + maxWater1);

    }
}
