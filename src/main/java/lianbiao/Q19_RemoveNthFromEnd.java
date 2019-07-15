package lianbiao;

/**
 * @author liuweilong
 * @description
 * @date 2019/5/5 17:46 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 */
public class Q19_RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode firstBegin = head;
        ListNode secondBegin = head;
        for (int i = 1; i <= n; i++) {
            firstBegin = firstBegin.next;
            if (firstBegin == null){
                head = head.next;
                return head;
            }
        }
        while (firstBegin.next != null) {
            firstBegin = firstBegin.next;
            secondBegin = secondBegin.next;
        }

        ListNode next = secondBegin.next;
        secondBegin.next = next.next;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode temp = head;
        for (int i = 2; i < 6; i++) {
            temp = temp.add(i);
        }

        ListNode listNode = new Q19_RemoveNthFromEnd().removeNthFromEnd(head, 2);
        ListNode next = listNode.next;
        System.out.println(listNode.val);
        while (next != null){
            System.out.println(next.val);
            next = next.next;
        }
    }
}
