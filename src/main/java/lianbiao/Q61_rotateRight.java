package lianbiao;

/**
 * @author liuweilong
 * @date 2021/5/11
 * @description
 * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
 */
public class Q61_rotateRight {
    public ListNode rotateRight(ListNode head, int k) {
        ListNode tmpHead = head;
        int length = 0;
        while (true) {
            length++;
            if (head.next == null) {
                head.next = tmpHead;
                break;
            }
        }
        int add = (length - k) % length;
        while (add-- > 0) {
            head = head.next;
        }

        ListNode result = head.next;
        head.next = null;
        return result;
    }
}
