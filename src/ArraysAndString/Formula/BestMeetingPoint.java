package ArraysAndString.Formula;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Need to find a find point(meeting point) such that the travel cost is minimum position with value 1 represents person
 * top/bottom/left/right costs 1 here
 *
 * here distance formula is manhattan distance formula
 * distance(p1,p2) = |p1.x - p2.x| + |p1.y - p2.y|
 *
 * approach
 * think like old maths problems where min distance use to median
 *
 * in this kind of problem as well median is the point from where the distance would be minimum
 * check on the 2d x-axis and take two points(extreme) and one at center
 *
 * but for median points we need to have values in sorted order
 *
 * 2 Approach
 *
 * 1st -> traverse and get the index of people in x and y and sort both of them to calculate median
 *          but this can take worst case O(n*n*log(n)) time we can optimize log(n) sort
 *
 * 2nd -> traverse such that to calculate median we don't need to sort positions in x or y coordinates
 *          for x coordinates traverse row wise for y coordinates traverse column wise
 *
 *
 [[1,0,0,0,1],
 [0,0,0,0,0],
 [0,0,1,0,0]]
 -> 6
 */
public class BestMeetingPoint {

    public static void bestMeetingPoint(int[][] arr){
        // get median
        ArrayList<Integer> x = new ArrayList<>();
        ArrayList<Integer> y = new ArrayList<>();

        //traverse for row wise sorted
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[0].length; j++){
                if(arr[i][j] == 1){
                    x.add(i);
                }
            }
        }
        //traverse for col wise sorted
        for(int j=0; j<arr[0].length; j++){
            for(int i=0; i<arr.length; i++){
                if(arr[i][j] == 1){
                    y.add(j);
                }
            }
        }

        int xmed = x.get(x.size()/2);
        int ymed = y.get(y.size()/2);

        // calculate the cost from each index
        int cost = 0;
        for(int xval: x){
            cost += Math.abs(xmed - xval);
        }
        for(int yval: y){
            cost += Math.abs(ymed - yval);
        }

        System.out.println("Median point is (" + xmed + "," + ymed + ") and total distance is " + cost);
    }
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        int[][] arr = new int[n][m];

        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[0].length; j++){
                arr[i][j] = scn.nextInt();
            }
        }

        bestMeetingPoint(arr);
    }
}
