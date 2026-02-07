package j09_hash_tables;

public class Main {

    public static void main(String[] args) {

        HashTable ht = new HashTable();
        ht.set("name", "John");
        ht.set("age", "25");
        ht.set("name", "Jane"); 
        ht.set("email", "jane@email.com"); 
        ht.set("company", "Jane"); 
        
        System.out.println(ht.valuesWithDuplicates());
    }
}
