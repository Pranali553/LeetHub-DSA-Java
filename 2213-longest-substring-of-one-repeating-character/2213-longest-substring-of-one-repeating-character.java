class Solution {

    class Node {
        char leftChar;
        char rightChar;
        int prefix;
        int suffix;
        int max;
        int len;

        Node(char leftChar, char rightChar, int prefix, int suffix, int max, int len) {
            this.leftChar = leftChar;
            this.rightChar = rightChar;
            this.prefix = prefix;
            this.suffix = suffix;
            this.max = max;
            this.len = len;
        }
    }

    Node[] tree;
    char[] s;

    public int[] longestRepeating(String str, String queryCharacters, int[] queryIndices) {

        s = str.toCharArray();

        int n = s.length;
        tree = new Node[4 * n];

        build(1, 0, n - 1);

        int[] ans = new int[queryIndices.length];

        for (int i = 0; i < queryIndices.length; i++) {

            int index = queryIndices[i];

            s[index] = queryCharacters.charAt(i);

            update(1, 0, n - 1, index);

            ans[i] = tree[1].max;
        }

        return ans;
    }

    private void build(int node, int l, int r) {

        if (l == r) {
            tree[node] = new Node(s[l], s[l], 1, 1, 1, 1);
            return;
        }

        int mid = (l + r) / 2;

        build(2 * node, l, mid);
        build(2 * node + 1, mid + 1, r);

        tree[node] = merge(tree[2 * node], tree[2 * node + 1]);
    }

    private void update(int node, int l, int r, int index) {

        if (l == r) {
            tree[node] = new Node(s[l], s[l], 1, 1, 1, 1);
            return;
        }

        int mid = (l + r) / 2;

        if (index <= mid) {
            update(2 * node, l, mid, index);
        } else {
            update(2 * node + 1, mid + 1, r, index);
        }

        tree[node] = merge(tree[2 * node], tree[2 * node + 1]);
    }

    private Node merge(Node left, Node right) {

        int prefix = left.prefix;
        int suffix = right.suffix;
        int max = Math.max(left.max, right.max);

        if (left.rightChar == right.leftChar) {

            if (left.prefix == left.len) {
                prefix = left.len + right.prefix;
            }

            if (right.suffix == right.len) {
                suffix = right.len + left.suffix;
            }

            max = Math.max(max, left.suffix + right.prefix);
        }

        return new Node(
            left.leftChar,
            right.rightChar,
            prefix,
            suffix,
            max,
            left.len + right.len
        );
    }
}