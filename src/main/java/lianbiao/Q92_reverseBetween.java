package lianbiao;

/**
 * @author liuweilong
 * @date 2021/5/12
 * @description 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 *
 */
public class Q92_reverseBetween {
    /**
     * 断开、翻转再重新拼接
     * @param head
     * @param left
     * @param right
     * @return
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0, head);
        ListNode pre = dummy;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }

        ListNode leftNode = pre.next;
        ListNode rightNode = leftNode;
        for (int i = 0; i < right - left; i++) {
            rightNode = rightNode.next;
        }
        ListNode finalNext = rightNode.next;

        rightNode.next = null;

        reverse(leftNode);
        pre.next = rightNode;
        leftNode.next = finalNext;
        return dummy.next;
    }

    /**
     * 一次翻转，头插法
     * @param head
     * @param left
     * @param right
     * @return
     */
    public ListNode reverseBetween_once(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0, head);
        ListNode pre = dummy;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }

        ListNode cur = pre.next;
        int l = left;
        while (cur != null && l < right) {
            ListNode next = cur.next;
            ListNode nextNext = cur.next.next;
            next.next = pre.next;
            pre.next = next;
            cur.next = nextNext;
            l++;
        }

        return dummy.next;
    }

    private void reverse(ListNode head) {
       ListNode pre = null;
       ListNode cur = head;
       while (cur != null) {
           ListNode next = cur.next;
           cur.next = pre;
           pre = cur;
           cur = next;
       }
    }

    public static void main(String[] args) {
        new Q92_reverseBetween().reverseBetween_once(ListNode.generate(new int[]{1, 2, 3, 4, 5}), 1, 4).print();
    }
}
