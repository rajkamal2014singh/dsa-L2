package RecursionAndBacktracking;

import java.util.Scanner;

// some mistake need to take a look
/**
4
dog cat dad good
9
a b c d d d g o o
1 0 9 5 9 0 3 0 0 0 0 0 0 0 2 0 0 0 0 0 0 0 0 0 0 0
 */
public class MaxScoreOfWord {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int noOfWords = scn.nextInt();
        String[] words = new String[noOfWords];

        for(int i=0; i<noOfWords; i++){
            words[i] = scn.next();
        }

        int noOfLetters = scn.nextInt();
        char[] letters = new char[noOfLetters];
        for(int i=0; i<noOfLetters; i++){
            letters[i] = scn.next().charAt(0);
        }

        int[] score = new int[26];
        for(int i=0; i<26; i++){
            score[i] = scn.nextInt();
        }

        if(words == null || words.length == 0 || letters == null || letters.length == 0 || score.length == 0){
            System.out.println(0);
            return;
        }

        int[] farr = new int[score.length];
        for(char ch: letters){
            farr[ch - 'a']++;
        }

        System.out.println("Max score of word is " + maxScore(words, farr, score, 0) + val);
    }

    static String val = "";
    public static int maxScore(String[] words, int[] freq, int[] score, int idx){
        if(idx == words.length){
            return 0;
        }

        int maxNo = maxScore(words, freq, score, idx + 1);

        int wordScore = 0;
        String word = words[idx];
        boolean flag = true;

        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);

            if(freq[ch - 'a'] == 0){
                flag = false;
            }

            freq[ch - 'a']--;
            wordScore += score[ch - 'a'];
        }

        int maxYes = 0;
        if(flag){
            maxYes = wordScore + maxScore(words, freq, score, idx + 1);
            if(maxYes > maxNo){
                val += word;
            }
        }

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            freq[ch - 'a']++;
        }

        return Math.max(maxNo, maxYes);
    }
}
