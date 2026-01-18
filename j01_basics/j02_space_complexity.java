package j01_basics;
import java.util.ArrayList;

public class j02_space_complexity {

    // SPACE COMPLEXITY
    // Rules of thub
    // has to do with what sorts of things are assigned in the algorithm
    // 1. Most primitives (booleans, number, undefined, null) are constant space
    // 2. Strings require O(n) space (where n is the string length), if they grow
    // 3. Reference types are O(n), where n is the length (for arrays) or number of keys (for objects), if they grow  

    public static int sum(int[] arr){
        int total = 0;
        for (int i = 0; i < arr.length; i++){
            total += arr[i];
        }
        return total;
    }

    // since we are not concerned about the input, there are only two assignments (total and i). so it has a space complexity of O(2) i.e. O(1)

    public static ArrayList<Integer> doublify(int[] arr){
        ArrayList<Integer> newArr = new ArrayList<>();
        for (int i = 0; i<arr.length; i++){
            newArr.add(2 * arr[i]);
        }
        return newArr;
    }
    
    // => O(n) because array have O(n) space. the size of the array grows with length of arr

    // Quiz
    // 1. 
    public static void logUpTo(int n) {
        for (int i = 1; i <= n; i++) {
            System.out.println(i);
        }
    }
    // => Os(1)

    // 2.
    public static void logAtMost10a(int n) {
        for (int i = 1; i <= Math.min(n, 10); i++) {
            System.out.println(i);
        }
    }
    // => Os(1)

    // 3.
    public static void logAtMost10b(int n) {
        for (int i = 1; i <= Math.min(n, 10); i++) {
            System.out.println(i);
        }
    }

    // =>Os(1)

    // 4.
    public static ArrayList<Integer> onlyElementsAtEvenIndex(int[] array) {
        ArrayList<Integer> newArray = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if (i % 2 == 0) {
                newArray.add(array[i]);
            }
        }
        return newArray;
    }

    // or

    // public int[] onlyElementsAtEvenIndex(int[] array) {
    //     int[] newArray = new int[(array.length + 1) / 2];  // Ceiling division
    //     int index = 0;
    //     for (int i = 0; i < array.length; i++) {
    //         if (i % 2 == 0) {
    //             newArray[index++] = array[i];
    //         }
    //     }
    //     return newArray;
    // }
    
    // => Os(n)

    // 5.
    public static int[] subtotals(int[] array) {
        int[] subtotalArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            int subtotal = 0;
            for (int j = 0; j <= i; j++) {
                subtotal += array[j];
            }
            subtotalArray[i] = subtotal;
        }
        return subtotalArray;
    }
    // =>Os(n) bc you're assigning an array

    // LOGARITHMS
    // log2(8) = 3
    // log2 (value) = exponent
    // for our purposes log === log2

    // Rule of thumb:
    // The binary logarithm of a number is how many times you can divide it by 2 until (inclusive) you get a number less than or equal to 1.
    // log2(8) = 3

    // 8/2 = 4
    // 4/2 = 2
    // 2/2 = 1 

    // {{
    //     When the number is a power of 2:
    //     For example, 8 is a power of 2 (2³), so dividing it by 2 repeatedly will eventually get you exactly to 1. In this case, the binary logarithm gives you the exact number of divisions, which matches the exponent in the power of 2.
        
    //     When the number is not a power of 2:
    //     For numbers that are not powers of 2 (e.g., 10), dividing by 2 repeatedly will result in a number less than 1 before you exactly reach 1. Here's an example:
        
    //     10 ÷ 2 = 5
    //     5 ÷ 2 = 2.5
    //     2.5 ÷ 2 = 1.25
    //     1.25 ÷ 2 = 0.625 (now less than 1)
    //     The binary logarithm of 10 is approximately 3.32, meaning it takes about 3.32 divisions to reduce 10 to 1 (log₂(10) ≈ 3.32).
    // }}

    // O(log n) is only slighly worse than O(1)
    // and much better than O(n)

    public static void main(String[] args){

        logAtMost10b(3);
    }

}
