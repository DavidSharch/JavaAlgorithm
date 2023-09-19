package main;

/**
 * @Author : sharch
 * @create 2023/9/15 20:54
 * https://leetcode.cn/problems/linked-list-cycle/
 */
public class LinkedListCycle {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        n1.next = n2;
        n2.next = n1;

        //System.out.println(hasCycle(n1));
        System.out.println(detectCycle(n1));
    }

    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (true) {
            slow = slow.next;
            fast = fast.next;
            if (slow == null || fast == null) {
                return false;
            }
            fast = fast.next;
            if (fast == null) {
                return false;
            }
            if (fast == slow) {
                return true;
            }
        }
    }

    public static ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        if(head.next.next == head) {
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (true) {
            slow = slow.next;
            fast = fast.next;
            if (slow == null || fast == null) {
                return null;
            }
            fast = fast.next;
            if (fast == null) {
                return null;
            }
            if (fast == slow) {
                // 出现环，开始快慢都走一步
                while (slow != head) {
                    slow = slow.next;
                    head = head.next;
                }
                return slow;
            }
        }
    }
}
