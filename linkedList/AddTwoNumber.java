package linkedList;

public class AddTwoNumber {
    public Node addTwo(Node n1,Node n2){
        Node dummy = new Node(-1);
        Node current = dummy;
        int carry =0;
        int sum;
        while (n1 != null || n2 != null){
            sum = carry;
            if(n1 != null){
                sum+= n1.value;
                n1=n1.next;
            }
            if(n2 != null){
                sum+= n2.value;
                n2 = n2.next;
            }
            carry = sum/10;
            current.next= new Node(sum%10);
            current = current.next;
        }
        if (carry >0){
            current.next = new Node(carry);
        }
        return dummy.next;
    }
}
