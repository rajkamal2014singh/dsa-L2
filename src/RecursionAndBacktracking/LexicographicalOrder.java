package RecursionAndBacktracking;

import java.util.Scanner;

/***
 *
 * Given a number n need to print the numbers till n in lexicographical order.
 * Order of dictionary
 * 11 -> 1 10 11 2 3 4 5 6 7 8 9
 * 21 -> 1 10 11 12 13 14 15 16 17 18 19 2 20 21
 * 1000 -> 1 10 100 100 101 102 .. 11 110 .. 12....99 .. 999
 *
 */
public class LexicographicalOrder {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        for(int i=1; i<=9; i++){
            dfs(i, n);
        }
    }

    public static void dfs(int i, int n){
        if(i>n){
            return;
        }

        System.out.println(i);
        for(int j=0; j<10; j++){
            dfs(i*10 + j, n);
        }
    }
}
