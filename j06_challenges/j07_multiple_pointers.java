package j06_challenges;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class j07_multiple_pointers{

    // Multiple Pointers - averagePair
    // Write a function called averagePair. Given a sorted array of integers and a target average, determine if there is a pair of values in the array where the average of the pair equals the target average. There may be more than one pair that matches the average target.

    // Bonus Constraints:
    // Time: O(N)
    // Space: O(1)

    public static boolean averagePair(int[] arr, double avg){

        if (arr == null || arr.length < 2) return false;

        int firstIdx = 0;
        int lastIdx = arr.length - 1;
        double ptrAvg;

        while (firstIdx < lastIdx){
            ptrAvg = ((double) (arr[firstIdx] + arr[lastIdx])) / 2; 
            if (ptrAvg == avg) return true;
            // this is better due to binary to base 10 errors
            // if (Math.abs(ptrAvg - avg) < 1e-9) return true; 1e-9 => 1 * 10^-9
            else if (ptrAvg > avg) lastIdx--;
            else firstIdx++;
        }
        
        return false;
    }

    // Multiple Pointers - isSubsequence
    // Write a function called isSubsequence which takes in two strings and checks whether the characters in the first string form a subsequence of the characters in the second string. In other words, the function should check whether the characters in the first string appear somewhere in the second string, without their order changing.
    // Your solution MUST have AT LEAST the following complexities:
    // Time Complexity - O(N + M)
    // Space Complexity - O(1)

    // Ot(n), Os(1)
    public static boolean isSubsequence(String str1, String str2){

        // guards
        if (str1 == null || str2 == null) return false;
        if (str1.length() == 0) return true;
        
        // index for crawling through str1
        int idx1 = 0;

        // for each letter in str1 go through str2 until you have a match
        // then advance idx1 then continue in str2 until you have a match
        for (int idx2 = 0; idx2 < str2.length(); idx2++){

            if (str1.charAt(idx1) == str2.charAt(idx2)){
            
                if (idx1 < str1.length() - 1) idx1++;
                // if the last one in str1 has a match, return true
                else return true;
            }
        }

        return false;
    }
        // Frequency Counter / Multiple Pointer findPair
        // Given an unsorted array and a number n, find if there exists a pair of elements in the array whose difference is n. This function should return true if the pair exists or false if it does not.
        // Part 1 - solve this with the following requirements:
        // Time Complexity Requirement - O(n)
        // Space Complexity Requirement - O(n)
        // Part 2 - solve this with the following requirements:
        // Time Complexity Requirement - O(n log n)
        // Space Complexity Requirement - O(1)

        // Ot(n^2), 0s(1)
        // public static boolean findPair(int[] arr, int n){
            
        //     if (arr.length < 2) return false;

        //     int idx1 = 0;
        //     int idx2 = 1;

        //     while (idx1 < arr.length-1){
        //         while (idx2 < arr.length){
        //             if (arr[idx1] - arr[idx2] == n || arr[idx2] - arr[idx1] == n) return true;
        //             idx2++;
        //         }
        //         idx1++;
        //         idx2 = idx1 + 1;
        //     }
        //     return false;
        // }
        
        // Ot(n), Os(n)
        public static boolean findPair(int[] arr, int n){
            
            if (arr == null || arr.length < 2) return false;
            
            Map<Integer, Integer> map = new HashMap<>();
            
            for (int i : arr){
                map.put(i, map.getOrDefault(i, 0) + 1);
            }

            // n = 0 is a special case where i + n = i
            // so 0 will only be true if there is a duplicate
            if (n == 0){
                for (int key : map.keySet()){
                    if (map.get(key) > 1) return true;
                }
                return false;
            }

            for (int i : arr){
                if (map.containsKey(i + n)) return true;
            }
            
            return false;
        }
        
        // Chat's solution Ot(n), Os(n)
        // public static boolean findPair(int[] arr, int n){
            
        //     if (arr == null || arr.length < 2) return false;
            
        //     Set<Integer> seen = new HashSet<>();
            
        //     for (int num : arr){
        //         if (seen.contains(num - n)) return true;
        //         if (seen.contains(num + n)) return true;
        //         seen.add(num);
        //     }
            
        //     return false;
        // }

        public static void main(String[] args) {
                
        // System.out.println(averagePair(new int[]{1,2,3}, 2.5)); // true
        // System.out.println(averagePair(new int[]{1,3,3,5,6,7,10,12,19}, 8)); // true
        // System.out.println(averagePair(new int[]{-1,0,3,4,5,6}, 4.1)); // false
        // System.out.println(averagePair(new int[]{}, 4)); // false

        // System.out.println(isSubsequence("hello", "hello world")); // true
        // System.out.println(isSubsequence("sing", "sting")); // true
        // System.out.println(isSubsequence("abc", "abracadabra")); // true
        // System.out.println(isSubsequence("abc", "acb")); // false (order matters)
        // System.out.println(isSubsequence("aab", "abac")); // false
        // System.out.println(isSubsequence("z", "abc")); // false

        // System.out.println(findPair(new int[]{6,1,4,10,2,4}, 2)); // true
        // System.out.println(findPair(new int[]{8,6,2,4,1,0,2,5,13},1)); // true
        // System.out.println(findPair(new int[]{4,-2,3,10},-6)); // true
        // System.out.println(findPair(new int[]{6,1,4,10,2,4}, 22)); // false
        // System.out.println(findPair(new int[]{}, 0)); // false
        // System.out.println(findPair(new int[]{5,5}, 0)); // true
        // System.out.println(findPair(new int[]{-4,4}, -8)); // true
        // System.out.println(findPair(new int[]{-4,4}, 8)); // true
        // System.out.println(findPair(new int[]{1,3,4,6},-2)); // true
        // System.out.println(findPair(new int[]{0,1,3,4,6},-2)); // true
        // System.out.println(findPair(new int[]{1,2,3}, 0)); // false
    }
}