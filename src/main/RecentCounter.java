package main;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author : sharch
 * @create 2023/9/15 19:54
 * https://leetcode.cn/problems/number-of-recent-calls/
 */
public class RecentCounter {
    private List<Integer> list;

    private int[] arrays;
    private int start,end;

    private LinkedList<Integer> queue;

    public RecentCounter() {
        list = new ArrayList<>();

        arrays = new int[3005];
        start = end = 0;

        queue = new LinkedList<>();
    }

    // 当前时刻，往前找3000时间内的请求
    public int ping(int t) {
        int res = 0;
        list.add(t);
        for (int i = list.size()-1; i >=0 ; i--) {
            if (list.get(i)>= t-3000){
                    res++;
            }
        }
        return res;
    }

    /**
     * start主动排除超时的部分数据
     */
    private int pingV2(int t){
        arrays[end] = t;
        end++;
        if(end == arrays.length) {
            end = 0;
        }
        // start可能需要右移
        while(arrays[start] < t-3000){
            start++;
            if(start == arrays.length){
                start = 0;
            }
        }
        // 环形数组
        if (start > end) {
            return arrays.length - (start - end);
        }
        return end-start;
    }

    private int pingV3(int t){
        queue.addLast(t);
        while(queue.peekFirst() < t-3000){
            queue.removeFirst();
        }
        return queue.size();
    }
}
