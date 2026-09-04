package ArraysAndString;

import java.util.Scanner;

/**
 *
 * Need to find the transpose of a matrix where matrix is not a square matrix
 * so for this kind of situation will need to used extra space and new matrix
 * is of n*m dimension
 *
 * Approach
 * Create a result matrix of size n*m
 * traverse the matrix and add the values from the given matrix such that
 * when at index i, j fetch the value from j, i of given matrix because transpose works that way
 * here we can't use same array as m != n
 * for m == n we can do it in space efficient way
 *
 *
 3 4
 10 20 30 40
 50 60 70 80
 90 100 110 120

 result
 10 50 90
 20 60 100
 30 70 110
 40 80 120
 *
 *
 */

public class TransposeOfMatrixM_N {
    public static int[][] transpose(int[][] arr){
        int m = arr.length;
        int n = arr[0].length;

        int[][] transpose = new int[n][m];

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                transpose[i][j] = arr[j][i];
            }
        }

        return transpose;
    }
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int m = scn.nextInt();
        int n = scn.nextInt();
        int[][] arr = new int[m][n];

        for(int i=0; i<arr.length; i++){
            for(int j = 0; j<n; j++){
                arr[i][j] = scn.nextInt();
            }
        }

        System.out.println("Array before transpose");
        for(int i=0; i<arr.length; i++){
            for(int j = 0; j<n; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

        int[][] res = transpose(arr);
        System.out.println("Transposed array");
        for(int i=0; i<res.length; i++){
            for(int j = 0; j<res[0].length; j++){
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
    }
}
