

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
    //
    // note: this is done procedurally in Java style. Done in LISP, it would be much
    // simpler and more elegant
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // use a dummy node at the beginning to start the list
        // the dummy node will be removed before returning
        ListNode output = new ListNode(-1);
        ListNode current = output;
        
        // current elements of each list
        ListNode next1 = l1;
        ListNode next2 = l2;
        
        // keep going until we reach the end of both lists
        while (next1 != null || next2 != null) {
            // if one list is empty, its "current value" will be set arbitrarily high
            int nextVal1 = Integer.MAX_VALUE;
            int nextVal2 = Integer.MAX_VALUE;
            
            if (next1 != null)
                nextVal1 = next1.val;
            if (next2 != null)
                nextVal2 = next2.val;
            
            // take the least of the two next values and advance that list's pointer
            if (nextVal1 < nextVal2){
                ListNode newNode = new ListNode(nextVal1);
                current.next = newNode;
                current = current.next;
                next1 = next1.next;
            }
            else {
                ListNode newNode = new ListNode(nextVal2);
                current.next = newNode;
                current = current.next;
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
            number += (node.val * Math.pow(10, decimalPlace));
            decimalPlace++;
            node = node.next;
        }
        
        return number;
    }
    
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int number1 = calculateNumber(l1);
        int number2 = calculateNumber(l2);
        
        int sum = number1 + number2;
        System.out.println("Sum: " + sum);
        
        // also use a dummy node as the beginning
        ListNode output = new ListNode(-1);
        ListNode current = output;
        
        while (sum > 0) {
            int digit = sum % 10;
            
            ListNode node = new ListNode(digit);
            current.next = node;
            current = output.next;
            sum = sum / 10;
        }
        
        
        return output.next;
    }
}












