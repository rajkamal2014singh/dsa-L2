package RecursionAndBacktracking;

import java.util.Scanner;

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
