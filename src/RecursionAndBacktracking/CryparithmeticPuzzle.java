package RecursionAndBacktracking;

import java.util.HashMap;
import java.util.Scanner;

public class CryparithmeticPuzzle {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);

        String str1 = scn.next();
        String str2 = scn.next();
        String str3 = scn.next();

        HashMap<Character, Integer> charIntMap = new HashMap<>();
        StringBuilder unique = new StringBuilder();
        for(int i=0; i< str1.length(); i++){
            char ch = str1.charAt(i);
            if (!charIntMap.containsKey(ch)){
                charIntMap.put(ch, -1);
                unique.append(ch);
            }
        }
        for(int i=0; i< str2.length(); i++){
            char ch = str2.charAt(i);
            if (!charIntMap.containsKey(ch)){
                charIntMap.put(ch, -1);
                unique.append(ch);
            }
        }
        for(int i=0; i< str3.length(); i++){
            char ch = str3.charAt(i);
            if (!charIntMap.containsKey(ch)){
                charIntMap.put(ch, -1);
                unique.append(ch);
            }
        }
        boolean[] usedNumber = new boolean[10];
        solvePuzzle(unique.toString(), 0, charIntMap, usedNumber, str1, str2, str3);
    }
    public static int getNum(String str, HashMap<Character, Integer> mp){
        String res = "";
        for(int i=0; i < str.length(); i++){
            char ch = str.charAt(i);
            int val = mp.get(ch);
            res += val;
        }

        return Integer.parseInt(res);
    }
    public static void solvePuzzle(String unique, int idx, HashMap<Character, Integer> charIntMap, boolean[] usedNumber, String s1, String s2, String s3){
        if(idx == unique.length()){
            int num1 = getNum(s1, charIntMap);
            int num2 = getNum(s2, charIntMap);
            int num3 = getNum(s3, charIntMap);

            if(num1 + num2 == num3){
                for(int i=0; i<26; i++){
                    char ch = (char)('a' + i);
                    if(charIntMap.containsKey(ch)){
                        System.out.print(ch + "-" + charIntMap.get(ch) + ",") ;
                    }
                }
                System.out.println();
            }

            return;
        }

        char ch = unique.charAt(idx);
        for(int num=0; num<=9; num++){
            if(usedNumber[num] == false){
                usedNumber[num] = true;
                charIntMap.put(ch, num);
                solvePuzzle(unique, idx + 1, charIntMap, usedNumber, s1, s2, s3);
                usedNumber[num] = false;
                charIntMap.put(ch, -1);
            }
        }
    }


}
