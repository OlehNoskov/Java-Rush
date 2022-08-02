package ua.com.javarush.other.stringreader_stringwriter;

/***
 * Возможенн ли палиндром
 */

public class IsPalindrome {
    public static void main(String[] args) {
        System.out.println(isPalindromePermutation("oleole"));
    }

    public static boolean isPalindromePermutation(String s) {
        boolean foundOdd = false;
        int[] tableCount = new int[256];

        for (char c : s.toLowerCase().toCharArray()) {
            tableCount[c] += 1;
        }

        for (int count : tableCount) {
            if (count % 2 != 0) {
                if (foundOdd) {
                    return false;
                }
                foundOdd = true;
            }
        }

        return true;
    }
}
