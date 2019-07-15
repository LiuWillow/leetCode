package lianbiao;

/**
 * @author liuweilong
 * @description
 * @date 2019/5/7 17:44
 */
public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    ListNode add(int i) {
        ListNode next = new ListNode(i);
        this.next = next;
        return next;
    }
}
