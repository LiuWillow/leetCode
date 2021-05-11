package lianbiao;

/**
 * @author liuweilong
 * @date 2021/5/11
 * @description 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除所有重复的元素，使每个元素 只出现一次 。
 * <p>
 * 返回同样按升序排列的结果链表。
 */
public class Q83_deleteDuplicates {
    /**
     * 递归版
     *
     * @param head
     * @return
     */
    public ListNode deleteDuplicatesRecur(ListNode head) {
        if (head == null) {
            return head;
        }
        if (head.next == null) {
            return head;
        }
        if (head.val != head.next.val) {
            head.next = deleteDuplicatesRecur(head.next);
        } else {
            //保留第一个
            ListNode cur = head;
            int val = head.val;
            while (head.next != null && head.next.val == val) {
                head = head.next;
            }
            cur.next = head;
            return deleteDuplicatesRecur(cur.next);
        }
        return head;
    }

    /**
     * 一次遍历版
     *
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        if (head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0, head);
        ListNode pre = dummy;
        while (pre.next != null && pre.next.next != null) {
            if (pre.next.val == pre.next.next.val) {
                //相等，保留一个
                ListNode save = pre.next;
                int val = pre.next.val;
                while (save.next != null && val == save.next.val) {
                    save = save.next;
                }
                pre.next.next = save.next;
            } else {
                //不相等，保留pre.next
                pre = pre.next;
            }
        }
        return dummy.next;
    }

    //官方题解，我是傻逼
    public ListNode deleteDuplicates_Official(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode cur = head;
        while (cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }

        return head;
    }


    public static void main(String[] args) {
        new Q83_deleteDuplicates().deleteDuplicates(ListNode.generate(new int[]{1, 1, 1})).print();
        new Q83_deleteDuplicates().deleteDuplicates(ListNode.generate(new int[]{1, 1, 1, 2})).print();
        new Q83_deleteDuplicates().deleteDuplicates(ListNode.generate(new int[]{1, 2})).print();
        new Q83_deleteDuplicates().deleteDuplicates(ListNode.generate(new int[]{1, 2, 2})).print();
        new Q83_deleteDuplicates().deleteDuplicates(ListNode.generate(new int[]{1, 1, 2, 2})).print();
    }
}
