package RecursionAndBacktracking;

import java.util.Scanner;

public class NQueensBranchNBound {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[][] chess = new int[n][n];
        boolean[] cols = new boolean[n];
        boolean[] dig = new boolean[2*n -1];
        boolean[] rdig = new boolean[2*n -1];

        nQueens(chess, "", 0, cols, dig, rdig);
    }

    public static void nQueens(int[][] chess, String asf, int row, boolean[] cols, boolean[] dig, boolean[] rdig){
        if(row == chess.length){
            System.out.println(asf);
            return;
        }
        for(int col=0; col<chess.length; col++){
            if(cols[col] == false && dig[row+col] == false && rdig[row - col + chess.length -1] == false){
                cols[col] = true;
                dig[row+col] = true;
                rdig[row-col+chess.length-1] = true;
                nQueens(chess, asf + row + "-" + col +", ", row + 1, cols, dig, rdig);
                cols[col] = false;
                dig[row+col] = false;
                rdig[row-col+chess.length-1] = false;
            }
        }
    }
}
