package ArraysAndString;

import java.util.Scanner;

/**
 *
 * Give a string the consists of numeric character with one swap make the max possible string
 *
 * example ->
 * 2736 -> 7236
 * 99367892 -> 99967832
 *
 * Approach 0
 * for each index i start from end to i+1 and get the max value if max is greater than current swap that with current
 * but this take O(n^2) time complexity
 *
 * Approach 1
 * create a rax max integer char value array and store the index of max value from right
 * for each element check if the index value in right max is grater than current at first occurance swap with that value
 * this approach takes O(n) time and extra O(n) space complexity
 *
 * Approach 2
 * create a constant size array of size 10
 * for each 0 to 9 store the right most index
 * and traverse on string and check in the created array greater values index in reverse order if any greater value
 * have index greater than i swap with that
 * this approach also takes O(n) time and constant extra space
 *
 */
public class MaximumSwap {
    public static void swap(char[] ch, int l, int r){
        char lch = ch[l];
        ch[l] = ch[r];
        ch[r] = lch;
    }
    public static String maxNumber(String num){
        char[] ch = num.toCharArray();
        int[] idx = new int[10];
        for(int i=0; i<ch.length; i++){
            int val = ch[i] - '0';
            idx[val] = i;
        }

        for(int i=0; i<ch.length; i++){
            int lv = ch[i] - '0';
            boolean flag = false;
            for(int j=9; j>lv; j--){
                if(idx[j] > i){
                    swap(ch, i, idx[j]);
                    flag = true;
                    break;
                }
            }
            if(flag){
                break;
            }
        }

        StringBuilder ans = new StringBuilder();
        for(char it: ch){
            ans.append(it);
        }
        return ans.toString();
    }
    public static String maxNumber1(String num){
        int n = num.length();
        char[] ch = num.toCharArray();
        int[] rightMaxIdx = new int[n];

        rightMaxIdx[n-1] = n-1;
        for(int i=n-2; i>=0; i--){
            char rmax = ch[rightMaxIdx[i+1]];
            if(ch[i] > rmax){
                rightMaxIdx[i] = i;
            }
            else{
                rightMaxIdx[i] = rightMaxIdx[i+1];
            }
        }

        for(int i=0; i<n; i++){
            int lv = ch[i] - '0';
            int rv = ch[rightMaxIdx[i]] - '0';

            if(rv > lv){
                swap(ch, i, rightMaxIdx[i]);
                break;
            }
        }

        StringBuilder ans = new StringBuilder();
        for(char it: ch){
            ans.append(it);
        }
        return ans.toString();
    }
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        String str = scn.next();

        System.out.println("String after swap 1 " + maxNumber(str));
//        System.out.println("String after swap 2 " + maxNumber1(str));
    }
}
