class Solution {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            char l = s.charAt(left);
            char r = s.charAt(right);

            // Skip non-alphanumeric characters
            if (!Character.isLetterOrDigit(l)) {
                left++;
                continue;
            }
            if (!Character.isLetterOrDigit(r)) {
                right--;
                continue;
            }

            // Compare characters ignoring case
            if (Character.toLowerCase(l) != Character.toLowerCase(r)) {
                return false; // mismatch
            }

            left++;
            right--;
        }

        return true; // all matched
    }
}
