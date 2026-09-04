package ArraysAndString;

import java.util.Scanner;

public class StringAddition {
    public static String calculateSum(String num1, String num2){
        String res = "";
        int carry = 0;

        int i = num1.length() - 1;
        int j = num2.length() - 1;

        while (i>=0 || j>=0 || carry >0){
            int val1 = i >= 0 ? num1.charAt(i) - '0' : 0;
            int val2 = j >= 0 ? num2.charAt(j) - '0' : 0;

            int sum = val1 + val2 + carry;
            res = (sum % 10) + res;
            carry = sum / 10;

            i--;
            j--;
        }

        return res;
    }
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        String num1 = scn.next();
        String num2 = scn.next();

        String sum = calculateSum(num1, num2);
        System.out.println("Sum of " + num1 + "+" +  num2 + " -> " + sum);
    }
}
