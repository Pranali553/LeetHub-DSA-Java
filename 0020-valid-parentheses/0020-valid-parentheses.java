import java.util.*;
class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        Map<Character,Character> map = new HashMap<>();
        map.put('(',')');
        map.put('[', ']');
        map.put('{', '}');

        for(char ch : s.toCharArray()){
            if(ch == '(' || ch == '[' || ch == '{'){
                st.push(ch);
            }
            else{
                if(st.isEmpty()){
                    return false;
                }
                char top = st.pop();
                if(map.get(top) != ch){
                    return false;
                }
            }
        }
        return st.isEmpty();
    }
}