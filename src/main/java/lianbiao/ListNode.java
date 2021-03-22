package lianbiao;

/**
 * @author liuweilong
 * @description
 * @date 2019/5/7 17:44
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    ListNode add(int i) {
        ListNode next = new ListNode(i);
        this.next = next;
        return next;
    }
    public static ListNode generate(int[] a1) {
        ListNode result = new ListNode(0);
        ListNode head = result;
        for (int i : a1) {
            head.next = new ListNode(i);
            head = head.next;
        }
        return result.next;
    }
}
