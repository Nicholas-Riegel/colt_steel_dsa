package j09_hash_tables;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.stream.Collectors;

public class HashTable {

    ArrayList< ArrayList<KeyValuePair> > keyMap;
    
    private static class KeyValuePair{

        String key;
        String value;

        KeyValuePair(String key, String value){
            this.key = key;
            this.value = value;
        }
    }

    @Override
    public String toString(){
        return keyMap
            .stream()
            .flatMap(ArrayList::stream)
            .map(kvp -> kvp.key + ": " + kvp.value)
            .collect(Collectors.joining("\n"));
    }

    HashTable(){
        this(53);
    }
    
    HashTable(int arrayLength){
        this.keyMap = new ArrayList<>();
        for (int i = 0; i < arrayLength; i++){
            keyMap.add(new ArrayList<>());
        }
    }

    public int _hash(String key) {
        int total = 0;
        int WEIRD_PRIME = 31;
        for (int i = 0; i < Math.min(key.length(), 100); i++) {
            char ch = key.charAt(i);
            int value = (int) ch - 96;
            total = (total * WEIRD_PRIME + value) % this.keyMap.size();
        }
        return total;
    }

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
    public ArrayList<String> keys(){
        return keyMap
            .stream()
            .flatMap(ArrayList::stream)
            .map(kvp -> kvp.key)
            .collect(Collectors.toCollection(ArrayList::new));
    }

    // get all values with duplicates
    public ArrayList<String> valuesWithDuplicates(){
        ArrayList<String> returnArray = new ArrayList<>();
        keyMap.forEach(bucket -> 
            bucket.forEach(kvp -> returnArray.add(kvp.value))
        );
        return returnArray;
    }

    // get all unique values
    public HashSet<String> uniqueValues(){
        HashSet<String> hashset = new HashSet<>();
        keyMap.forEach(bucket -> 
            bucket.forEach(kvp -> hashset.add(kvp.value))
        );
        return hashset;
    }


}