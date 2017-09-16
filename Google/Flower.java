package LeetCode;
import java.util.*;

class Solution {
    public int theEarlyDay(int[] order, int size) {
        int len = order.length;
        TreeSet<Integer> set = new TreeSet<>();
        for (int i=0; i<len; i++){
            set.add(order[i]);
            int left = 0, right = 0;
            if (set.lower(order[i]) == null) left = order[i] - 1;
            else left = order[i] - set.lower(order[i]) - 1;
            if (left == size) return i+1;
            if (set.higher(order[i]) == null) right = len - order[i];
            else right = set.higher(order[i]) - order[i] - 1;
            if (right == size) return i+1;
        }
        return -1;
    }
}