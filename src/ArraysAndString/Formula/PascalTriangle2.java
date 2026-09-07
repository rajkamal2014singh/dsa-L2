package ArraysAndString.Formula;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * print for a specific row values present in a pascal triangle
 * if we observe row represents values present for nCr for nCo to nCr
 *
 * we should find a mathematical factor to calculate the value since we know nCo is 1
 * nCr * factor = nCr+1
 * so the factor is (n-r)/(r+1)
 * here it looks like (i-j)*(j+1)
 *
 */
public class PascalTriangle2 {
    public static ArrayList<Integer> pascalRow(int i){
        ArrayList<Integer> res = new ArrayList<>();

        int val = 1;
        for(int j=0; j<=i; j++){
            res.add(val);
            val = val * (i-j)/(j+1);
        }

        return res;
    }
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int i = scn.nextInt();

        ArrayList<Integer> ans = pascalRow(i);

        System.out.println("Values for row " + i + " is : ");
        for(int val: ans){
            System.out.print(val);
        }
    }
}
