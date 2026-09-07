package ArraysAndString.Formula;

import java.util.Scanner;

/**
 *
 * Min Jumps to reach x with +- i jumps/moves
 * Given a x need to find the minimum no of jumps needed to reach to x
 * first jump is of 1 then second 2, and so on increasing jump can be left or right(+ve ive) need to find min jumps
 *
 * Approach
 * keep on jumping until you are less than x value
 * once you are greater than x distance check the distance between current position and x
 * if distance is even then by making distance/2 move as -ve or that jump as left jump we can reach to x
 * if distance is odd then take one more jump and check if it distance is still odd, take one more jump this time it
 * should be for sure even because
 *
 * (odd + odd) - even
 * (even + even) - even
 * (odd + even) - odd.
 * odd + even + odd - even (second jump distance will be always opposite as jump is increasing)
 * even + odd + even
 *
 *  8 -> 4
 *  9 -> 4
 *  17 -> 6
 *  20 -> 7
 *  25 -> 9
 *
 * time complexity is O(square_root(x))
 */
public class MinJumpsWithMoves {

    public static int minMoves(int x){
        int jumps = 1;
        int sum = 0;

        while (sum < x){
            sum += jumps;
            jumps ++;
        }

        if((sum - x) % 2 == 0){
            return jumps - 1;
        }
        else if((sum + jumps - x) % 2 == 0){
            return jumps;
        }
        else{
            return jumps + 1;
        }
    }
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int x = scn.nextInt();
        int jumps = minMoves(x);

        System.out.println("Min jumps to reach " + x + " is " + jumps);
    }
}
