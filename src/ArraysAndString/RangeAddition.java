package ArraysAndString;

import java.util.Scanner;

/**
 *
 * given an array of n size
 * perform q queries each query contains start index and end index and value that needs to be added in that index range
 *
 **/
public class RangeAddition {
    /**
     * qn*n - time complexity
     */
    public static int[] rangeAddition(int n, int[][] queries){
        int[] res = new int[n];

        for(int i=0; i<queries.length; i++){
            int sti = queries[i][0];
            int endi = queries[i][1];
            int val = queries[i][2];

            for(int j=sti; j<=endi && j<n; j++){
                res[j] += val;
            }
        }

        return res;
    }

    /**
     * max (qn, n) - time complexity
     */
    public static int[] rangeAddition2(int n, int[][] queries){
        int[] res = new int[n];

        for(int i=0; i< queries.length; i++){
            int sti = queries[i][0];
            int endi = queries[i][1];
            int val = queries[i][2];

            res[sti] += val;
            if(endi+1 < n){
                res[endi + 1] -= val;
            }
        }

        int prefixSum = 0;
        for(int i=0; i<n; i++){
            prefixSum += res[i];
            res[i] = prefixSum;
        }

        return res;
    }

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int qn = scn.nextInt();
        int[][] queries = new int[qn][3];

        for(int i=0; i<qn; i++){
            queries[i][0] = scn.nextInt();
            queries[i][1] = scn.nextInt();
            queries[i][2] = scn.nextInt();
        }

        int[] res = rangeAddition(n, queries);
        System.out.println("Array after queries ");
        for(int i=0; i<res.length; i++){
            System.out.print(res[i] + " ");
        }
        int[] res2 = rangeAddition2(n, queries);
        System.out.println("Array after queries 2 ");
        for(int i=0; i<res2.length; i++){
            System.out.print(res2[i] + " ");
        }
    }
}
