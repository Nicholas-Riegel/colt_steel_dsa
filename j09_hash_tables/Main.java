package j09_hash_tables;

public class Main {

    public static void main(String[] args) {

        String[] list = {"pink", "blue", "red", "green", "white"};
        for (String word : list){
            // System.out.println(Hash_Table.hash1(word, 10));
            System.out.println(Hash_Table.hash2(word, 10));
            // not much of a difference because numbers are too small
        }
    }
}
