package RecursionAndBacktracking;

import java.util.Scanner;

/**
 * Given a word, generate all the abbreviation of the word
 * Example -> pep
 * pep, pe1, p1p, p2,  1ep, 1ep, 2p, 3
 * 000, 001, 010, 011, 100, 101, 110, 111
 *
 * Approach
 * If we see it this way it can be think of it as representation of binary numbers(like subsequence)
 * with little variation
 * here if values is 0 include the character else calculate the count value
 */

public class PrintAbbreviations {
    public static void printAbbreviations(String str, String asf, int count, int pos){
        if(pos == str.length()){
            if(count == 0){
                System.out.println(asf);
            }
            else{
                System.out.println(asf+count);
            }
            return;
        }
        char ch = str.charAt(pos);
        if(count > 0){
            printAbbreviations(str, asf + count + ch, 0, pos+1);
        }
        else{
            printAbbreviations(str, asf + ch, 0, pos+1);
        }
        printAbbreviations(str, asf, count + 1, pos+1);
    }

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        printAbbreviations(str, "", 0, 0);
    }
}
