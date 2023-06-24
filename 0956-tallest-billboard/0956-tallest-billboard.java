public class Solution {
    public int tallestBillboard(int[] rods) {
        Map<Integer, Integer> dp = new HashMap<>();
        dp.put(0, 0);
        for (int r : rods) {
            Map<Integer, Integer> newDp = new HashMap<>(dp);
            for (Map.Entry<Integer, Integer> entry : dp.entrySet()) {
                int diff = entry.getKey();
                int taller = entry.getValue();
                int shorter = taller - diff;
                int newTaller = newDp.getOrDefault(diff + r, 0);
                newDp.put(diff + r, Math.max(newTaller, taller + r));
                int newDiff = Math.abs(shorter + r - taller);
                int newTaller2 = Math.max(shorter + r, taller);
                newDp.put(newDiff, Math.max(newTaller2, newDp.getOrDefault(newDiff, 0)));
            }
            dp = newDp;
        }
        return dp.getOrDefault(0, 0);
    }
}