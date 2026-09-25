class Solution {
    public int findLongestChain(int[][] pairs) {
        int n = pairs.length;
        Arrays.sort(pairs,(a,b) -> a[1] - b[1]);
        
        int count = 0;
        int lastend = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++){
        if(pairs[i][0] > lastend){
            count++;
            lastend = pairs[i][1];
        }
    }
    return count;
  }
}