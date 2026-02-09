package j09_hash_tables;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.stream.Collectors;

public class HashTable {

    // main arrayList to store subarrayLists
    private ArrayList< ArrayList<KeyValuePair> > keyMap;
    
    // Internal class to make key value pair objects
    private static class KeyValuePair{

        private String key;
        private String value;

        KeyValuePair(String key, String value){
            this.key = key;
            this.value = value;
        }
    }

    // toString method
    // Time complexity O(n)
    @Override
    public String toString(){
        return keyMap
            .stream()
            .flatMap(ArrayList::stream)
            .map(kvp -> kvp.key + ": " + kvp.value)
            .collect(Collectors.joining("\n"));
    }

    // Default constructor
    public HashTable(){
        this(53);
    }
    
    // Constructor
    // Time complexity: O(n)
    public HashTable(int arrayLength){
        this.keyMap = new ArrayList<>();
        for (int i = 0; i < arrayLength; i++){
            keyMap.add(new ArrayList<>());
        }
    }

    // Hash function to distrubute key value pairs randomly into array "buckets"
    // Time complexity: O(1)
    public int _hash(String key) {
        
        int total = 0;
        int PRIME = 31;
        
        for (int i = 0; i < Math.min(key.length(), 100); i++) {
            char ch = key.charAt(i);
            int value = (int) ch - 96;
            total = (total * PRIME + value) % this.keyMap.size();
        }
        return total;
    }

    // Set method to set key value pairs randomly into array buckets
    // Time complexity: O(1) bc hopefully the buckets will be small
    public void set(String key, String value){

        int hashIndex = _hash(key);
        ArrayList<KeyValuePair> bucket = keyMap.get(hashIndex);

        for (KeyValuePair kvp : bucket){
            if (kvp.key.equals(key)){
                kvp.value = value;
                return;
            }
        }

        KeyValuePair kvp = new KeyValuePair(key, value);
        bucket.add(kvp);
    }
    
    // get method
    // Time complexity: O(1) bc hopefully the buckets will be small
    public String get(String key){

        int hashIndex = _hash(key);
        ArrayList<KeyValuePair> bucket = keyMap.get(hashIndex);

        for (KeyValuePair kvp : bucket){
            if (kvp.key.equals(key)){
                return kvp.value;
            }
        }
        return null;
    }

    // get all keys
    // Time complexity: O(n) because dump
    public ArrayList<String> keys(){
        return keyMap
            .stream()
            .flatMap(ArrayList::stream)
            .map(kvp -> kvp.key)
            .collect(Collectors.toCollection(ArrayList::new));
    }

    // get all values with duplicates
    // Time complexity: O(n) because dump
    public ArrayList<String> values(){
        
        ArrayList<String> returnArray = new ArrayList<>();
        
        keyMap.forEach(
            bucket -> bucket.forEach(
                kvp -> returnArray.add(kvp.value)
            )
        );
        return returnArray;
    }

    // get all unique values
    // Time complexity: O(n) because dump
    public HashSet<String> uniqueValues(){
        
        HashSet<String> hashSet = new HashSet<>();
        
        keyMap.forEach(
            bucket -> bucket.forEach(
                kvp -> hashSet.add(kvp.value)
            )
        );
        return hashSet;
    }
}