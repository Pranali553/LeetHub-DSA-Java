class Solution {
    public boolean uniformArray(int[] nums1) {
        return true;
    }
}

/* The answer is always true. If all elements have the same parity, I keep every element unchanged. If both odd and even elements exist, I choose any odd element as nums1[j]. For every even element, even - odd is odd, while I keep the existing odd elements unchanged. Therefore, I can always construct nums2 with all odd elements */