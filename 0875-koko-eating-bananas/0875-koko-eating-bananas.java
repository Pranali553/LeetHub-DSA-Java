class Solution {
    public static int func(int[] piles, int mid){
        int totalhr = 0;
        for (int i = 0; i < piles.length; i++) {
            totalhr += Math.ceil((double) piles[i] / (double) mid);
        }
        return totalhr;
    }
    private int findMax(int[] piles) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < piles.length; i++) {
            max = Math.max(max, piles[i]);
        }
        return max;
    }
    public int minEatingSpeed(int[] piles, int h) {
           int low = 1;
           int high = findMax(piles);
           int ans = Integer.MAX_VALUE;
           while(low <= high){
            int mid = low + (high - low) / 2;
            int totalhr = func(piles,mid);
            if(totalhr <= h){
                ans = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
           }
        return ans;
    }
}