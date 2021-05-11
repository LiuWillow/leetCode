package lianbiao;

import java.util.Objects;

/**
 * @author liuweilong
 * @date 2021/5/11
 * @description 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除链表中所有存在数字重复情况的节点，只保留原始链表中 没有重复出现 的数字。
 * <p>
 * 返回同样按升序排列的结果链表。
 */
public class Q82_deleteDuplicates {

    public ListNode recurDeleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        //不相等，保留head
        if (!(head.val == head.next.val)) {
            head.next = recurDeleteDuplicates(head.next);
        } else {
            //相等，跳过相等的数
            ListNode move = head.next;
            while (move != null && head.val == move.val) {
                move = move.next;
            }
            return recurDeleteDuplicates(move);
        }
        return head;
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode dummy = new ListNode(0, head);

        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {
                int x = cur.next.val;
                while (cur.next != null && cur.next.val == x) {
                    cur.next = cur.next.next;
                }
            } else {
                cur = cur.next;
            }
        }

        return dummy.next;
    }

    public ListNode deleteDuplicates_tryOfficial(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode dummy = new ListNode(0, head);

        ListNode pre = dummy;

        while (pre.next != null && pre.next.next != null) {
            if (pre.next.val == pre.next.next.val) {
                int val = pre.next.val;
                while (pre.next != null && pre.next.val == val) {
                    //重点
                    pre.next = pre.next.next;
                }
            } else {
                pre = pre.next;
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode listNode = new Q82_deleteDuplicates().deleteDuplicates_tryOfficial(ListNode.generate(new int[]{1, 1, 1, 2, 2, 3}));
        if (Objects.isNull(listNode)) {
            System.out.println("null");
        } else {
            listNode.print();
        }
    }
}
