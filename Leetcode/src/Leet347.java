/**
 * Created by sail on 5/23/16.
 * Code one more line :)
 */
import java.util.*;

public class Leet347 {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> ret = new ArrayList<>();
        Map<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(mp.containsKey(nums[i])) {
                mp.replace(nums[i], mp.get(nums[i]) + 1);
            } else {
                mp.put(nums[i], 1);
            }
        }

        Map<Integer, List<Integer>> mpRev = new TreeMap<>(Collections.reverseOrder());
        for (Map.Entry<Integer, Integer> entry: mp.entrySet()) {
            if(mpRev.containsKey(entry.getValue())) {
                mpRev.get(entry.getValue()).add(entry.getKey());
            } else {
                mpRev.put(entry.getValue(), new LinkedList<>());
                mpRev.get(entry.getValue()).add(entry.getKey());
            }
        }

        int cur = 0;
        for (Map.Entry<Integer, List<Integer>> entry: mpRev.entrySet()) {
//            System.out.println(entry.getKey() + ":");
            for (int value: entry.getValue()) {
//                System.out.println(value);
                if (cur < k) {
                    ret.add(value);
                    cur++;
                }
            }
//            System.out.println("========");
        }

        return ret;
    }
}
