

public class Solution {
    // assumptions:
    // there is at exactly least one solution
    // all numbers are positive
    public int[] twoSum(int[] nums, int target) {
        // this is a special case of subset sum, 
        // so there's not a whole lot of ways to optimize
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{ i, j };
                }
            }
        }
        
        throw new RuntimeException("Could not find matching elements");
    }
    
    
    // assumptions:
    // both lists are sorted
    // all numbers are positive
    // ListNode object are treated as immutable (like cons cells in LISP)
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode next1 = l1;
        ListNode next2 = l2;
        
        // use a dummy node at the beginning to start the list
        // the dummy node will be removed before returning
        ListNode output = new ListNode();
        output.val = -1;
        
        ListNode current = output;
        
        // keep going until we reach the end of both lists
        while (next1 != null && next2 != null) {
            if (next1 != null && next1.val >= current.val) {
                // create a new node for the output, put onto the end
                ListNode newNode = new ListNode();
                newNode.val = next1.val;
                current.next = newNode;
                
                // move both current output and next1 nodes forward
                current = newNode;
                next1 = next1.next;
            }
            else if (next2 != null && next2.val >= current.val) {
                ListNode newNode = new ListNode();
                newNode.val = next2.val;
                
                current.next = newNode;
                current = newNode;
                next2 = next2.next;
            }
        }
        
        // remove the dummy first node and return the rest of the list
        return output.next;
    }
    
    
    
    private int calculateNumber(ListNode list) {
        ListNode node = list;
        int number = 0;
        int decimalPlace = 0;
        while (node != null) {
            number += (node.val * Math.pow(10, decimalPlace);
            decimalPlace++;
        }
        
        return number;
    }
    
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int number1 = calculateNumber(l1);
        int number2 = calculateNumber(l2);
        
        int sum = number1 + number2;
        
        // also use a dummy node as the beginning
        ListNode output = new ListNode();
        
        while (sum > 0) {
            int digit = sum % 10;
            
            ListNode node = new ListNode();
            node.val = digit;
            output.next = node;
            
            sum /= 10;
        }
        
        
        return output.next;
    }
}












