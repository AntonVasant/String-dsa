package linkedList;

public class ReverseEvenGroup {
    public Node reverseEvenLengthGroups(Node head) {
        Node dummy = new Node(0);
        dummy.next = head;
        Node prevGroupEnd = dummy;
        Node current = head;
        int groupLength = 1;

        while (current != null) {
            // Find the end of the current group
            Node groupStart = current;
            int count = 0;
            while (count < groupLength && current != null) {
                current = current.next;
                count++;
            }

            // If the group length is even, reverse the group
            if (count % 2 == 0) {
                prevGroupEnd.next = reverseGroup(groupStart, count);
            } else {
                prevGroupEnd.next = groupStart;
            }

            while (count > 0) {
                prevGroupEnd = prevGroupEnd.next;
                count--;
            }
            groupLength++;
        }

        return dummy.next;
    }

    private Node reverseGroup(Node head, int k) {
        Node prev = null;
        Node current = head;
        while (k > 0) {
            Node next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            k--;
        }
        head.next = current; // Connect the reversed group with the next part of the list
        return prev;
    }
}
