import java.util.*;

class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {

        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();

        // Store reserved seats
        for (int[] seat : reservedSeats) {

            int row = seat[0];
            int col = seat[1];

            map.putIfAbsent(row, new HashSet<>());

            map.get(row).add(col);
        }

        // Rows with no reserved seats
        int ans = (n - map.size()) * 2;

        // Check rows having reserved seats
        for (int row : map.keySet()) {

            HashSet<Integer> seats = map.get(row);

            boolean groupA = true;
            boolean groupB = true;
            boolean groupC = true;

            // Group A: 2,3,4,5
            for (int i = 2; i <= 5; i++) {
                if (seats.contains(i)) {
                    groupA = false;
                }
            }

            // Group B: 4,5,6,7
            for (int i = 4; i <= 7; i++) {
                if (seats.contains(i)) {
                    groupB = false;
                }
            }

            // Group C: 6,7,8,9
            for (int i = 6; i <= 9; i++) {
                if (seats.contains(i)) {
                    groupC = false;
                }
            }

            if (groupA && groupC) {
                ans += 2;
            }
            else if (groupA || groupB || groupC) {
                ans += 1;
            }
        }

        return ans;
    }
}