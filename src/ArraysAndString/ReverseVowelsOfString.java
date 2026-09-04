package ArraysAndString;

import java.util.Scanner;

/**
 *
 * create a string such that the order of vowels is reversed in the string
 * time complexity O(n)
 * extra space O(n)
 * since string is immutable in java we can use extra space
 *
 * example - weasrtnomirqu -> wuisrtnomarqe
 *
 */
public class ReverseVowelsOfString {
    public static boolean isVowel(char ch){
        if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'
          || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U'
        ){
            return true;
        }
        return false;
    }
    public static void swap(char[] ch, int left, int right){
        char temp = ch[left];
        ch[left] = ch[right];
        ch[right] = temp;
    }
    public static String reverseVowels(String str){
        char[] ch = str.toCharArray();

        int l = 0;
        int r = ch.length - 1;
        while(l<r){
            while(l<r && !isVowel(ch[l])){
                l++;
            }
            while(l<r && !isVowel(ch[r])){
                r--;
            }

            swap(ch, l, r);
            l++;
            r--;
        }

        String ans = "";
        for(char c: ch){
            ans += c;
        }
        return ans;
    }
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        String str = scn.next();

        System.out.println("String after vowel swap is : " + reverseVowels(str));
    }
}
