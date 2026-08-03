class Solution {
    public long sumAndMultiply(int n) {
        long x=0, sum=0;
        for(char c:String.valueOf(n).toCharArray())
            if(c!='0'){
                x=x*10+c-'0';
                sum+=c-'0';
            } 
            return x*sum;   
    }
}