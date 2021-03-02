import java.util.List;

public class AddTwoNumbers {
    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //Temp node to return the added numbers
        ListNode tempHeadNode = new ListNode();
        //Reference using a new ListNode
        ListNode node1 = l1, node2 = l2, curr = tempHeadNode;
        int carry = 0;

        while(node1 != null || node2 != null) {
            //Determine the current value
            int num1 = (node1 != null) ? node1.val : 0;
            int num2 = (node2 != null) ? node2.val : 0;

            //Sum is always the current value plus the carry
            int sum = num1 + num2 + carry;
            //carry will offset to 0 if < 10, to 1 if > 10
            carry = sum / 10;
            //The new value node will be the reminder after divided 10
            curr.next = new ListNode(sum % 10);

            curr = curr.next;
            if(node1 != null){
                node1 = node1.next;
            }
            if(node2 != null) {
                node2 = node2.next;
            }
        }

        if(carry > 0) {
            curr.next = new ListNode(carry);
        }

        return tempHeadNode.next;
    }


    public static void main(String[] args) {
        ListNode val3 = new ListNode(3, null);
        ListNode val2 = new ListNode(4, val3);
        ListNode val1 = new ListNode(2, val2);
        ListNode l1 = new ListNode();
        l1.next = val1;

        ListNode val4 = new ListNode(4, null);
        ListNode val5 = new ListNode(6, val4);
        ListNode val6 = new ListNode(5, val5);
        ListNode l2 = new ListNode();
        l2.next = val6;

        ListNode result = addTwoNumbers(l1, l2);
        while(result != null) {
            System.out.println(result.val);
            if(result != null) {
                result = result.next;
            }
        }

    }
}



