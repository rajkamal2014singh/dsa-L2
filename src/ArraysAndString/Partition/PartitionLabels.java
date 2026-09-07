package ArraysAndString.Partition;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 *
 * Similar to chaining problems - maximumChunksI and maximumChunksII(have a look before going through this question)
 * here as well we want to split the string/partition it in such way no character in one chunk is present in other chunk
 * we need to calculate the index at which we can partition the string and store the size of chunks into a list
 *
 * String abc = "abcddaaefegeeijj" -> [7, 5, 3] ->{"abcddaa", "efegee", "ijj"}
 *
 */
public class PartitionLabels {
    public static List<Integer> partitionLabels(String str){
        HashMap<Character, Integer> mp = new HashMap<>();
        for(int i=0; i<str.length(); i++){
            mp.put(str.charAt(i), i);
        }

        int max = Integer.MIN_VALUE;
        int prev = -1;
        List<Integer> res = new ArrayList<>();
        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);
            max = Math.max(max, mp.get(ch));

            if(max == i){
                res.add(max - prev);
                prev = i;
            }
        }

        return res;
    }
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        String str = scn.next();

        List<Integer> res = partitionLabels(str);
        System.out.println("Partitions Size " + res);
    }
}
