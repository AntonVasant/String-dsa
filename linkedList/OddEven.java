package linkedList;

public class OddEven {
        public Node oddEvenList(Node head) {
            if (head == null || head.next == null)
                return head;

            Node odd = head;
            Node even = head.next;
            Node evenHead = even; // Save the head of even list
            while (even != null && even.next != null) {
                odd.next = even.next;
                odd = odd.next;
                even.next = odd.next;
                even = even.next;
            }
            odd.next = evenHead; // Connect odd list to the head of even list
            return head;
        }
    }
