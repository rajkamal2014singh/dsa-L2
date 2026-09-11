package RecursionAndBacktracking;

import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * Given a string str of length n.
 * Print all the possible palindromic permutation
 * If no palindromic permutation exists print -1.
 *
 * Approach
 * Calculate the frequency of every character and store it in map
 * check if there is any character that have odd frequency if more than one no palindromic perm possible
 * if one or no odd frequency character make the frequency of characters half
 * now keep the count/sum of frequency of characters and frequency mapping and asf
 * iterate on every character in freqMap and add it to asf and decrease the frequency of that character make sure frequency
 * is greater than 0 also when coming back after traversal remember to make the frequency of character as before
 *
 * base case when current size is greater than total frequency map characters count then
 * create a reverse string of asf and if odd is there add it in between asf and rev
 *
 *
 */
public class PalindromicPermutations {
    public static void solvePrintPalindrome(int cs, int ts, HashMap<Character, Integer> freqMap, Character oddCh, String asf){
        if(cs > ts){
            String rev = new String();
            for(int i = asf.length()-1; i>=0; i--){
                rev += asf.charAt(i);
            }
            String ans = asf;
            if(oddCh != null){
                ans += oddCh;
            }
            ans += rev;
            System.out.println(ans);
            return;
        }
        for(char ch: freqMap.keySet()){
            int freq = freqMap.get(ch);
            if(freq > 0){
                freqMap.put(ch, freq - 1);
                solvePrintPalindrome(cs + 1, ts, freqMap, oddCh, asf + ch);
                freqMap.put(ch, freq);
            }
        }

    }
    public static void printPalindromicPermutation(String str){
        HashMap<Character, Integer> freqMap = new HashMap<>();
        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }

        Character oddCh = null;
        int odd = 0;
        int freqSum = 0;
        for(Character ch : freqMap.keySet()){
            int freq = freqMap.get(ch);
            if(freq % 2 == 1){
                odd++;
                oddCh = ch;
            }
            freqMap.put(ch, freq/ 2);
            freqSum += freq/2;
        }

        if(odd > 1){
            System.out.println(-1);
            return;
        }

        solvePrintPalindrome(1, freqSum, freqMap, oddCh, "");
    }
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        String str = scn.next();

        printPalindromicPermutation(str);
    }
}
