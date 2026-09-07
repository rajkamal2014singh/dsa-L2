package ArraysAndString.Intervals;


import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 *
 * Given an n*2 size of array
 * Calculate the minimum number of meeting rooms required
 * Similar as MinNoOfPlatforms
 *
 * Approach 1 (heap)
 * Sort the array based on start time
 * Create a priority queue that stores the end of meeting time
 * On every element check if pq peek value(meeting end time) is less than or equal to current meeting start time
 * remove the element from pq and add current meetings end time
 * if not add current elements meeting end time
 * size of the pq is max no of meeting rooms needed.
 *
 * time - O(n*log(n)), Extra Space - O(n)
 *
 * Approach 2 (Coronological)
 * Store both start and end timings in different arrays
 * sort both of them
 * Keep two pointers one on start and one on end time
 * create two variable rooms and maxRooms
 * if start[i] < end[j] rooms++ i++
 * else rooms-- j++
 * maxRooms = max(rooms, maxRooms)
 *
 * time - O(n*log(n)), Extra Space - O(1)
 *
 */
public class MeetingRoomII {
    public static int minimumMeetingRoomsHeap(int[][] meetings){
        Arrays.sort(meetings, ((m1, m2) -> Integer.compare(m1[0], m2[0])));
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int[] mt : meetings){
            if(pq.isEmpty()){
                pq.add(mt[1]);
            }
            else{
                if(pq.peek() <= mt[0]){
                    pq.remove();
                    pq.add(mt[1]);
                }
                else{
                    pq.add(mt[1]);
                }
            }
        }
        return pq.size();
    }

    public static int minMeetingRooms(int[][] meetings){
        int n = meetings.length;
        int[] mst = new int[n];
        int[] mend = new int[n];

        for(int i=0; i<meetings.length; i++){
            mst[i] = meetings[i][0];
            mend[i] = meetings[i][1];
        }

        Arrays.sort(mst);
        Arrays.sort(mend);
        int mcount = 0;
        int rooms = 0;
        int i = 0;
        int j = 0;

        while (i<n){
            if(mst[i] < mend[j]){
                mcount++;
                i++;
            }
            else{
                mcount--;
                j++;
            }
            rooms = Math.max(mcount, rooms);
        }
        return rooms;
    }
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[][] meetings = new int[n][2];

        for(int i=0; i<meetings.length; i++){
            meetings[i][0] = scn.nextInt();
            meetings[i][1] = scn.nextInt();
        }

        int minRooms = minimumMeetingRoomsHeap(meetings);
        int minRooms1 = minMeetingRooms(meetings);

        System.out.println("Minimum meeting rooms required for meetings to happen " + minRooms + " " + minRooms1);
    }
}
