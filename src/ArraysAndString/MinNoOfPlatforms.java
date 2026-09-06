package ArraysAndString;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 *
 * Given an array that have arrival and departure time of the trains
 * Find the minimum no of platforms needed so that no train waits
 * And for two train to be on same platform there should be little gap between departure of first
 * and arrival of second train.
 * Similar as MeetingRoomsII
 *
 * Approach 1(Min Heap)
 * Sort the array based on arrival time
 * Create a priority queue that stores the departure time of trains
 * On every element check if pq peek value(departure time) is less than current train's arrival time if it is
 * remove the element from pq and add current trains departure time
 * if not add current trains departure time to pq
 * size of the pq is min no of platforms need.
 *
 * time - O(n*log(n)), Extra Space - O(n)
 *
 * Approach 2(Cronological)
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
 *
 */
public class MinNoOfPlatforms {
    public static int minimumPlatformsHeap(int[][] schedule){
        Arrays.sort(schedule, ((s1, s2) -> Integer.compare(s1[0], s2[0])));
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int[] sch : schedule) {
            if (pq.isEmpty()) {
                pq.add(sch[1]);
            } else {
                if (pq.peek() < sch[0]) {
                    pq.remove();
                    pq.add(sch[1]);
                } else {
                    pq.add(sch[1]);
                }
            }
        }
        return pq.size();
    }

    public static int minimumPlatforms(int[][] schedule){
        int n = schedule.length;
        int[] arrival = new int[n];
        int[] departure = new int[n];
        for(int i = 0; i<schedule.length; i++){
            arrival[i] = schedule[i][0];
            departure[i] = schedule[i][1];
        }

        Arrays.sort(arrival);
        Arrays.sort(departure);

        int platforms = 0;
        int maxTrains = 0;
        int i = 0;
        int j = 0;
        while(i < n){
            if(arrival[i] <= departure[j]){
                maxTrains++;
                i++;
            }
            else {
                maxTrains--;
                j++;
            }
            platforms = Math.max(platforms, maxTrains);
        }
        return platforms;
    }

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[][] schedule = new int[n][2];

        for(int i=0; i<schedule.length; i++){
            schedule[i][0] = scn.nextInt();
            schedule[i][1] = scn.nextInt();
        }

        int minPlatforms = minimumPlatformsHeap(schedule);
        int minPlatforms1 = minimumPlatforms(schedule);

        System.out.println("Minimum platform required " + minPlatforms + " " + minPlatforms1);
    }
}
