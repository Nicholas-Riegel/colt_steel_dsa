package j10_graphs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class AdjacencyList{

    private HashMap<String, HashSet<String>> mainHashMapOfSets;
    
    // constructor
    // creates main hashmap
    public AdjacencyList(){
        mainHashMapOfSets = new HashMap<>();
    }

    // add vertex
    // using HashSet to optimize out duplicates
    public boolean addVertex(String vertex){

        if (mainHashMapOfSets.containsKey(vertex)) return true;
        
        mainHashMapOfSets.put(vertex, new HashSet<>());

        return true;
    }

    // have edge
    public boolean haveEdge(String v1, String v2){
        
        if (!mainHashMapOfSets.containsKey(v1) || !mainHashMapOfSets.containsKey(v2)) return false;
        
        else if (mainHashMapOfSets.get(v1).contains(v2) && mainHashMapOfSets.get(v2).contains(v1)) return true;
        
        else return false;
    }

    // add edge
    public boolean addEdge(String v1, String v2){

        if (haveEdge(v1, v2)) return true;
        
        if (!mainHashMapOfSets.containsKey(v1)) addVertex(v1);
        
        if (!mainHashMapOfSets.containsKey(v2)) addVertex(v2);
        
        mainHashMapOfSets.get(v1).add(v2);
        mainHashMapOfSets.get(v2).add(v1);
        
        return true;
    }

    // remove edge
    public boolean removeEdge(String v1, String v2){
        
        if (haveEdge(v1, v2)){
            mainHashMapOfSets.get(v1).remove(v2);
            mainHashMapOfSets.get(v2).remove(v1);
            return true;
        }
        return false;
    }

    // remove vertex
    public boolean removeVertex(String vertex){
        
        if (!mainHashMapOfSets.containsKey(vertex)) return false;

        for (String v : mainHashMapOfSets.get(vertex)) mainHashMapOfSets.get(v).remove(vertex);
        
        mainHashMapOfSets.remove(vertex);
        
        return true;
    }
    
    // get vertices
    public Set<String> getVertices(){
        return mainHashMapOfSets.keySet();
    }

    // to string 
    // @Override
    // public String toString(){
    //     return this.mainHashMapOfSets
    //         .entrySet()
    //         .stream()
    //         .map(kvp -> kvp.getKey() + ": " + kvp.getValue())
    //         .collect(Collectors.joining("\n"));
    // }
    
    // to string 
    @Override
    public String toString(){
        StringBuffer sb = new StringBuffer();
        boolean first = true;
        for (String key : mainHashMapOfSets.keySet()){
            if (!first) sb.append("\n"); // attaches a new line before each line
            String line = key + ": " + mainHashMapOfSets.get(key);
            sb.append(line);
            first = false;
        }
        return sb.toString();
    }
}