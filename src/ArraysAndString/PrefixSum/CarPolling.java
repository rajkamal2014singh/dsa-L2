package ArraysAndString.PrefixSum;

import java.util.Scanner;

/**
 *
 * Given your cars moves in one direction and capacity of car
 * And list of array with 3 values containing value where p people go from point a and going to b
 * Check if car polling is possible or not for the given list.
 *
 * Approach 0
 * We could have done it using some of the interval concepts but that would take O(n*log(n)) minimum time
 * we can think of something better
 *
 * Approach 1
 * Get the max destination coordinate create a array of size maxCordinate + 1
 * Use prefix sum approach - for every coordinte calculate no of passangers at that point
 * Since cordinate size is max 10000, max array size will be 1000 which is constant if we thnk
 * If at any no of passangers count is greater than capacity return false.
 *
 * Else after traversing whole prefixSum array return true because at no point no of pasangers are more than
 * capacity of the car
 *
 * Example
 * [[1 5 2] [4 8 1] [11 15 3]], 3 -> true
 * [[1 3 5]], 4 -> false
 * [[0 4 5]], 4 -> false
 * [[1 5 2] [4 8 2][11 15 3]], 3 -> false
 */
public class CarPolling {
    public static boolean carPooling(int[][] carPool, int cap){
        int maxEnd = Integer.MIN_VALUE;
        for (int[] pool : carPool) {
            maxEnd = Math.max(maxEnd, pool[1]);
            if(pool[2] > cap){
                return false;
            }
        }

        int[] prefixSum = new int[maxEnd + 1];
        for(int[] pool: carPool){
            prefixSum[pool[0]] += pool[2];
            prefixSum[pool[1]] -= pool[2];
        }

        for(int i=1; i<prefixSum.length; i++){
            prefixSum[i] += prefixSum[i-1];
            if(prefixSum[i] > cap){
                return false;
            }
        }

        return true;
    }
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[][] carPool = new int[n][3];

        for(int i=0; i<carPool.length; i++){
            carPool[i][0] = scn.nextInt(); //start point
            carPool[i][1] = scn.nextInt(); //end point
            carPool[i][2] = scn.nextInt(); //no of people
        }
        int cap = scn.nextInt();

        boolean isPossible = carPooling(carPool, cap);
        if(isPossible){
            System.out.println("Car pooling is possible");
        }
        else{
            System.out.println("Car polling is not possible");
        }
    }
}
