
class Solution {
    public boolean detectCapitalUse(String word) {
        
        // All letters uppercase
        if (word.equals(word.toUpperCase())) return true;

        // All letters lowercase
        if (word.equals(word.toLowerCase())) return true;

        // Only first letter capital (like "Google")
        if (Character.isUpperCase(word.charAt(0)) &&
            word.substring(1).equals(word.substring(1).toLowerCase()))
            return true;

        return false;
    }
}
