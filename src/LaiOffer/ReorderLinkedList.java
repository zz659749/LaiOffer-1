package LaiOffer;


public class ReorderLinkedList {
    public ListNode reorder(ListNode head) {
        // Write your solution here
        if (head == null) {
            return head;
        }
        ListNode mid = findMid(head);
        ListNode secHead = reverse(mid.next);
        merge(head, secHead);
        return head;
    }

    private ListNode findMid(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast.next != null && fast.next.next !=null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    private ListNode reverse(ListNode head) {
        if (head.next == null) {
            return head;
        }
        ListNode newHead = reverse(head.next);
        ListNode tail = head.next;
        tail.next = head;
        head.next = null;
        return newHead;
    }

    private void merge(ListNode p1, ListNode p2) {
        ListNode tmp1 = null, tmp2 = null;
        while (p2 != null) {
            tmp1 = p1.next;
            tmp2 = p2.next;
            p1.next = p2;
            p2.next = tmp1;
            p1 = tmp1;
            p2 = tmp2;
        }
    }


    static class ListNode {
        int value;
        ListNode next;

        public ListNode(int v) {
            value = v;
        }
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = null;

        ReorderLinkedList r = new ReorderLinkedList();
        ListNode res = r.reorder(n1);
        while (res != null) {
            System.out.println(res.value);
            res = res.next;
        }
    }
}


