package main;

/**
 * @Author : sharch
 * @create 2023/9/13 20:08
 * https://leetcode.cn/problems/add-two-numbers/
 */
public class AddTwoNumbers {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(4);
        ListNode l3 = new ListNode(9);
        l1.next = l2;
        l2.next = l3;
        l3.next = null;

        ListNode l11 = new ListNode(5);
        ListNode l12 = new ListNode(6);
        ListNode l13 = new ListNode(4);
        ListNode l14 = new ListNode(9);
        l11.next = l12;
        l12.next = l13;
        l13.next = l14;
        l14.next = null;


//        printList(l1);
//        printList(l11);
        //printList(addTwoNumbersV2(l1, l11));

        printList(addTwoNumbers(l1, l11));
    }

    private static void printList(ListNode l) {
        if (l == null) {
            return;
        }
        if (l.next == null) {
            System.out.println(l.val);
        }
        while (l.next != null) {
            System.out.println(l.val);
            l = l.next;
            if (l.next == null) {
                System.out.println(l.val);
                break;
            }
        }
    }

    /**
     * 数学解法
     */
    private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 短的不够了，当成0处理
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode resHead = new ListNode(-1);
        ListNode tempNode = resHead;
        int carry = 0; // 进位
        while (p1 != null || p2 != null) {
            int val1 = p1 == null ? 0 : p1.val;
            int val2 = p2 == null ? 0 : p2.val;
            int val = val1 + val2 + carry;
            if (val > 9) {
                carry = 1;
                val = val - 10;
            } else {
                carry = 0;
            }
            ListNode cur = new ListNode(val);
            tempNode.next = cur;
            tempNode = cur;
            if (p1 != null) {
                p1 = p1.next;
            }
            if (p2 != null) {
                p2 = p2.next;
            }
        }
        if (carry == 1) {
            tempNode.next = new ListNode(1);
        }
        return resHead.next;
    }

    /**
     * 暴力解法：转为数字。会超出界限（100个节点）
     */
    private static ListNode addTwoNumbersV2(ListNode l1, ListNode l2) {
        long temp1 = 0;
        double cnt = 0;
        while (l1 != null) {
            temp1 = (long) (temp1 + l1.val * Math.pow(10, cnt));
            cnt++;
            l1 = l1.next;
            if (l1 == null) {
                break;
            }
            if (l1.next == null) {
                temp1 = (long) (temp1 + l1.val * Math.pow(10, cnt));
                break;
            }
        }
        System.out.println("l1的值 " + temp1);

        long temp2 = 0;
        cnt = 0;
        while (l2 != null) {
            temp2 = (long) (temp2 + l2.val * Math.pow(10, cnt));
            cnt++;
            l2 = l2.next;
            if (l2 == null) {
                break;
            }
            if (l2.next == null) {
                temp2 = (long) (temp2 + l2.val * Math.pow(10, cnt));
                break;
            }
        }
        System.out.println("l2的值 " + temp2);

        long sum = temp1 + temp2;
        ListNode head = new ListNode(0);
        ListNode temp = new ListNode(0);
        temp = head;
        // 依次拿到每一位
        while (sum / 10 > 0) {
            int val = (int) sum % 10;
            sum /= 10;
            ListNode node = new ListNode(val);
            temp.next = node;
            temp = node;
        }
        ListNode tail = new ListNode((int) sum);
        temp.next = tail;
        return head.next;
    }

}


class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
