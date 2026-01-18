package j01_basics;
// Time complexity
// count the operations
// time is determined by number of operations
// Big O allows us to talk formally about how the runtime of an algorithm grows as the inputs grow

public class j01_bigO {

    public static int addUpTo(int n) {
        return n * (n + 1) / 2;
    }
    // has three operations
    // so the time complexity is O(3) => O(1)

    public static int addUpTo2(int n) {

        int total = 0; // 1 operation
        for (int i = 1; // 1 operation
            i <= n; // n operations
            i++) { // 2n operations (++ => += 1)
            total += i; // 2n operations (bc both + and =)
        }
        return total;
        // total operaions is 5n + 2
        // but this reduces to n
        // so the time complexity is O(n)
    }

    public static void countUpAndDown(int n) {
        System.out.println("Going up!");
        for (int i = 0; i < n; i++) {
            System.out.println(i);
        }
        System.out.println("At the top!\nGoing down...");
        for (int j = n - 1; j >= 0; j--) {
            System.out.println(j);
        }
        System.out.println("Back down. Bye!");
        // this would be O(2n) => O(n)
    }

    // nested loops are of course O(n^2)

    // constants don't matter
    // O(13n^2 + 10) => O(n^2)
    // O(n^2 + 5n + 8) => O(n^2)

    // RULES OF THUMB (they don't always hold)
    // Arithmetic operations are constant
    // Variable assignment is constant
    // Accessing elements in an array (by index) or object (by key) is constant
    // In a loop, the the complexity is the length of the loop times the complexity of whatever happens inside of the loop

    public static void logAtLeast5(int n) {
        for (int i = 1; i <= Math.max(5, n); i++) {
            System.out.println(i);
        }
    }
    // O(n) bc operations will grow as n grows

    public static void logAtMost5(int n) {
        for (int i = 1; i <= Math.min(5, n); i++) {
            System.out.println(i);
        }
    }
    // O(1) bc at most it will only be 5 operations

    
    
    // O(a + b) TIME COMPLEXITY
    // When you have separate, non-nested operations that depend on different inputs
    // Example: Two independent loops with different input sizes
    
    public static void processTwoInputs(int a, int b) {
        // First loop: O(a)
        for (int i = 0; i < a; i++) {
            System.out.println("Processing step " + i + " from first input");
        }
        
        // Second loop: O(b)
        for (int j = 0; j < b; j++) {
            System.out.println("Processing step " + j + " from second input");
        }
        
        // Total time complexity: O(a) + O(b) = O(a + b)
        // We DON'T simplify this to O(max(a,b)) because we don't know
        // which input is larger - they're independent variables
    }

    // O(a * b) TIME COMPLEXITY
    // When you have nested operations where one depends on input 'a' and another on input 'b'
    // Example: Nested loops with different input sizes
    
    public static void nestedOperations(int a, int b) {
        // Outer loop: runs 'a' times
        for (int i = 0; i < a; i++) {
            // Inner loop: runs 'b' times for EACH iteration of outer loop
            for (int j = 0; j < b; j++) {
                System.out.println("Operation " + i + ", " + j);
            }
        }
        
        // Total time complexity: O(a * b)
        // The inner loop runs 'b' times for each of the 'a' iterations
        // So total operations = a * b
    }

    // WHEN TO USE O(a + b) vs O(a * b):
    // 
    // O(a + b) - Sequential/Independent operations:
    // - Process 'a' items, then process 'b' items
    // - Read 'a' records, then read 'b' records
    // - Validate 'a' inputs, then validate 'b' inputs
    //
    // O(a * b) - Nested/Dependent operations:
    // - For each of 'a' items, do 'b' operations
    // - Nested loops where outer runs 'a' times, inner runs 'b' times
    // - Comparing every element in group A (size a) with every element in group B (size b)
    //
    // Common mistake: Assuming O(a + b) = O(n) where n = max(a,b)
    // This is wrong because a and b are independent variables!

    public static void main(String[] args){

    }
}
