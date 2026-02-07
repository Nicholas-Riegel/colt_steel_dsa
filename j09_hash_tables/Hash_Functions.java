package j09_hash_tables;

public class Hash_Functions {

    // function to reduce a string to a legitimate index in an array
    public static int hash1(String key, int arrayLength){
        int total = 0;
        for (char ch : key.toCharArray()){
            // (int)ch gets the unicode value
            // - 96 lets a = 1, b = 2, etc.
            int val = (int)ch - 96;
            total += val;
        }
        // % arrayLength gets a legitimate index for the array length
        return total % arrayLength;
    }
    // Problems:
    // Only hashes strings (we won't worry about this)
    // Not constant time - linear in key length
    // Could be a little more random

    // Better version
    public static int hash2(String key, int arrayLength) {
        
        int total = 0;
        int PRIME = 31;
        char[] charArray = key.toCharArray();
        
        // this will get the first 100 values of the string
        // because all we really need is a number
        for (int i = 0; i < Math.min(charArray.length, 100); i++) {
            char buchstaben = charArray[i];
            int value = (int)buchstaben - 96;
            // multiplying by the prime reduces collisions, spreads them out more
            total = (total * PRIME + value);
        }
        return total % arrayLength;
    }
}
