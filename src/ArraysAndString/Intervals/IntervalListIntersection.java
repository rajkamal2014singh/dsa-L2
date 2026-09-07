package ArraysAndString.Intervals;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * Given two list of intervals(sorted based on start time of interval)
 * Need to create a new list of interval values that have values of intersection of intervals in the list
 *
 * Approach
 * Create two pointer one pointing on list1 and second on list2
 * now calculate overlapping values, push to result list
 * and build the logic to move pointers in correct way. i.e., move pointer whose interval's end point is smaller
 *
 * Example
 *  [[1 3] [5 10][12 17]]  & [[2 4] [5 7] [9 13]]
 *
 *  result -> [[2 3] [5 7] [9 10] [12 13]]
 */
public class IntervalListIntersection {
    public static int[][] intervalIntersection(int[][] in1, int[][] in2){
        ArrayList<int[]> res = new ArrayList<>();
        int i = 0;
        int j = 0;

        while(i < in1.length && j<in2.length){
            int st = Math.max(in1[i][0], in2[j][0]);
            int end = Math.min(in1[i][1], in2[j][1]);

            if(st < end){
                int[] interval = {st, end};
                res.add(interval);
            }

            if(in1[i][1] < in2[j][1]){
                i++;
            }
            else{
                j++;
            }
        }
        return res.toArray(new int[res.size()][]);
    }
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[][] interval = new int[n][2];
        int[][] interval2 = new int[n][2];

        for(int i=0; i<interval.length; i++){
            interval[i][0] = scn.nextInt();
            interval[i][1] = scn.nextInt();
        }

        for(int i=0; i<interval2.length; i++){
            interval2[i][0] = scn.nextInt();
            interval2[i][1] = scn.nextInt();
        }

        int[][] intersection = intervalIntersection(interval, interval2);
        System.out.println("Interval intersection is ");
        for(int[] in: intersection){
            System.out.println(in[0] + " - " + in[1]);
        }
    }
}
