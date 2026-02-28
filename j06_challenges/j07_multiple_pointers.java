package j06_challenges;

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
                // if the last one has a match, return true
                else return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
                
        // System.out.println(averagePair(new int[]{1,2,3}, 2.5)); // true
        // System.out.println(averagePair(new int[]{1,3,3,5,6,7,10,12,19}, 8)); // true
        // System.out.println(averagePair(new int[]{-1,0,3,4,5,6}, 4.1)); // false
        // System.out.println(averagePair(new int[]{}, 4)); // false

        System.out.println(isSubsequence("hello", "hello world")); // true
        System.out.println(isSubsequence("sing", "sting")); // true
        System.out.println(isSubsequence("abc", "abracadabra")); // true
        System.out.println(isSubsequence("abc", "acb")); // false (order matters)
        System.out.println(isSubsequence("aab", "abac")); // false
        System.out.println(isSubsequence("z", "abc")); // false

    }
}