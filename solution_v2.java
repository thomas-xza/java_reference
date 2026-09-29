import java.util.Collections;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

class Solution {
    public int solution(int[] A) {
        // Implement your solution here

        int i;

        int[] xs = new int[1000005];

        for (int elem : A) {
            if (elem >= 0) {
                xs[elem] = 1;
            }
        }

        // for (Map.Entry<Integer, Integer> kvp : kv_store.entrySet()) {
        //     System.out.printf("Key = %d, Value = %d\n", kvp.getKey(), kvp.getValue());
        // }

        int lowest = 1;
        boolean found = false;

        for (i = 1; i <= 1000000 ; i++) {
            if (xs[i] == 0 && found == false) {
                //System.out.printf("Key = %d, Value = %d\n", i, kv_store.getOrDefault(i, 0));
                lowest = i;
                found = true;
                break;
            }
        }

        return lowest;

    }
}
