import lianbiao.ListNode;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author liuweilong
 * @description
 * @date 2019/5/11 17:43
 */
public class Test {
    public static void main(String[] args) throws Exception {
        System.out.println(Integer.numberOfLeadingZeros(32) | (1 << (16 - 1)));
        ConcurrentHashMap<Integer, Integer> concurrentHashMap = new ConcurrentHashMap<>(15);
        for (int i = 0; i < 32; i++) {
            concurrentHashMap.put(i, i);
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode result = new ListNode(0);
        ListNode head = result;
        int advance = 0;
        while (l1 != null && l2 != null) {
            int val1 =  l1.val;
            int val2 =  l2.val;
            int sum = val1 + val2 + advance;
            int recordSum = sum >= 10 ? sum - 10 : sum;
            advance = sum >= 10 ? 1 : 0;
            ListNode node = new ListNode(recordSum);
            head.next = node;
            head = node;
            l1 = l1.next == null ? null : l1.next;
            l2 = l2.next == null ? null : l2.next;
        }
        ListNode next = l1 == null ? l2 : l1;
        if (next == null) {
            return result.next;
        }
        ListNode tmpHead = next;
        while (next != null) {
            int val =  next.val;
            int sum = val + advance;
            int recordSum = sum >= 10 ? sum - 10 : sum;
            advance = sum >= 10 ? 1 : 0;
            next.val = recordSum;
            next = next.next;
        }

        head.next = tmpHead;
        return result.next;
    }
}
