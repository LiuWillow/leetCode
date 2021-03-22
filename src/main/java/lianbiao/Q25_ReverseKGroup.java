package lianbiao;

import javax.print.attribute.standard.PresentationDirection;
import java.util.List;
import java.util.Stack;

/**
 * author liuweilong
 * date 2019/7/15 20:40
 * desc
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 * k 是一个正整数，它的值小于或等于链表的长度
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * <p>
 * 示例 :
 * 给定这个链表：1->2->3->4->5
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 * <p>
 * 说明 :
 * 你的算法只能使用常数的额外空间。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 */
public class Q25_ReverseKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode tempHead = new ListNode(0);
        tempHead.next = head;
        Stack<ListNode> stack = new Stack<>();
        for (int i = 0; i < k; i++) {
            tempHead = tempHead.next;
            if (tempHead == null) {
                return head;
            }
            stack.add(tempHead);
        }
        ListNode nextNode = tempHead.next;
        ListNode reverseHead = stack.pop();
        tempHead = reverseHead;
        while (!stack.isEmpty()) {
            tempHead.next = stack.pop();
            tempHead = tempHead.next;
        }
        tempHead.next = reverseKGroup(nextNode, k);
        return reverseHead;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        ListNode listNode = new Q25_ReverseKGroup().reverseKGroup(head, 2);
        while (listNode != null){
            System.out.print(listNode.val + "  ");
            listNode = listNode.next;
        }
    }
}
