package RecursionAndBacktracking;

import java.util.ArrayList;
import java.util.Scanner;

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
