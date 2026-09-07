package ArraysAndString.MaxMin;

import java.util.Scanner;

/**
 *
 * It should be in backtracking problems list
 *
 * leetcode problem
 * In a matrix 1 represent land and zero water
 * find the max area of the island
 * one cell represents area of 1
 *
 */
public class MaxAreaOfIsland {

    static int[] di =  {-1, 0, 1, 0};
    static int[] dj = {0, -1, 0, 1};
    public static int findAreaOfIsland(int[][] matrix, boolean[][] vis, int i, int j){
        if(i<0 || j<0 || i>=matrix.length || j>=matrix[0].length || matrix[i][j] == 0 || vis[i][j] == true){
            return 0;
        }
        int area = 0;
        vis[i][j] = true;
        for(int d=0; d<4; d++){
            int ni = i + di[d];
            int nj = j + dj[d];
            area += findAreaOfIsland(matrix, vis, ni, nj);
        }
        return area + 1;
    }

    public static int calculateMaxArea(int[][] matrix){
        int n = matrix.length;
        int m = matrix[0].length;
        boolean[][] visited = new boolean[n][m];
        int maxArea = 0;
        for(int i=0;i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                if(matrix[i][j] == 1 && visited[i][j] == false){
                    maxArea = Math.max(maxArea, findAreaOfIsland(matrix, visited, i, j));
                }
            }
        }

        return maxArea;
    }

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        int[][] matrix = new int[n][m];

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                matrix[i][j] = scn.nextInt();
            }
        }
        int maxArea = calculateMaxArea(matrix);

        System.out.println("Max area of a island is " + maxArea);
    }
}
