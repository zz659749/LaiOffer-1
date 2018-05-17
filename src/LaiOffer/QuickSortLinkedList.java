package LaiOffer;

public class QuickSortLinkedList {
    public ListNode quickSort(ListNode head) {
        // Write your solution here
        if (head == null || head.next == null) {
            return head;
        }
        ListNode mid = findMid(head);
        int i = mid.value;
        ListNode dummy1 = new ListNode(233);
        ListNode dummy2 = new ListNode(233);
        ListNode curr = head, curr1 = dummy1, curr2 = dummy2;
        while (curr != null) {
            if (curr.value < mid.value) {
                curr1.next = curr;
                curr1 = curr1.next;
            } else if(curr != mid) {
                curr2.next = curr;
                curr2 = curr2.next;
            }
            curr = curr.next;
        }
        curr1.next = null;
        curr2.next = null;
        ListNode firHead = quickSort(dummy1.next);
        ListNode secHead = quickSort(dummy2.next);
        ListNode firTail = firHead;
        while (firTail.next != null) {
            firTail = firTail.next;
        }
        firTail.next = mid;
        mid.next = secHead;
        return firHead;
    }

    private ListNode findMid(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
