class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prevGroup = dummy;
        ListNode curr = head;

        while (true) {
            ListNode kth = kthNode(curr, k);
            if (kth == null) break;

            ListNode nextGroup = kth.next;
            kth.next = null;

            ListNode newHead = reverse(curr);

            prevGroup.next = newHead;
            curr.next = nextGroup;

            prevGroup = curr;
            curr = nextGroup;
        }

        return dummy.next;
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    private ListNode kthNode(ListNode head, int k) {
        while (head != null && k > 1) {
            head = head.next;
            k--;
        }
        return head;
    }
}
