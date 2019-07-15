package lianbiao;

/**
 * @author lwl
 * @date 2019/2/12 15:46
 * @description 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * <p>
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * <p>
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 示例：
 * <p>
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class TwoPlusSolution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //从头开始遍历：
        //     1、节点相加，取个位数n存到联表中，如果加起来大于10，记录forward为1
        //      2、相加的时候要加上forward，然后重置forward
        //     3、如果两个联表长度不同，则较短的那个补0
        int forward = 0;
        int first = l1.val + l2.val;
        ListNode listNode;
        if (first >= 10) {
            listNode = new ListNode(first - 10);
            forward = 1;
        } else {
            listNode = new ListNode(first);
        }
        ListNode resultNext = listNode;
        l1 = l1.next;
        l2 = l2.next;
        while (!(l1 == null && l2 == null)) {
            int i = l1 == null ? 0 : l1.val;
            int j = l2 == null ? 0 : l2.val;
            int temp = i + j + forward;
            if (temp >= 10) {
                resultNext.next = new ListNode(temp - 10);
                forward = 1;
            } else {
                resultNext.next = new ListNode(temp);
                forward = 0;
            }
            resultNext = resultNext.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (forward != 0){
            resultNext.next = new ListNode(1);
        }
        return listNode;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        new TwoPlusSolution().addTwoNumbers(l1, l2);
    }
}