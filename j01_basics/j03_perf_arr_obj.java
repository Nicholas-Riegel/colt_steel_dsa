package j01_basics;
import java.util.HashMap;
import java.util.Arrays;

public class j03_perf_arr_obj {
    /*
    Big O of HashMap

    Insertion -   O(1) average case
    Removal -   O(1) average case  
    Searching -   O(n) checking to see if some information is in a value, O(1) for keys
    Access -   O(1)

    When you don't need any ordering, HashMap is an excellent choice!
    Constant time is the fastest
    Linear time is O(n)

    map.keySet() -   O(n)
    map.values() -   O(n)
    map.entrySet() -   O(n)
    map.containsKey() -   O(1)
    */

    /*
    Big O of ArrayList (dynamic)
    list.add() -   O(1) amortized (like push)
    list.remove(list.size()-1) -   O(1) (like pop)
    list.add(0, item) -   O(n) (like unshift)
    list.remove(0) -   O(n) (like shift)
    Collections.addAll() -   O(n) (like concat)
    list.subList() -   O(n) (like slice)
    Collections.sort() -   O(n log n)
    Stream operations -   O(n) (like forEach/map/filter)
    */
    public static void main(String[] args) {

        HashMap<String, Object> instructor = new HashMap<>();
        instructor.put("firstName", "Kelly");
        instructor.put("isInstructor", true);
        instructor.put("favoriteNumbers", new int[]{1,2,3,4});
        
        // System.out.println(instructor.entrySet());
        // To properly print the array contents:
        System.out.println("favoriteNumbers: " + Arrays.toString((int[]) instructor.get("favoriteNumbers")));
        
        // System.out.println(instructor.keySet());
        // System.out.println(instructor.values());
        // System.out.println(instructor.containsKey("firstName"));

    }

}
