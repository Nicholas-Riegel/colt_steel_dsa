package j06_challenges;

import java.util.ArrayList;
import java.util.HashMap;

class j03_frequency_counters{

    // Frequency Counter - sameFrequency
    // Write a function called sameFrequency. Given two positive integers, find out if the two numbers have the same frequency of digits.
    // Your solution MUST have the following complexities:
    // Time: O(N)

    public static boolean sameFrequency(int num1, int num2){
        
        String num1str = Integer.toString(num1);
        String num2str = Integer.toString(num2);

        HashMap<Character, Integer> freq1 = new HashMap<>();
        HashMap<Character, Integer> freq2 = new HashMap<>();

        for (char ch : num1str.toCharArray()){
            freq1.put(ch, freq1.getOrDefault(ch, 0) + 1);
        }
        
        for (char ch : num2str.toCharArray()){
            freq2.put(ch, freq2.getOrDefault(ch, 0) + 1);
        }
        
        return freq1.equals(freq2);
    }

    // Frequency Counter / Multiple Pointers - areThereDuplicates
    // Implement a function called, areThereDuplicates which accepts a variable number of arguments, and checks whether there are any duplicates among the arguments passed in.  You can solve this using the frequency counter pattern OR the multiple pointers pattern.

    // Restrictions:
    // Time - O(n)
    // Space - O(n)
    // Bonus:
    // Time - O(n log n)
    // Space - O(1)

    public static boolean areThereDuplicates(Object... items){

        HashMap<Object, Integer> freq = new HashMap<>();

        for (Object it : items){
            freq.put(it, freq.getOrDefault(it,  0) + 1);
            if (freq.get(it) > 1) return true;
        }

        return false;
    }

    // Frequency Counter - constructNote
    // Write a function called constructNote, which accepts two strings, a message and some letters. The function should return true if the message can be built with the letters that you are given, or it should return false.

    // Assume that there are only lowercase letters and no space or special characters in both the message and the letters.

    // Bonus Constraints:
    // If M is the length of message and N is the length of letters:
    // Time Complexity: O(M+N)
    // Space Complexity: O(N)

    public static boolean constructNote(String str1, String str2){

        HashMap<Character, Integer> freq1 = new HashMap<>();
        HashMap<Character, Integer> freq2 = new HashMap<>();

        for (char ch : str1.toCharArray()){
            freq1.put(ch, freq1.getOrDefault(ch, 0) + 1);
        }
        
        for (char ch : str2.toCharArray()){
            freq2.put(ch, freq2.getOrDefault(ch, 0) + 1);
        }

        for (char ch : freq1.keySet()){
            if (!freq2.containsKey(ch) || freq1.get(ch) > freq2.get(ch)){
                return false;
            }
        }
        return true;
    }

    // Frequency Counter - findAllDuplicates
    // Given an array of positive integers, some elements appear twice and others appear once. Find all the elements that appear twice in this array. Note that you can return the elements in any order.

    public static ArrayList<Integer> findAllDuplicates(int[] arr){

        ArrayList<Integer> result = new ArrayList<>();
        HashMap<Integer, Integer> freq = new HashMap<>();

        for (int i : arr){
            freq.put(i, freq.getOrDefault(i, 0) + 1);
            if (freq.get(i) > 1) result.add(i);
        }

        return result;
    }
    public static void main(String[] args) {

        // Frequency Counters 
        // System.out.println(sameFrequency(182,281)); // true
        // System.out.println(sameFrequency(34,14)); // false
        // System.out.println(sameFrequency(3589578, 5879385)); // true
        // System.out.println(sameFrequency(22,222)); // false

        // System.out.println(areThereDuplicates(1, 2, 3)); // false
        // System.out.println(areThereDuplicates(1, 2, 2)); // true 
        // System.out.println(areThereDuplicates('a', 'b', 'c', 'a')); // true 

        // System.out.println(constructNote("aa", "abc")); // false
        // System.out.println(constructNote("abc", "dcba")); // true
        // System.out.println(constructNote("aabbcc", "bcabcaddff")); // true

        System.out.println(findAllDuplicates(new int[]{4,3,2,7,8,2,3,1})); // array with 2 and 3
        System.out.println(findAllDuplicates(new int[]{4, 3, 2, 1, 0})); // []
        System.out.println(findAllDuplicates(new int[]{4, 3, 2, 1, 0, 1, 2, 3})); // array with 3, 2, and 1

    }
}