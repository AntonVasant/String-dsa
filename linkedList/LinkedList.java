package linkedList;

public class LinkedList {
    Node head;
    public LinkedList(){
        this.head = null;
    }
    public Node create(int value){
        Node newNode = new Node(value);
        if(head == null){
            head = newNode;
            return head;
        }
        Node current = head;
        while (current.next != null){
            current = current.next;
        }
        current.next = newNode;
        return head;
    }
    public void reverse(){
        Node current = head;
        Node prev = null;
        Node nex;
        while (current != null){
            nex = current.next;
            current.next = prev;
            prev = current;
            current = nex;
        }
        head = prev;
    }

    public Node arrayToList(int[] array){
        Node head = new Node(array[0]);
        Node current = head;
        for (int i = 1; i < array.length; i++){
            var small = new Node(array[i]);
            current.next=small;
            current=current.next;
        }
        return head;
    }

    public void print(){
        Node current = head;
        while (current != null){
            System.out.print(current.value+" ");
            current=current.next;
        }
    }
    public void remove(int len,int n){
        Node temp = head;
        for (int i = 1;i < len-n; i++){
            temp = temp.next;
        }
        temp.next = temp.next.next;
    }
    public void oddEven(){
        Node oddHead = head;
        Node evenHead = head.next;
        Node oddCurrent = oddHead;
        Node evenCurrent = evenHead;
        while (evenCurrent != null && evenCurrent.next != null){
            oddCurrent.next = evenCurrent.next;
            oddCurrent = oddCurrent.next;
            evenCurrent.next = oddCurrent.next;
            evenCurrent = evenCurrent.next;
        }
        oddCurrent.next = evenHead;
    }
}
