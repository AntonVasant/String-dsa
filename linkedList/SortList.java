package linkedList;

public class SortList {
    public Node sortList(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        // Step 1: Divide the list into two halves
        Node middle = findMiddle(head);
        Node nextToMiddle = middle.next;
        middle.next = null;

        // Step 2: Recursively sort the two halves
        Node left = sortList(head);
        Node right = sortList(nextToMiddle);

        // Step 3: Merge the sorted halves
        Node sortedList = merge(left, right);
        return sortedList;
    }

    // Helper function to find the middle node of the list
    private Node findMiddle(Node head) {
        if (head == null) {
            return null;
        }
        Node slow = head;
        Node fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // Helper function to merge two sorted lists
    private Node merge(Node l1, Node l2) {
        Node dummy = new Node(0);
        Node current = dummy;

        while (l1 != null && l2 != null) {
            if (l1.value < l2.value) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }

        // Append remaining nodes of l1 or l2 (if any)
        if (l1 != null) {
            current.next = l1;
        }
        if (l2 != null) {
            current.next = l2;
        }

        return dummy.next;
    }
}
