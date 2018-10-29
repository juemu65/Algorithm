package Hard;


import java.util.*;
//合并K个排序链表

//合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
//
//        示例:
//
//        输入:
//        [
//        1->4->5,
//        1->3->4,
//        2->6
//        ]
//        输出: 1->1->2->3->4->4->5->6


class Pair {
    int row;
    int col;

    public Pair(int row, int col) {
        this.row = row;
        this.col = col;
    }
}


class Interval {
    int start, end;

    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

class Element implements Comparable<Element> {
    int i, j;
    Interval interval;

    Element(int i, int j, Interval interval) {
        this.i = i;
        this.j = j;
        this.interval = interval;
    }

    @Override
    public int compareTo(Element o) {
        return this.interval.start - o.interval.start;
    }



    public List<Interval> mergeKSortedIntervalLists(List<List<Interval>> intervals) {
        // write your code here
        if (intervals == null || intervals.isEmpty()) {
            return new ArrayList<Interval>();
        }

        // return mergeHelper_v1_minHeap(intervals);
        // return mergeHelper_v2_Divide_Conquer(intervals, 0, intervals.size() - 1);
        return mergeHelper_v3_Non_Recursive(intervals);
    }
// 小顶堆 优先队列
    private List<Interval> mergeHelper_v1_minHeap(List<List<Interval>> intervals) {
        PriorityQueue<Element> minHeap = new PriorityQueue<>();
        for (int i = 0; i < intervals.size(); i++) {
            List<Interval> list = intervals.get(i);
            if (list != null && !list.isEmpty()) {
                minHeap.offer(new Element(i, 0, list.get(0)));
            }
        }

        List<Interval> merge = new ArrayList<>();
        Interval last = null;

        while (!minHeap.isEmpty()) {
            Element cur = minHeap.poll();
            if (last == null || last.end < cur.interval.start) {
                merge.add(cur.interval);
                last = cur.interval;
            } else {
                last.end = Math.max(last.end, cur.interval.end);
            }

            if (cur.j + 1 < intervals.get(cur.i).size()) {
                cur.j++;
                cur.interval = intervals.get(cur.i).get(cur.j);
                minHeap.offer(cur);
            }
        }

        return merge;
    }

    //分治思想  递归
    private List<Interval> mergeHelper_v2_Divide_Conquer(List<List<Interval>> intervals, int low, int high) {
        if (low >= high) {
            return intervals.get(low);
        }

        int mid = low + (high - low) / 2;
        List<Interval> left = mergeHelper_v2_Divide_Conquer(intervals, low, mid);
        List<Interval> right = mergeHelper_v2_Divide_Conquer(intervals, mid + 1, high);
        return mergeTwoInterval(left, right);
    }

//两两合并，非递归
    private List<Interval> mergeHelper_v3_Non_Recursive(List<List<Interval>> intervals) {
        while (intervals.size() > 1) {
            List<List<Interval>> tmp = new ArrayList<>();
            for (int i = 0; i < intervals.size() && i + 1 < intervals.size(); i += 2) {
                List<Interval> merge = mergeTwoInterval(intervals.get(i), intervals.get(i + 1));
                tmp.add(merge);
            }

            if (intervals.size() % 2 == 1) {
                tmp.add(intervals.get(intervals.size() - 1));
            }

            intervals = tmp;
        }
        return intervals.get(0);
    }

    private List<Interval> mergeTwoInterval(List<Interval> list1, List<Interval> list2) {
        // write your code here
        if (list1 == null || list1.isEmpty()) {
            return list2;
        }

        if (list2 == null || list2.isEmpty()) {
            return list1;
        }

        List<Interval> merge = new ArrayList<>();
        Interval last = null;

        int i = 0, j = 0;
        while (i < list1.size() && j < list2.size()) {
            Interval cur;
            if (list1.get(i).start <= list2.get(j).start) {
                cur = list1.get(i);
                i++;
            } else {
                cur = list2.get(j);
                j++;
            }

            if (last == null || last.end < cur.start) {
                merge.add(cur);
                last = cur;
            } else {
                last.end = Math.max(last.end, cur.end);
            }
        }

        while (i < list1.size()) {
            Interval cur = list1.get(i);
            i++;

            if (last == null || last.end < cur.start) {
                merge.add(cur);
                last = cur;
            } else {
                last.end = Math.max(last.end, cur.end);
            }
        }

        while (j < list2.size()) {
            Interval cur = list2.get(j);
            j++;

            if (last == null || last.end < cur.start) {
                merge.add(cur);
                last = cur;
            } else {
                last.end = Math.max(last.end, cur.end);
            }
        }

        return merge;
    }
}