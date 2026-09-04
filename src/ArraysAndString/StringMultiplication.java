package ArraysAndString;

import java.util.Scanner;

/**
 * Given two string give the multiplication/product of the string.
 * String can be of size 20
 * so converting it to integer and calculating it is not possible
 * remove if there is zero at start of result
 * string will contain numeric values only
 *
 */
public class StringMultiplication {
    public static String calculateProduct(String num1, String num2){
        if(num1.equals("0") || num2.equals("0")){
            return "0";
        }

        int l1 = num1.length();
        int l2 = num2.length();
        int[] res = new int[l1 + l2];

        int i = l2 - 1;
        int pf = 0; // power factor
        while(i>=0){
            int ival = num2.charAt(i) - '0';
            i--;

            int j = l1 - 1;
            int k = res.length - 1 - pf;
            int carry = 0;

            while(j>=0 || carry !=0){
                int jval = j>=0 ? num1.charAt(j) - '0' : 0;
                j--;

                int prod = ival * jval + carry + res[k];

                res[k] = prod % 10;
                carry = prod / 10;
                k--;
            }
            pf++;
        }

        String ans = "";
        int s = 0;
        while(res[s] == 0){
            s++;
        }

        while (s<res.length){
            ans += res[s];
            s++;
        }
        return ans;
    }
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        String num1 = scn.next();
        String num2 = scn.next();

        String product = calculateProduct(num1, num2);
        System.out.println("Product of " + num1 + "*" +  num2 + " -> " + product);
    }
}
