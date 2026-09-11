package ArraysAndString;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Leetcode car fleet problem
 * there are n cars and k is the target position
 * we are provided with the current position of cars in positions array
 * for every car we are give speed of the car
 *
 * we need to find the no of fleets that we will arrive at target after every one reaches the target
 * single car can also make a fleet
 * someone from behind cannot overtake the other car in front position, if they reach at same time they form a fleet
 * or if they are at same position
 *
 * example position = [10, 8, 0, 5, 3] speed = [2,4,1,1,3] target = 12
 * output - 3 (total three fleets will be formed)
 *
 *
 */
public class CarFleet {
    public static int countFleets(int[] positions, int[] speed, int target){
        int n = speed.length;
        double[][] time = new double[n][2];

        for(int i=0; i<n; i++){
            double ct = (target * 1d - positions[i] * 1d) / speed[i];
            time[i][0] = positions[i] * 1d;
            time[i][1] = ct;
        }

        Arrays.sort(time, (a, b) -> Double.compare(a[0], b[0]));
        int count = 0;
        double tt = 0.0;
        for(int i=n-1; i>=0; i--){
            if(time[i][1] > tt){
                count++;
                tt = time[i][1];
            }
        }

        return count;
    }
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] positions = new int[n];
        int[] speed = new int[n];

        for(int i=0; i<n; i++){
            positions[i] = scn.nextInt();
        }

        for(int i=0; i<n; i++){
            speed[i] = scn.nextInt();
        }

        int target = scn.nextInt();

        int fleets = countFleets(positions, speed, target);
        System.out.println("Total fleets formed is " + fleets);
    }
}
