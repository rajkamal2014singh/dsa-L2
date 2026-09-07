package ArraysAndString.Matrix;

import java.util.Scanner;

/**
 *
 * Need to find the transpose of a matrix where matrix is a square matrix
 * This is a special case of m*n matrix where m=n
 * for a square matrix we can do it without utilizing the extra space
 *
 *
 * Approach
 * since every i, j will have j, i we can swap those values and get a transpose
 * Remember if we traverse whole array and swap i,j with j,i it will give same array
 * as swapping will happen twice once e,g swapped 1,2 with 2,1 when again at 2,1 will swap with 1,2
 * so traverse and swap keeping that in mind.
 *
 *
 10 20 30 40
 50 60 70 80
 90 100 110 120
 130 140 150 160
 */

public class TransposeOfMatrixN_N {
    public static void transpose(int[][] arr){
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<i; j++){
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }
    }
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[][] arr = new int[n][n];

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

        transpose(arr);
        System.out.println("Array after transposed");
        for(int i=0; i<arr.length; i++){
            for(int j = 0; j<arr[0].length; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
