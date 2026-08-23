package RecursionAndBacktracking;

import java.util.Scanner;
/**
3 0 6 5 0 8 4 0 0
5 2 0 0 0 0 0 0 0
0 8 7 0 0 0 0 3 1
0 0 3 0 1 0 0 8 0
9 0 0 8 6 3 0 0 5
0 5 0 0 9 0 6 0 0
1 3 0 0 0 0 2 5 0
0 0 0 0 0 0 0 7 4
0 0 5 2 0 6 3 0 0
 */

public class Sudoku {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);

        int[][] sudoku = new int[9][9];
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                sudoku[i][j] = scn.nextInt();
            }
        }
        solveSudoku(sudoku, 0, 0);


    }

    public static void display(int[][] sudoku){
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                System.out.print(sudoku[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void solveSudoku(int[][] sudoku, int i, int j){
        if(i == sudoku.length){
            display(sudoku);
            return;
        }

        int ni = 0;
        int nj = 0;

        if(j == sudoku[0].length - 1){
            ni = i + 1;
        }
        else{
            ni = i;
            nj = j + 1;
        }

        if(sudoku[i][j] != 0){
            solveSudoku(sudoku, ni, nj);
        }
        else {
            for(int pot=1; pot<=9; pot++){
                if(isValid(sudoku, i, j, pot)){
                    sudoku[i][j] = pot;
                    solveSudoku(sudoku, ni, nj);
                    sudoku[i][j] = 0;
                }
            }
        }
    }

    public static boolean isValid(int[][] sudoku, int r, int c, int pot){
        // check row
        for(int j=0; j<sudoku.length; j++){
            if(sudoku[r][j] == pot){
                return false;
            }
        }
        // check column
        for(int i=0; i<sudoku.length; i++){
            if(sudoku[i][c] == pot){
                return false;
            }
        }
        // check 3*3
        int mr = r/3 * 3;
        int mc = c/3 * 3;
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if(sudoku[i + mr][j + mc] == pot){
                    return false;
                }
            }
        }

        return true;
    }
}
