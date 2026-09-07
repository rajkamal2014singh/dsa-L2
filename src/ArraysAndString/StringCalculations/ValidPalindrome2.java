package ArraysAndString.StringCalculations;

import java.util.Scanner;

/**
 *
 * A string is said to be a valid palindrome when by removing any one character at max makes the string a palindrome
 * Time constraint - O(n), Space - O(1)
 *
 * approach similar as palindrome keep two pointers on start and end
 * move the pointer till characters are equal
 * in case of not equal check for the remaining string by removing one character on both the substring
 * if any one the substring is a palindrome then it is a valid palindrome 2
 *
 * Example -
 * abcefcba -> true -> remove e or f
 * abcefacba -> false
 * abceaacba -> true -> remove e
 *
 *
 */
public class ValidPalindrome2 {
    public static boolean isPalindrome(String str, int l, int r){
        while(l < r){
            if(str.charAt(l) != str.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    public static boolean validPalindrome(String str){
        int l = 0;
        int r = str.length() - 1;

        while (l < r){
            if(str.charAt(l) == str.charAt(r)){
                l++;
                r--;
            }
            else{
                return isPalindrome(str, l, r-1) || isPalindrome(str, l+1, r);
            }
        }
        return true;
    }

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        String str = scn.next();

        System.out.println("Can " + str + " become valid palindrome " + validPalindrome(str));
    }
}
