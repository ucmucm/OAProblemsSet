package LeetCode;
import java.util.*;

class Solution {
    public String nextTime(String time) {
        StringBuffer res = new StringBuffer();
        TreeSet<Integer> set = new TreeSet<>();
        for(int i=0; i<5; i++){
            if (i == 2) continue;
            set.add(time.charAt(i)-48);
        }
        int point = 0;
        for (int i=4; i>=0; i--){
            if (i == 2) {
                res.append(':');
                continue;
            }
            if (i == 4){
                if (set.higher(time.charAt(i)-48) == null) point = 1;
                if (point == 1) res.append(set.first());
                else res.append(set.higher(time.charAt(i)-48));
            }
            else if (i == 3){
                if (point == 0) res.append(time.charAt(i));
                else{
                    if (set.higher(time.charAt(i) - 48) == null || set.higher(time.charAt(i)-48) > 5) res.append(set.first());
                    else {
                        res.append(set.higher(time.charAt(i)-48));
                        point = 0;
                    }
                }
            }
            else if (i == 1){
                if (point == 0) res.append(time.charAt(i));
                else {
                    if (set.higher(time.charAt(i) - 48) == null || set.higher(time.charAt(i)-48) > 3) res.append(set.first());
                    else {
                        res.append(set.higher(time.charAt(i) - 48));
                        point = 0;
                    }
                }
            }
            else {
                if (point == 0) res.append(time.charAt(i));
                else{
                    if (set.higher(time.charAt(i)-48) == null || set.higher(time.charAt(i)-48) > 2) res.append(set.first());
                    else res.append(set.higher(time.charAt(i)-48));
                }
            }
        }
        res.reverse();
        return res.toString();
    }
}