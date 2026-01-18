package j01_basics;
// PROBLEM SOLVING PATTERNS
// Frequency Counter
// Multiple Pointers
// Sliding Window
// Divide and Conquer
// Dynamic Programming
// Greedy Algorithms
// Backtracking
// Many more!

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class j05_prob_solve_patterns {

    // FREQUENCY PATTERN
    // This pattern uses objects or sets to collect values/frequencies of values
    // This can often avoid the need for nested loops or O(N^2) operations with arrays / strings

    // Challenge:
    // Write a function called same, which accepts two arrays. The function should return true if every value in the array has it's corresponding value squared in the second array. The frequency of values must be the same.

    public static boolean same(int[] arr1, int[] arr2){
        
        if (arr1.length != arr2.length) return false;
        
        HashMap<Integer, Integer> map1 = new HashMap<>();
        HashMap<Integer, Integer> map2 = new HashMap<>();
        
        for (int i : arr1) map1.put(i, map1.getOrDefault(i, 0) + 1);
        for (int i : arr2) map2.put(i, map2.getOrDefault(i, 0) + 1);
        
        for (int i : map1.keySet()){
            if (map1.get(i) != map2.get(i*i)) return false;
        }
        
        return true;
    }

    // MULTIPLE POINTERS
    // Write a function called sumZero which accepts a sorted array of integers. The function should find the first pair where the sum is 0. Return an array that includes both values that sum to zero or undefined if a pair does not exist

    public static int[] sumZero(int[] sorted){
        
        int start = 0;
        int end = sorted.length - 1;
        
        while (start < end){
            if (sorted[start] + sorted[end] > 0){
                end--;
            } else if (sorted[start] + sorted[end] < 0){
                start++;
            } else {
                return new int[]{sorted[start], sorted[end]};
            }
        }
        
        return null;
    }

    // Count Unique Values
    // Implement a function called countUniqueValues, which accepts a sorted array, and counts the unique values in the array, ie it ignores all duplicates There can be negative numbers in the array, but it will always be sorted.

    public static int countUniqueValues(int[] sorted){
        
        int count = 0;
        if (sorted.length > 0) count++;
        int base = 0;
        int mover = 1;
        
        while (mover < sorted.length){
            if (sorted[base] != sorted[mover]){
                count++;
                base = mover;
                mover++;
            } else {
                mover++;
            }
        }
        
        return count;
    }

    // SLIDING WINDOW
    // Write a function called maxSubarraySum which accepts an array of integers and a number called n. The function should calculate the maximum sum of n consecutive elements in the array.

    public static Integer maxSubarraySum(int[] arr, int n){
        
        if (n > arr.length || n <= 0 || arr.length < 1) return null; 
        
        int subSum = 0;

        for (int i = 0; i < n; i++){ 
            subSum += arr[i]; 
        }

        int max = subSum;

        for (int i = 0; i < arr.length - n; i++){
            subSum -= arr[i];
            subSum += arr[i + n];
            if (subSum > max){
                max = subSum;
            }
        }

        return max;
    }

    // DIVIDE AND CONQUER
    // Binary search
    // he only introduces this concept, because he will get more into it later on
    // Given a sorted array of integers, write a function called search, that accepts a value and returns the index where the value passed to the function is located. If the value is not found, return -1

    public static int search(int[] sorted, int n){

        int start = 0;
        int end = sorted.length - 1;
        
        while (start <= end) {

            int mid = (start + end) / 2;
            
            if (sorted[mid] < n){
                start = mid + 1;
            } else if (sorted[mid] > n){
                end = mid - 1;
            } else {
                return mid;
            }
        }

        return -1;
    }
    // this has O(log n) time complexity
    
    public static void main(String[] args) {
        
        // FREQUENCY PATTERN
        // int[] arr1 = new int[]{1, 2};
        // int[] arr2 = new int[]{1, 4};
        // System.out.println(same(arr1, arr2));

        // MULTIPLE POINTERS
        // System.out.println(
        //     Arrays.toString(
        //         sumZero(new int[]{-1, 0, 1, 12})
        //     )
        // );

        // Count Uniqe values
        // System.out.println(
        //     countUniqueValues(new int[]{-1, -1, 1, 2, 2, 3})
        // );

        // SLIDING WINDOW
        // System.out.println(
        //     maxSubarraySum(new int[]{1, 2, 3, 4, 5, 2, 1}, 3)
        // );

        // DIVIDE AND CONQUER
        System.out.println(search(new int[]{1, 2, 3, 4, 5}, 0));
        System.out.println(search(new int[]{1, 2, 3, 4, 5}, 1));
        System.out.println(search(new int[]{1, 2, 3, 4, 5}, 4));
        System.out.println(search(new int[]{1, 2, 3, 4, 5}, 5));
        System.out.println(search(new int[]{1, 2, 3, 4, 5}, 6));
        
    }
}
