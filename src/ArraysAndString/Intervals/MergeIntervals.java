package ArraysAndString.Intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 *
 * Given a n*2 size of array
 * return a new array where over lapping intervals are merged
 *
 * Approach
 * Sort the array based on first value
 * Iterate on array and if current elements first value is less than previous elements second value then
 * merge the elements with max of second value from previous and current
 [ [3 6] [ 1 3] [8 10] [7 8] [9 15] ]  -> [ [1 3] [3 6] [7 8] [8 15] ]
 */
public class MergeIntervals {
    public static int[][] mergeIntervals(int[][] intervals){
        Arrays.sort(intervals, ((i1, i2) -> Integer.compare(i1[0], i2[0])));
        List<int[]> merged = new ArrayList<>();

        for (int[] interval : intervals) {
            if (merged.isEmpty()) {
                merged.add(interval);
            } else {
                int[] prevInterval = merged.getLast();
                if (prevInterval[1] > interval[0]) {
                    prevInterval[1] = Math.max(prevInterval[1], interval[1]);
                } else {
                    merged.add(interval);
                }
            }
        }

        return merged.toArray(new int [merged.size()][]);
    }
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[][] intervals = new int[n][2];

        for(int i=0; i<intervals.length; i++){
            intervals[i][0] = scn.nextInt();
            intervals[i][1] = scn.nextInt();
        }

        int[][] merged = mergeIntervals(intervals);

        System.out.println("Merged interval are ");
        for(int i=0; i<merged.length; i++){
            System.out.println(merged[i][0] + " - " + merged[i][1]);
        }
    }
}
