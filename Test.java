


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
        
        System.out.println("Testing testAdd()");
        testAdd0();
        testAdd1();
        testAdd2();
        testAdd3();
    }
    
    
    //
    // Testing for question 1
    //
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
    
    

    //
    // Testing for question 2
    //
    private static void testMerge(int testId, ListNode l1, ListNode l2, ListNode expectedSolution) {
        System.out.println("  testMerge: " + testId);
        
        ListNode actualSolution = solution.mergeTwoLists(l1, l2);
            
        String comparisonResult = Util.compareLists(actualSolution, expectedSolution);
        
        if (comparisonResult != null) {
            System.out.println("Error in testMerge " + testId + ": " + comparisonResult);
            System.out.println("  expected: " + Util.listToString(expectedSolution));
            System.out.println("  actual:   " + Util.listToString(actualSolution));
        }
    }
    
    private static void testMerge1() {
        testMerge(1,
                  Util.buildList(new int[]{ 1, 2, 4 }),
                  Util.buildList(new int[]{ 1, 3, 4 }),
                  Util.buildList(new int[]{ 1, 1, 2, 3, 4, 4 }));
    }

    private static void testMerge2() {
        testMerge(2,
                  Util.buildList(new int[]{ 3 }),
                  Util.buildList(new int[]{ 1, 2, 5, 8 }),
                  Util.buildList(new int[]{ 1, 2, 3, 5, 8 }));
    }

    private static void testMerge3() {
        testMerge(3,
                  Util.buildList(new int[]{ 7 }),
                  Util.buildList(new int[]{ 1, 2, 5 }),
                  Util.buildList(new int[]{ 1, 2, 5, 7 }));
    }

    private static void testMerge4() {
        testMerge(4,
                  Util.buildList(new int[]{ 4, 7, 12 }),
                  Util.buildList(new int[]{ 1 }),
                  Util.buildList(new int[]{ 1, 4, 7, 12 }));
    }


    //
    // Testing for question 3
    //
    private static void testAdd(int testId, ListNode l1, ListNode l2, ListNode expectedSolution) {
        System.out.println("  testAdd: " + testId);
        
        ListNode actualSolution = solution.addTwoNumbers(l1, l2);
            
        String comparisonResult = Util.compareLists(actualSolution, expectedSolution);
        
        if (comparisonResult != null) {
            System.out.println("Error in testAdd " + testId + ": " + comparisonResult);
            System.out.println("  expected: " + Util.listToString(expectedSolution));
            System.out.println("  actual:   " + Util.listToString(actualSolution));
        }
    }
    
    // extra test added for debugging
    private static void testAdd0() {
        testAdd(0,
                Util.buildList(new int[]{ 3, 2, 1 }),
                Util.buildList(new int[]{ 6, 5, 4 }),
                Util.buildList(new int[]{ 9, 7, 5 }));
    }
    
    private static void testAdd1() {
        testAdd(1,
                Util.buildList(new int[]{ 2, 4, 3 }),
                Util.buildList(new int[]{ 5, 6, 4 }),
                Util.buildList(new int[]{ 7, 0, 8 }));
    }
    
    private static void testAdd2() {
        testAdd(2,
                Util.buildList(new int[]{ 1 }),
                Util.buildList(new int[]{ 9, 9 }),
                Util.buildList(new int[]{ 0, 0, 1 }));
    }
    
    private static void testAdd3() {
        testAdd(3,
                Util.buildList(new int[]{ 1 }),
                Util.buildList(new int[]{ 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9  }),
                Util.buildList(new int[]{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 }));
    }
    
}

