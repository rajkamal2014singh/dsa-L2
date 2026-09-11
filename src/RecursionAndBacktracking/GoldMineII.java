package RecursionAndBacktracking;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * Given a gold mine represented in the form of matrix
 * Here 0 represents blockage
 * Any other value non-zero represents how much gold can be collected at the point
 * Need to find max gold that can be mined
 *
 * Approach
 * Feels Similar as No of island and flood fill traversal where we store the value of index
 * Traverse the matrix get the valid values in a array list
 * calculate the sum and store the maxSum we got
 *
 *
 */
public class GoldMineII {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int m  = scn.nextInt();
        int n = scn.nextInt();
        int[][] gold = new int[m][n];

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                gold[i][j] = scn.nextInt();
            }
        }

        int maxGold = goldMine(gold);
        System.out.println("Max gold which can be mined is " + maxGold);
    }

    public static int goldMine(int[][] gold){
        int maxGold = 0;
        boolean[][] vis = new boolean[gold.length][gold[0].length];
        for(int i=0; i<gold.length; i++){
            for(int j=0; j<gold[0].length; j++){
                if(vis[i][j] == false && gold[i][j] != 0){
                    ArrayList<Integer> golds = new ArrayList<>();
                    traverseGoldMine(gold, i, j, vis, golds);
                    int sum = 0;
                    for(int val: golds){
                        sum += val;
                    }

                    if(sum > maxGold){
                        maxGold = sum;
                    }
                }
            }
        }

        return maxGold;
    }

    public static void traverseGoldMine(int[][] gold, int r, int c, boolean[][] vis, ArrayList<Integer> golds){
        if(r<0 || c<0 || r==gold.length || c==gold[0].length || vis[r][c] || gold[r][c] == 0){
            return;
        }

        vis[r][c] = true;
        golds.add(gold[r][c]);
        traverseGoldMine(gold, r - 1, c, vis, golds);
        traverseGoldMine(gold, r + 1, c, vis, golds);
        traverseGoldMine(gold, r, c - 1, vis, golds);
        traverseGoldMine(gold, r, c + 1, vis, golds);
    }
}
