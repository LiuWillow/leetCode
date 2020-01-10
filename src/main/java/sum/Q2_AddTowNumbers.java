package sum;

import lianbiao.ListNode;

/**
 * author liuweilong
 * date 2020/1/9 6:25 下午
 * desc
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * <p>
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * <p>
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 示例：
 * <p>
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class Q2_AddTowNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        int delta = 0;
        ListNode next = new ListNode(0);
        result.next = next;
        while (l1 != null || l2 != null) {
            int l1Num = l1 == null ? 0 : l1.val;
            int l2Num = l2 == null ? 0 : l2.val;
            int sum = l1Num + l2Num + delta;
            delta = sum > 9 ? 1 : 0;
            sum = sum > 9 ? sum - 10 : sum;
            next.next = new ListNode(sum);
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
            next = next.next;
        }
        if (delta != 0) {
            next.next = new ListNode(1);
        }
        return result.next.next;
    }

    public static void main(String[] args) {
        ListNode l1 = generate(new int[]{2, 4, 3});
        ListNode l2 = generate(new int[]{5, 6, 4});

        ListNode listNode = new Q2_AddTowNumbers().addTwoNumbers(l1, l2);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    private static ListNode generate(int[] nums) {
        ListNode result = new ListNode(0);
        ListNode temp = new ListNode(0);
        result.next = temp;
        for (int num : nums) {
            temp.next = new ListNode(num);
            temp = temp.next;
        }
        return result.next.next;
    }
}