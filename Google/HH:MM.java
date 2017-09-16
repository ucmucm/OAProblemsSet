//给一个string，形式"HH:MM"，比如"15:43"。要求返回：利用出现的数字（可以重复，可以不用）组成的时间中，最接近input的下一个时刻
//比如之前的例子，就是"15:44"。如果input是"23:59"就返回"22:22"。没有时间空间要求。


class Solution {
    public String nextTime(String time) {
        StringBuffer res = new StringBuffer();
        TreeSet<Integer> set = new TreeSet<>();
        for(int i=0; i<5; i++){
            if (i == 2) continue;
            set.add(time.charAt(i)-48);
        }
        int point = 0;
        // 最后一位
        if (set.higher(time.charAt(4)-48) == null) point = 1;
        if (point == 1) res.append(set.first());
        else res.append(set.higher(time.charAt(4)-48));

        // 倒数第二
        if (point == 0) res.append(time.charAt(3));
        else {
            if (set.higher(time.charAt(3) - 48) == null || set.higher(time.charAt(3) - 48) > 5)
                res.append(set.first());
            else {
                res.append(set.higher(time.charAt(3) - 48));
                point = 0;
            }
        }
        res.append(':');
        if (point == 0) res.append(time.charAt(1));
        else {
            if (time.charAt(0) == 2) {
                if (set.higher(time.charAt(1) - 48) == null || set.higher(time.charAt(1) - 48) > 3)
                    res.append(set.first());
                else {
                    res.append(set.higher(time.charAt(1) - 48));
                    point = 0;
                }
            }
            else{
                if (set.higher(time.charAt(1) - 48) == null)
                    res.append(set.first());
                else {
                    res.append(set.higher(time.charAt(1) - 48));
                    point = 0;
                }
            }
        }

        if (point == 0) res.append(time.charAt(0));
        else{
            if (set.higher(time.charAt(0)-48) == null || set.higher(time.charAt(0)-48) > 2) res.append(set.first());
            else res.append(set.higher(time.charAt(0)-48));
        }

        res.reverse();
        return res.toString();
    }
}
