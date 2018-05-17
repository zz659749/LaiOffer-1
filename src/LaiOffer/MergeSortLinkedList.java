package LaiOffer;

public class MergeSortLinkedList {
    public ListNode mergeSort(ListNode head) {
        // Write your solution here
        if (head == null || head.next == null) {
            return head;
        }
        ListNode mid = findMid(head);
        int i = mid.value;
        ListNode secHead = reverse(mid.next);
        int j = secHead.value;
        head = mergeSort(head);
        secHead = mergeSort(secHead);
        return merge(head, secHead);

    }

    private ListNode findMid(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
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

    private ListNode merge(ListNode head1, ListNode head2) {
        ListNode curr1 = head1;
        ListNode curr2 = head2;
        ListNode dummy = new ListNode(233);
        ListNode curr = dummy;
        while(curr1 != null && curr2 != null) {
            if (curr1.value < curr2.value) {
                curr.next = curr1;
                curr1 = curr1.next;
            } else {
                curr.next = curr2;
                curr2 = curr2.next;
            }
            curr = curr.next;
        }
        if (curr1 != null) {
            curr.next = curr1;
        } else {
            curr.next = curr2;
        }
        return dummy.next;
    }
}

class ListNode {
    ListNode next;
    int value;
    public ListNode(int n) {
        value = n;
    }
}