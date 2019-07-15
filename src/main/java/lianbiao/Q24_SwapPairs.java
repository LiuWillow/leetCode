package lianbiao;

/**
 * author liuweilong
 * date 2019/7/13 17:25
 * desc
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 *  
 *
 * 示例:
 *
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 */
public class Q24_SwapPairs {
    public ListNode swapPairs(ListNode head) {
        if (head.next == null){
            return head;
        }
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode temp = pre.next;
        while (temp.next != null && temp.next.next != null) {
            ListNode startNode = temp;
            ListNode endNode = temp.next;
            temp.next = endNode;
            startNode.next = endNode.next;
            endNode.next = startNode;
            temp = startNode;
        }
        return pre.next;
    }

    public ListNode swapPairs2(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode next = head.next;
        head.next = swapPairs2(next.next);
        next.next = head;
        return next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        ListNode result = new Q24_SwapPairs().swapPairs2(head);
        while (result != null){
            System.out.println(result.val);
            result = result.next;
        }

    }
}
