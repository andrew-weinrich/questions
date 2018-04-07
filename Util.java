

public class Util {
    
    // Converts a list to a string representation
    //
    // technically, we could just convert the expected and actual outputs to strings
    // and then compare those strings, but that's not going to age well.
    // better to just test the actual elements, and use the string rep for debugging
    public static String listToString(ListNode list) {
        // empty list case
        if (list == null)
            return "(null)";
        
        StringBuilder builder = new StringBuilder();
        builder.append(list.val);
        ListNode currentNode = list.next;
        
        while (currentNode != null) {
            builder.append("->");
            builder.append(currentNode.val);
            currentNode = currentNode.next;
        }
        
        return builder.toString();
    }
    
    
    
    // compares two lists. returns null if they are identical, or an error string if they are not
    public static String compareLists(ListNode list1, ListNode list2) {
        ListNode currentOne = list1;
        ListNode currentTwo = list2;
        
        int index = 0;
        
        while (currentTwo != null) {
            if (currentOne == null) {
                return "Not enough elements in list1";
            }
            
            if (currentTwo.val != currentOne.val)
                return "Mismatch on element " + index + ": " + currentOne.val;
            
            currentTwo = currentTwo.next;
            currentOne = currentOne.next;
            index++;
        }
        
        // check to make sure the actual output isn't too long
        if (currentOne != null)
            return "Extra elements in list1";
        
        return null;
    }

    // builds a linked list from an array of numbers
    public static ListNode buildList(int[] numbers) {
        ListNode output = new ListNode(-1);
        ListNode current = output;
        
        for (int i = 0; i < numbers.length; i++) {
            ListNode node = new ListNode(numbers[i]);
            current.next = node;
            current = current.next;
        }
        
        return output.next;
    }
    
    
}