package RecursionAndBacktracking;

import java.util.Scanner;
/*
10
+ - + + + + + + + +
+ - + + + + + + + +
+ - + + + + + + + +
+ - - - - - + + + +
+ - + + + - + + + +
+ - + + + - + + + +
+ + + + + - + + + +
+ + - - - - - - + +
+ + + + + - + + + +
+ + + + + - + + + +
4
delhi
iceland
ankara
london

 */
public class CrossWord {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        char[][] chars = new char[n][n];

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                chars[i][j] = scn.next().charAt(0);
            }
        }

        int noOfWords = scn.nextInt();
        String[] words = new String[noOfWords];
        for(int i=0; i<words.length; i++){
            words[i] = scn.next();
        }

        solveCrossWord(chars, words, 0);
    }

    public static void print(char[][] chars){
        for(int i=0; i<chars.length; i++){
            for(int j=0; j<chars[0].length; j++){
                System.out.print(chars[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void solveCrossWord(char[][] chars, String[] words, int vidx){
        if(vidx == words.length){
            print(chars);
            System.out.println("----------------------");
            return;
        }

        String word = words[vidx];
        for(int i=0; i<chars.length; i++){
            for(int j=0; j<chars[0].length; j++){
                if(chars[i][j] == '-' || chars[i][j] == word.charAt(0)){
                    if(canBePlacedHorizontally(chars, word, i, j)){
                        boolean[] wePlaced = placeWordHorizontally(chars, word, i, j);
                        solveCrossWord(chars, words, vidx+1);
                        unplaceWordHorizontally(chars, word, i, j, wePlaced);
                    }
                    if(canBePlacedVertically(chars, word, i, j)){
                        boolean[] wePlaced = placeWordVertically(chars, word, i, j);
                        solveCrossWord(chars, words, vidx+1);
                        unplaceWordVertically(chars, word, i, j, wePlaced);
                    }
                }
            }
        }
    }
    public static boolean canBePlacedHorizontally(char[][] chars, String word, int i, int j){
        if(j-1 >=0 && chars[i][j-1] != '+'){
            return false;
        }
        else if(j+word.length() < chars[0].length && chars[i][j + word.length()] !='+'){
            return false;
        }

        for(int jj=0; jj < word.length(); jj++){
            if(chars[i][j + jj] == '-' || chars[i][j+jj] == word.charAt(jj)){
                continue;
            }
            else{
                return false;
            }
        }
        return true;
    }

    public static boolean canBePlacedVertically(char[][] chars, String word, int i, int j){
        if(i-1 >=0 && chars[i-1][j] != '+'){
            return false;
        }
        else if(i+word.length() < chars[0].length && chars[i + word.length()][j] !='+'){
            return false;
        }

        for(int ii=0; ii < word.length(); ii++){
            if(chars[i + ii][j] == '-' || chars[i + ii][j] == word.charAt(ii)){
                continue;
            }
            else{
                return false;
            }
        }
        return true;
    }

    public static boolean[] placeWordHorizontally(char[][] chars, String word, int i, int j){
        boolean[] wePlaced = new boolean[word.length()];
        for(int jj = 0; jj<word.length(); jj++){
            char ch = chars[i][j + jj];
            char sch = word.charAt(jj);
            if(ch == '-') {
                chars[i][j + jj] = sch;
                wePlaced[jj] = true;
            }
        }
        return wePlaced;
    }

    public static boolean[] placeWordVertically(char[][] chars, String word, int i, int j){
        boolean[] wePlaced = new boolean[word.length()];
        for(int ii = 0; ii<word.length(); ii++){
            char ch = chars[i + ii][j];
            char sch = word.charAt(ii);
            if(ch == '-') {
                chars[i + ii][j] = sch;
                wePlaced[ii] = true;
            }
        }
        return wePlaced;
    }

    public static void unplaceWordHorizontally(char[][] chars, String word, int i, int j, boolean[] wePlaced){
        for(int jj = 0; jj<word.length(); jj++){
            if(wePlaced[jj]){
                chars[i][jj + j] = '-';
            }
        }
    }
    public static void unplaceWordVertically(char[][] chars, String word, int i, int j, boolean[] wePlaced){
        for(int ii = 0; ii<word.length(); ii++){
            if(wePlaced[ii]){
                chars[ii + i][j] = '-';
            }
        }
    }
}
