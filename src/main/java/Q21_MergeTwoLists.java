/**
 * @author liuweilong
 * @description
 * @date 2019/5/6 17:41
 */
public class Q21_MergeTwoLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = null;
        ListNode next = null;
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                int tv2 = l2.val;
                l2 = l2.next;
                if (result == null){
                    result = new ListNode(tv2);
                    next = result;
                    continue;
                }
                next.next = new ListNode(tv2);
                next = next.next;
                continue;
            }
            if (l2 == null) {
                int tv1 = l1.val;
                l1 = l1.next;
                if (result == null){
                    result = new ListNode(tv1);
                    next = result;
                    continue;
                }
                next.next = new ListNode(tv1);
                next = next.next;
                continue;
            }
            int v1 = l1.val;
            int v2 = l2.val;
            int v;
            if (v1 < v2){
                v = l1.val;
                l1 = l1.next;
            }else {
                v = l2.val;
                l2 = l2.next;
            }

            if (result == null){
                result = new ListNode(v);
                next = result;
                continue;
            }
            next.next = new ListNode(v);
            next = next.next;
        }
        return result;
    }
}
