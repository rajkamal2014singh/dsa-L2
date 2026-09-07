package ArraysAndString.Intervals;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * Given a list of intervals sorted based on start value(non-overlapping) and interval value that needs to be
 * added to the list value might have over lapping value create a result list of interval with non-overlapping value
 *
 * Approach
 * Merge over lapping interval concept with little variation
 [[1 5] [7 9] [10 13] [16 19] [20 25]] start - 12 end - 20
 res - [[1 5] [7 9] [10 25]]
 *
 */
public class InsertInterval {
    public static int[][] insertInterval(int[][] intervals, int start, int end){
        ArrayList<int[]> res = new ArrayList<>();
        int idx = 0;
        int n = intervals.length;
        while( idx < n && intervals[idx][0] < start){
            res.add(intervals[idx]);
            idx++;
        }
        if(res.size() == 0 || start > res.getLast()[1]){
            int[] in = {start, end};
            res.add(in);
        }
        else{
            int[] lastInterval = res.getLast();
            lastInterval[1] = Math.max(lastInterval[1], end);
        }

        while (idx < n){
            int[] lastInterval = res.getLast();
            if(intervals[idx][0] > lastInterval[1]){
                res.add(intervals[idx]);
            }else{
                //merging
                lastInterval[1] = Math.max(lastInterval[1], intervals[idx][1]);
            }
            idx++;
        }

        return res.toArray(new int[res.size()][]);
    }
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[][] intervals = new int[n][2];

        for(int i=0; i<intervals.length; i++){
            intervals[i][0] = scn.nextInt();
            intervals[i][1] = scn.nextInt();
        }

        int start = scn.nextInt();
        int end = scn.nextInt();

        int[][] res = insertInterval(intervals, start, end);
        System.out.println("Intervals after inserting new interval");
        for (int[] interval: res){
            System.out.println(interval[0] + " - " + interval[1]);
        }
    }
}
