class Solution {
    public int maxIceCream(int[] costs, int coins) {
        // int i = 0;
        // Arrays.sort(costs);
        // while(i < costs.length && costs[i] <= coins)
        //     coins -= costs[i++];
        // return i;
        
        Arrays.sort(costs);
        for (int i = 0; i < costs.length; ++i)
            if ((coins -= costs[i]) < 0)
                return i;
        return costs.length;
    }
}