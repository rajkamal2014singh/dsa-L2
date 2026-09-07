package ArraysAndString.Intervals;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * Given list of ballons that spread over x-axis with starting point and ending point
 * An arrow can burst the ballon if it even touches the ballon at edge or passes through it
 * we need to find minimum no of ballons needed to burst all the ballons
 *
 *
 * Approach
 * We know that even if ballons end is also touched it will burst the ballon
 * keeping that in mind we should sort the array based on ending cordinate of ballon
 * keep ballon as 1 in start and arrow corrdinate at end of first ballon
 * iterate over list if current ballon's start coordinate is less than current arrow coordinate than
 * current arrow can burst the ballon
 * if not we will need new arrow and we can keep the arrow cordinate at current ballon's end cordinate
 *
 * Example
 * [[1 3] [3 5]] -> 1
 * [[10 13] [3 5] [5 7] [1 5] [2 6] [12 14]] -> 2
 * [[1 3] [5 7] [9 10]] -> 3
 */
public class MinArrowsToBurstBallons {
    public static int minimumBallons(int[][] ballons){
        Arrays.sort(ballons, ((b1, b2) -> Integer.compare(b1[1], b2[1])));
        int maxBallons = 1;
        int arrowCoordinate = ballons[0][1];
        for(int[] ballon : ballons){
            if(ballon[0] > arrowCoordinate){
                maxBallons++;
                arrowCoordinate = ballon[1];
            }
        }
        return maxBallons;
    }
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[][] ballons = new int[n][2];

        for(int i=0; i<ballons.length; i++){
            ballons[i][0] = scn.nextInt();
            ballons[i][1] = scn.nextInt();
        }

        int minBallons = minimumBallons(ballons);
        System.out.println("Minimum no of ballons needed to burst all the ballons is " + minBallons);
    }
}
