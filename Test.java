


public class Test {
    private static Solution solution = new Solution();
    
    public static void main(String[] args) {
        System.out.println("Testing testSum()");
        testSum1();
        testSum2();
        testSum3();
        
        System.out.println("Testing testMerge()");
        testMerge1();
        testMerge2();
        testMerge3();
        testMerge4();
        //
        //testAdd1();
        //testAdd2();
        //testAdd3();
    }
    
    
    private static void testSum(int testId, int[] nums, int target, int[] expectedSolution) {
        System.out.println("  testSum: " + testId);
        
        try {
            int[] actualSolution = solution.twoSum(nums, target);
        
            if (actualSolution.length != 2) {
                throw new Exception("Invalid solution length: " + actualSolution.length);
            }
        
            if (actualSolution[0] != expectedSolution[0]) {
                throw new Exception("Invalid first element: " + actualSolution[0] + "; expected " + expectedSolution[0]);
            }
        
            if (actualSolution[1] != expectedSolution[1]) {
                throw new Exception("Invalid second element: " + actualSolution[1] + "; expected " + expectedSolution[1]);
            }
        }
        catch (Exception e) {
            System.out.println("Error in testSum " + testId + ": " + e.getMessage());
        }
    }
    
    
    private static void testSum1() {
        testSum(1,
                new int[]{ 2, 7, 11, 15 },
                9,
                new int[]{ 0, 1 });
    }
    
    private static void testSum2() {
        testSum(2,
                new int[]{ 3, 7, 1, 10 },
                8,
                new int[]{ 1, 2 });
    }
    
    private static void testSum3() {
        testSum(3,
                new int[]{ 2, 2 },
                4,
                new int[]{ 0, 1 });
    }
    
    
    private static ListNode buildList(int[] numbers) {
        ListNode output = new ListNode(-1);
        ListNode current = output;
        
        for (int i = 0; i < numbers.length; i++) {
            ListNode node = new ListNode(numbers[i]);
            current.next = node;
            current = current.next;
        }
        
        return output.next;
    }
    
    
    // technically, we could just convert the expected and actual outputs to strings
    // and then compare those strings, but that's not going to age well.
    // better to just test the actual elements, and use the string rep for debugging
    private static String listToString(ListNode list) {
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
    
    private static void testMerge(int testId, ListNode l1, ListNode l2, ListNode expectedSolution) {
        System.out.println("  testMerge: " + testId);
        
        ListNode actualSolution = null;
        
        try {
            actualSolution = solution.mergeTwoLists(l1, l2);
            
            ListNode currentActual = actualSolution;
            ListNode currentExpected = expectedSolution;
            
            int index = 0;
            
            String actualString = "";
            
            while (currentExpected != null) {
                if (currentActual == null) {
                    throw new Exception("Not enough elements in output: " + listToString(actualSolution));
                }
                
                if (currentExpected.val != currentActual.val)
                    throw new Exception("Mismatch on element " + index + ": " + currentActual.val);
                
                currentExpected = currentExpected.next;
                currentActual = currentActual.next;
                index++;
            }
        
            // check to make sure the actual output isn't too long
            if (currentActual != null)
                throw new Exception("Extra elements in actual output");
        }
        catch (Exception e) {
            System.out.println("Error in testMerge " + testId + ": " + e.getMessage());
            System.out.println("  expected: " + listToString(expectedSolution));
            System.out.println("  actual:   " + listToString(actualSolution));
        }
    }
    
    private static void testMerge1() {
        testMerge(1,
                  buildList(new int[]{ 1, 2, 4 }),
                  buildList(new int[]{ 1, 3, 4 }),
                  buildList(new int[]{ 1, 1, 2, 3, 4, 4 }));
        
    }

    private static void testMerge2() {
        testMerge(2,
                  buildList(new int[]{ 3 }),
                  buildList(new int[]{ 1, 2, 5, 8 }),
                  buildList(new int[]{ 1, 2, 3, 5, 8 }));
        
    }

    private static void testMerge3() {
        testMerge(3,
                  buildList(new int[]{ 7 }),
                  buildList(new int[]{ 1, 2, 5 }),
                  buildList(new int[]{ 1, 2, 5, 7 }));
        
    }

    private static void testMerge4() {
        testMerge(4,
                  buildList(new int[]{ 4, 7, 12 }),
                  buildList(new int[]{ 1 }),
                  buildList(new int[]{ 1, 4, 7, 12 }));
        
    }
}













