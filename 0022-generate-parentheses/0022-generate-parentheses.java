import java.util.*;

class Solution {

    public List<String> generateParenthesis(int n) {

        List<String> ans = new ArrayList<>();

        solve(0, 0, n, "", ans);

        return ans;
    }

    public void solve(int open, int close, int n,
                      String current, List<String> ans) {

        // Base case
        if (current.length() == 2 * n) {
            ans.add(current);
            return;
        }

        // Add '(' if we still have opening brackets
        if (open < n) {
            solve(open + 1, close, n,
                  current + "(", ans);
        }

        // Add ')' only when it is valid
        if (close < open) {
            solve(open, close + 1, n,
                  current + ")", ans);
        }
    }
}