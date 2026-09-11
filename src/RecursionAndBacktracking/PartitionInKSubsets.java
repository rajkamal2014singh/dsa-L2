package RecursionAndBacktracking;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *  Given two numbers n and k.
 *  n represents no of elements.
 *  k represents no of subsets.
 *  We need to print the print all the valid set in which these elements can be partitioned into k non-empty subsets.
 *  think of n as no of players, and k as no of teams(so need to find ways that n players can form k size teams)
 *
 * Approach (level 1 dp problem in that we just need to calculate ways here we need all the subsets)
 *  so we after iterating we can up with some cases and formula to calculate no of subsets possible
 *  when n > k
 *  subset = k*subset(n-1, k) + subset(n-1, k-1)
 *  cases
 *  when n == 0 || k == 0 || n < k  no of subsets is 0
 *  when k == 1 no of subsets is 1, one subset(teams) containing all the elements(players) so no of ways is 1
 *  when n == k no of subsets is n, each element(player) in a single subset, so no of ways is 1
 *  when n > k, p -> n, t -> k; ways[t][p] = ways[t][p-1]*t + ways[t-1][p-1]
 *
 *
 */
public class PartitionInKSubsets {
    // nos -> no of sets so far
    static int counter;
    public static void solution(int i, int n, int k, int nos, ArrayList<ArrayList<Integer>> ans){
        if(i > n){
            if(nos==k){
               counter++;
               System.out.print(counter + ".");
               for (ArrayList<Integer> set:  ans){
                   System.out.print(set + " ");
               }
               System.out.println();
            }
            return;
        }

        for(int j=0; j < ans.size(); j++){
            if(ans.get(j).size() > 0){
                ans.get(j).add(i);
                solution(i+1, n, k, nos, ans);
                ans.get(j).remove(ans.get(j).size() - 1);
            }
            else{
                ans.get(j).add(i);
                solution(i+1, n, k, nos + 1, ans);
                ans.get(j).remove(ans.get(j).size() - 1);
                break;
            }
        }
    }
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int k = scn.nextInt();

        ArrayList<ArrayList<Integer>> ans = new ArrayList();
        for(int i=0; i<k; i++){
           ans.add(new ArrayList<>());
        }

        solution(1, n, k, 0, ans);
    }
}
