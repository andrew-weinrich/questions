


public class Test {
    private static Solution solution = new Solution();
    
    public static void main(String[] args) {
        System.out.println("Testing testSum()");
        testSum1();
        testSum2();
        testSum3();
        
        //testMerge1();
        //testMerge2();
        //testMerge3();
        //testMerge4();
        //
        //testAdd1();
        //testAdd2();
        //testAdd3();
    }
    
    
    private static void testSum(int testId, int[] nums, int target, int[] expectedSolution) {
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
    
    
}


