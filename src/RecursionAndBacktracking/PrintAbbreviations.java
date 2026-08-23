package RecursionAndBacktracking;

import java.util.Scanner;

public class PrintAbbreviations {
    public static void printAbbreviations(String str, String asf, int count, int pos){
        if(pos == str.length()){
            if(count == 0){
                System.out.println(asf);
            }
            else{
                System.out.println(asf+count);
            }
            return;
        }
        char ch = str.charAt(pos);
        if(count > 0){
            printAbbreviations(str, asf + count + ch, 0, pos+1);
        }
        else{
            printAbbreviations(str, asf + ch, 0, pos+1);
        }
        printAbbreviations(str, asf, count + 1, pos+1);
    }

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        printAbbreviations(str, "", 0, 0);
    }
}
