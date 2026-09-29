class Solution {
    public int solution(int[] A) {
        // Implement your solution here

        int i;

        Map<Integer, Integer> kv_store = new HashMap<>();

        for (int elem : A) {
            kv_store.put(elem, kv_store.getOrDefault(elem, 0) + 1);
        }

        // for (Map.Entry<Integer, Integer> kvp : kv_store.entrySet()) {
        //     System.out.printf("Key = %d, Value = %d\n", kvp.getKey(), kvp.getValue());
        // }

        int lowest = 1;
        boolean found = false;

        for (i = 1; i <= 1000000 ; i++) {
            if (kv_store.getOrDefault(i, 0) == 0 && found == false) {
                System.out.printf("Key = %d, Value = %d\n", i, kv_store.getOrDefault(i, 0));
                lowest = i;
                found = true;
            }
        }

        return lowest;

    }
}
