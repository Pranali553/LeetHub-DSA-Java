// class Solution {
//     public int[] twoSum(int[] nums, int target) {
         
//         for(int i=0;i<nums.length;i++){
//             for(int j=i+1;j<nums.length;j++){
//                 if(nums[i]+nums[j]==target){
//                     return new int[]{i,j};
//                 }
//             }
//         }
//         return new int[]{};
//     }
// }

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int a = nums[i];
            int more = target - a;
            if(map.containsKey(more)){
                return new int[]{map.get(more), i};
            }
            map.put(a, i);
        }
        return new int[]{-1, -1};
    }
}

// class Solution {
//      public int[] twoSum(int[] nums, int target) {
//         Arrays.sort(nums);
//         int left = nums[0];
//         int right = nums.length-1;
//         while(left < right){
//             int sum = nums[left] + nums[right];
//             if(sum == target){
//                 return new int[]{left, right};
//             }else if(sum < target){
//                 left++;
//             }else{
//                 right--;
//             }
//         }
// return new int[]{-1, -1};
//      }
// }