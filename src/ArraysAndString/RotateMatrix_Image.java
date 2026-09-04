package ArraysAndString;

import java.util.Scanner;

/**
 10 20 30 40
 50 60 70 80
 90 100 110 120
 130 140 150 160

 should give
 130 90 50 10
 140 100 60 20
 150 110 70 30
 160 120 80 40

 *  rotate the matrix by 90 degree
 *  So if we observe properly then solution looks like transpose and then swap the columns from left to right
 here transpose will look like
 10 50 90 130
 20 60 100 140
 30 70 150 110
 40 80 120 160

 swapping this across columns gives us 90 degree rotate array
 *
 *
 */
public class RotateMatrix_Image {
    public static void rotateMatrix90(int[][] arr){
        //transpose
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<i; j++){
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }

        //reverse/swap column based values
        for(int i=0; i<arr.length; i++){
            int l = 0;
            int r = arr.length - 1;
            while (l < r){
                int temp = arr[i][l];
                arr[i][l] = arr[i][r];
                arr[i][r] = temp;
                l++;
                r--;
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

        rotateMatrix90(arr);
        System.out.println("Array after rotation");
        for(int i=0; i<arr.length; i++){
            for(int j = 0; j<arr[0].length; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
