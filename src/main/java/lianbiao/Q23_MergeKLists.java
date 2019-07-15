package lianbiao;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author liuweilong
 * @description
 * @date 2019/5/7 17:33
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 */
public class Q23_MergeKLists {
    private int index;

    /**
     * 粗暴版本
     * @param lists
     * @return
     */
    public ListNode mergeKListsForce(ListNode[] lists) {
        if (lists == null || lists.length == 0){
            return null;
        }
        ListNode result = new ListNode(0);
        ListNode resultCopy = result;
        int length = lists.length;
        Integer[] heads = new Integer[length];
        for (int i = 0; i < length; i++) {
            if (lists[i] == null){
                heads[i] = null;
                continue;
            }
            heads[i] = lists[i].val;
        }

        Integer min = min(heads);
        while (min != null) {
            result.next = new ListNode(min);
            result = result.next;
            lists[index] = lists[index] == null ? null : lists[index].next;
            heads[index] = lists[index] == null ? null : lists[index].val;
            min = min(heads);
        }
        return resultCopy.next;
    }

    public Integer min(Integer[] heads) {
        Integer min = Integer.MAX_VALUE;
        for (int i = 0; i < heads.length; i++) {
            if (heads[i] != null && min > heads[i]) {
                min = heads[i];
                index = i;
            }
        }

        if (min.equals(heads[index])){
            return min;
        }
        return null;
    }


    public ListNode mergeKListsQueue(ListNode[] lists) {
        if (lists == null || lists.length == 0){
            return null;
        }
        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, Comparator.comparingInt(o -> o.val));
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        for (ListNode node : lists) {
            if (node != null) {
                queue.add(node);
            }
        }
        while (!queue.isEmpty()) {
            p.next = queue.poll();
            p = p.next;
            if (p.next != null) {
                queue.add(p.next);
            }
        }
        return dummy.next;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        return merge(lists, 0, lists.length - 1);
    }

    private ListNode merge(ListNode[] lists, int lo, int hi) {
        if (lo == hi){
            return lists[lo];
        }
        int mid = lo + (hi - lo) / 2;
        ListNode l1 = merge(lists, lo, mid);
        ListNode l2 = merge(lists, mid + 1, hi);
        return mergeListNode(l1, l2);
    }

    private ListNode mergeListNode(ListNode l1, ListNode l2){
        if (l1 == null){
            return l2;
        }
        if (l2 == null){
            return l1;
        }
        if (l1.val < l2.val){
            l1.next = mergeListNode(l1.next, l2);
            return l1;
        }else {
            l2.next = mergeListNode(l1, l2.next);
            return l2;
        }
    }


    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        listNode1.next = new ListNode(4);
        listNode1.next.next = new ListNode(5);

        ListNode listNode2 = new ListNode(1);
        listNode2.next = new ListNode(3);
        listNode2.next.next = new ListNode(4);

        ListNode listNode3 = new ListNode(2);
        listNode3.next = new ListNode(6);

        ListNode[] list = new ListNode[] { listNode1, listNode2, listNode3};

        new Q23_MergeKLists().mergeKListsForce(list);
    }
}
