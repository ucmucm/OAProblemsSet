//有一个长度为N的花坛，每天开exactly一朵花，给定一个1-N的permutation，代表每天开花的位置。
//假设某一个时刻，i和j位置的花开了，且i和j之间没有别的花开，那么中间就有一个长度为j-i-1的empty slot（
//最左的花就考虑和花坛左端的empty slot，最右的考虑和花坛右端的empty slot）。
//给定permutation P和一个指定empty slot size K，返回最早是哪一天，花坛中出现了大小为K的empty slot，如果始终没有出现，返回-1。
//要求O(N)空间，O(NlogN)时间。


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
