package ArraysAndString.Intervals;


import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * Given an n*2 size of array
 * Tell if a person can attend all the meetings or not
 *
 * Approach
 * Sort the array based on first value
 * Similar as merge intervals but here if value is overlapping then return false
 * meaning person cannot attend all the meetings
 *
 [ [3 6] [ 1 3] [8 10] [7 8] [9 15] ] -> not possible
 */
public class MeetingRoomsI {
    public static boolean possibleToAttendMeetings(int[][] meetings){
        Arrays.sort(meetings, ((m1, m2) -> Integer.compare(m1[0], m2[0])));

        for(int i=1; i<meetings.length; i++){
            if(meetings[i][0] < meetings[i-1][1]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[][] meetings = new int[n][2];

        for(int i=0; i<meetings.length; i++){
            meetings[i][0] = scn.nextInt();
            meetings[i][1] = scn.nextInt();
        }

        boolean possible = possibleToAttendMeetings(meetings);
        if(possible){
            System.out.println("It is possible to attend all the meetings");
        }
        else{
            System.out.println("It is not possible to attend all the meetings");
        }
    }
}
