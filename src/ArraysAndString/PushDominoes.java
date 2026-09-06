package ArraysAndString;

import java.util.Scanner;

/**
 *
 * Given a string that contains either L or R or .
 * L represents that force is applied towards left of, and it will fall towards left and if there is a dot on left
 * it will make it L
 * similar way R will fall on right and make . as R
 * we need to find the result after all the left and right falling is over
 *
 *
 * there can four scenarios
 *  ...L....R... -> LLLL....RRRR
 *  ...L....L... -> LLLLLLLLL...
 *  ...R....R... -> ...RRRRRRRRR
 *  ...R....L... -> ...RRRLLL...
 *  (4th case is a special case which can be split into two cases) if difference between indexes is odd that mean there
 *  are even dots, else if gap is even then there are odd no of dots we need to make sure the fill the dots or make
 *  dominoes fall in correct direction accordingly
 *
 *
 * note will add L at start and R at last this will not alter our result be help us in iteration

 R...L....L....R....R...L -> RR.LLLLLLL....RRRRRRR.L
 */
public class PushDominoes {
    public static void solveDomino(char[] ch, int j, int k){
        if(ch[j] == 'L' && ch[k] == 'R'){
            // L R
            // do nothing
        } else if(ch[j] == 'L' && ch[k] == 'L'){
            // L L
            for(int i = j+1; i<k; i++){
                ch[i] = 'L';
            }
        } else if(ch[j] == 'R' && ch[k] == 'R'){
            // R R
            for(int i = j+1; i<k; i++){
                ch[i] = 'R';
            }
        } else{
            // R L
            int diff = k - j;
            int mid = (k + j) / 2;
            if(diff % 2 == 0){
                // odd dots
                for(int i = j+1; i< mid; i++){
                    ch[i] = 'R';
                }
                for(int i = mid+1; i<k; i++){
                    ch[i] = 'L';
                }
            }
            else{
                // even dots
                for(int i = j+1; i<=mid; i++){
                    ch[i] = 'R';
                }
                for(int i = mid+1; i<k; i++){
                    ch[i] = 'L';
                }
            }
        }
    }
    public static String pushDomino(String str){
        int n = str.length();
        char[] ch = new char[n+2];
        ch[0] = 'L';
        ch[n+1] = 'R';
        for(int i=1; i<n; i++){
            char sch = str.charAt(i-1);
            ch[i] = sch;
        }

        int j = 0;
        int k = 1;
        while(k < ch.length){
            while(ch[k] == '.'){
                k++;
            }

            if(k - j > 1){
                solveDomino(ch, j, k);
            }
            j = k;
            k++;
        }

        StringBuilder ans = new StringBuilder();
        for(int i=1; i<n; i++){
            ans.append(ch[i]);
        }
        return ans.toString();
    }
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        String str = scn.next();

        String ans = pushDomino(str);
        System.out.println("String after dominoes affect " + ans);
    }
}
