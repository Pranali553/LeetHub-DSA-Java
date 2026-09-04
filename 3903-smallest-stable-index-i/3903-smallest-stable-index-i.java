class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        for(int i = 0; i < n; i++){
           int currMax = nums[0];
           int currMin = nums[i];
           //find max from 0 to i
           for(int j = 0; j <= i; j++){
            currMax = Math.max(currMax,nums[j]);
           }
           //find min from i to n-1
           for(int j = i; j < n; j++){
            currMin = Math.min(currMin, nums[j]);
           }
           int score = currMax - currMin;
           if(score <= k){
            return i;
           }         
    }
    return -1;
  }
}