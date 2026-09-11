package RecursionAndBacktracking;

import java.util.Scanner;

/**
 *
 * Give two values n and k
 * Suppose n people have formed a circle and in this game person at k position is eliminated
 * we need to eliminate till one person is left return the last remaining person;
 *
 * Approach
 * we eliminate person at k position and think of next person as starting point of circle
 * and solve for n-1 person
 * while returning we calculate the mapping for whichever person is left/remaining.
 *
 */
public class GameOfExecution {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int k = scn.nextInt();

        int last = gameOfElimination(n, k);
        System.out.println("Last after game " + last);
    }

    public static int gameOfElimination(int n, int k){
        if(n == 1){
            return 0;
        }
        int x = gameOfElimination(n-1, k);
        int y = (x + k) % n;
        return y;
    }

}
