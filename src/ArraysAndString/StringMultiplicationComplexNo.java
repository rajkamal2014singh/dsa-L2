package ArraysAndString;


import java.util.Scanner;

/**
 *
 * multiplication of a complex number
 * we know complex no is of format a + ib here we will make it as a + bi
 * we know i*i is -1
 * so (a+bi)*(c+di) = (ac - bd) + (cd + ad)i
 *
 *
 */
public class StringMultiplicationComplexNo {
    public static String multiply(String s1, String s2){
        int a = Integer.parseInt(s1.substring(0, s1.indexOf('+')));
        int b = Integer.parseInt(s1.substring(s1.indexOf('+') + 1, s1.length() - 1));
        int c = Integer.parseInt(s2.substring(0, s2.indexOf('+')));
        int d = Integer.parseInt(s2.substring(s2.indexOf('+') + 1, s2.length() - 1));

        String ans = (a*c - b*d) + "+" + (c*d + a*d) + "i";
        return ans;
    }
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        String s1 = scn.next();
        String s2 = scn.next();

        String res = multiply(s1, s2);
        System.out.println("Product for " + s1 + " and " +  s2 + " is " + res);
    }
}
