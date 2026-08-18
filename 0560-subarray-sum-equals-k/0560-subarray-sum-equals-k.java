class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;

        HashMap<Integer, Integer> map = new HashMap<>();
        int prefixsum = 0;
        int cnt = 0;

        map.put(0,1);

        for(int i = 0; i < n; i++){
            prefixsum += nums[i];
            int diff = prefixsum - k;

            if(map.containsKey(diff)){
                cnt += map.get(diff);
            }
            map.put(prefixsum, map.getOrDefault(prefixsum,0) + 1);
        }
        return cnt;
    }
}