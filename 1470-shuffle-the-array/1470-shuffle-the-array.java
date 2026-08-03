class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] ans = new int[2 * n];

        int i = 0;      // pointer for x part
        int j = n;      // pointer for y part
        int k = 0;      // pointer for ans

        while (i < n) {
            ans[k++] = nums[i++]; // x element
            ans[k++] = nums[j++]; // y element
        }

        return ans;
    }
}