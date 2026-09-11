package RecursionAndBacktracking;

import java.util.Scanner;

/**
 *
 * Given a number, n represents no of friends from 1 to n.
 * Each one can remain single or can pair with some other friend
 * print all the possible configuration in which friend can remain single or can be paired up
 * we need unique combinations
 *
 * Approach
 * For every value i if it is already used move to next
 * If not used it can either remain single or pair with next elements(we need combination) so paring up with next friends only
 * while going single or pairing up remember to mark the no as used and when falling back mark as unused
 *
 *
 */
public class FriendsPairing {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        counter = 1;
        boolean[] isIncluded = new boolean[n+1];
        pairFriends(n, 1, isIncluded, "");
    }

    static int counter;
    public static void pairFriends(int n, int i, boolean[] isIncluded, String asf){
        if(i > n){
            System.out.println(counter + "." + asf);
            counter++;
            return;
        }
        if(isIncluded[i]){
            pairFriends(n, i+1, isIncluded, asf);
        }
        else{
            isIncluded[i] = true;
            pairFriends(n, i+1, isIncluded, asf + "(" + i + ")");
            for(int j = i+1; j<=n; j++){
                if(isIncluded[j] == false){
                    isIncluded[j] = true;
                    pairFriends(n, i+1, isIncluded, asf + "(" + i + "," + j + ")");
                    isIncluded[j] = false;
                }
            }
            isIncluded[i] = false;
        }
    }
}
