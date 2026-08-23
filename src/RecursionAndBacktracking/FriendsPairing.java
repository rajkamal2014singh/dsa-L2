package RecursionAndBacktracking;

import java.util.Scanner;

public class FriendsPairing {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        boolean[] isIncluded = new boolean[n+1];
        pairFriends(n, 1, isIncluded, "");
    }

    static int counter = 0;
    public static void pairFriends(int n, int i, boolean[] isIncluded, String asf){
        if(i > n){
            System.out.println(counter + "." + asf);
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
