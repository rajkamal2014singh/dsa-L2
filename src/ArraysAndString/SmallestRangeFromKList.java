package ArraysAndString;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * leetcode problem
 * given a list of list
 * every list is sorted
 * need to find the smallest range from k list
 *
 * range here is that all the elements on k list lies in that list
 example = [[4 10 15 24 26], [0 9 12 20] [5 18 22 30]]
 res - [20 24]
 range here is 24 - 20 + 1 = 5
 so this the smallest range here

 we can use priority_queue with max k size and maintain a max variable to calculate range
 whichever range is smallest till now will save that
 *
 */

public class SmallestRangeFromKList {
    public static class Range{
        int lo;
        int hi;
        Range(int lo, int hi){
            this.lo = lo;
            this.hi = hi;
        }
    }
    public static class Min implements Comparable<Min>{
        int val;
        int idx;
        int li;

        public Min(int val, int idx, int li){
            this.val = val;
            this.idx = idx;
            this.li = li;
        }

        public int compareTo(Min Other){
            return this.val - Other.val;
        }
    }
    public static Range smallestRange(List<List<Integer>> list){
        int k = list.size();
        PriorityQueue<Min> pq = new PriorityQueue<>();
        int max = Integer.MIN_VALUE;

        for(int i=0; i<k;i++){
            int val = list.get(i).get(0);
            max = Math.max(val, max);
            pq.add(new Min(val, 0, i));
        }

        Range ans = new Range(-100000, 100000);

        while(true){
            Min m = pq.remove();
            if(max - m.val < ans.hi - ans.lo){
                ans.lo = m.val;
                ans.hi = max;
            }
            m.idx++;
            if(m.idx == list.get(m.li).size()){
                break;
            }
            m.val = list.get(m.li).get(m.idx);
            max = Math.max(max, m.val);
            pq.add(m);
        }
        return ans;
    }

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        List<List<Integer>> ls = new ArrayList<>();
        while (true){
            int size = scn.nextInt();
            if(size == -1){
                break;
            }
            List<Integer> temp = new ArrayList<>(size);
            for(int i=0;i<size;i++){
                temp.add(scn.nextInt());
            }
            ls.add(temp);
        }

        Range r = smallestRange(ls);
        System.out.println("Range for k list is " + r.lo + " " + r.hi);
    }
}
