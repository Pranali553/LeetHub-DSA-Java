class Solution {
    public int climbStairs(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        
        int prev = 1;  // ways to reach (i-2)
        int curr = 1;  // ways to reach (i-1)
        
        for (int i = 2; i <= n; i++) {
            int next = prev + curr; // ways to reach i
            prev = curr;
            curr = next;
        }
        
        return curr;
    }
}
