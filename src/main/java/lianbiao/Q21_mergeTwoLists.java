package lianbiao;

/**
 * @author liuweilong
 * @date 2021/3/29
 * @description 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 */
public class Q21_mergeTwoLists {
    //递归
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head;
        if (l1 != null && l2 != null) {
            boolean l1Bigger = l1.val > l2.val;
            head = l1Bigger ? l2 : l1;
            if (l1Bigger) {
                head.next = mergeTwoLists(l1, l2.next);
            } else {
                head.next = mergeTwoLists(l1.next, l2);
            }
        } else if (l1 == null) {
            return l2;
        } else {
            return l1;
        }

        return head;
    }

    //官方递归
    public ListNode mergeTwoListsGuanfang(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }


    //迭代
    public ListNode mergeTwoListsDiedai(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode result = head;
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                head.next = l2;
                break;
            } else if (l2 == null) {
                head.next = l1;
                break;
            } else if (l1.val < l2.val) {
                head.next = l1;
                l1 = l1.next;
                head = head.next;
            } else {
                head.next = l2;
                l2 = l2.next;
                head = head.next;
            }
        }

        return result.next;
    }

    public ListNode mergeTwoListsDiedaiGuanfang(ListNode l1, ListNode l2) {
        ListNode prehead = new ListNode(-1);

        ListNode prev = prehead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }

        // 合并后 l1 和 l2 最多只有一个还未被合并完，我们直接将链表末尾指向未合并完的链表即可
        prev.next = l1 == null ? l2 : l1;

        return prehead.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(5);
        l1.next.next = new ListNode(6);
        ListNode l2 = new ListNode(2);
        System.out.println(new Q21_mergeTwoLists().mergeTwoListsDiedai(l1, l2));

    }

}
