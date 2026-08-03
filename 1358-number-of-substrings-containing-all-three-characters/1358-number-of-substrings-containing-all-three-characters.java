// class Solution {
//     public int numberOfSubstrings(String s) {
//         int cnt=0;
//         int n=s.length();
//         for(int i=0;i<n;i++){
//             int[] hash=new int[3];
//             for(int j=i;j<n;j++){
//                 hash[s.charAt(j)- 'a']=1;

//                 if (hash[0]+hash[1]+hash[2]==3){
//                 cnt++;
//                 //cnt=cnt+(n-j);
//             }
//         }
//     }
//     return cnt;
// }
// }


class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();

        int[] lastSeen = {-1, -1, -1};

        int cnt = 0;

        for (int i = 0; i < n; i++) {
            lastSeen[s.charAt(i) - 'a'] = i;

            if (lastSeen[0] != -1 && lastSeen[1] != -1 && lastSeen[2] != -1) {
                cnt += 1 + Math.min(lastSeen[0],
                        Math.min(lastSeen[1], lastSeen[2]));
            }
        }

        return cnt;
    }
}