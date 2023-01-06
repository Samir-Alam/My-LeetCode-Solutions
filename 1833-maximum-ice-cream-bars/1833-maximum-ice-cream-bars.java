class Solution {
    public int maxIceCream(int[] costs, int coins) {
        // int i = 0;
        // Arrays.sort(costs);
        // while(i < costs.length && costs[i] <= coins)
        //     coins -= costs[i++];
        // return i;
        
        int n = costs.length;
        int icecreams = 0;

        int m = costs[0];
        for (int cost : costs) {
            m = Math.max(m, cost);
        }

        int[] costsFrequency = new int[m + 1];
        for (int cost : costs) {
            costsFrequency[cost]++;
        }

        for (int cost = 1; cost <= m; ++cost) {
            // No ice cream is present costing 'cost'.
            if (costsFrequency[cost] == 0) {
                continue;
            }
            // We don't have enough 'coins' to even pick one ice cream.
            if (coins < cost) {
                break;
            }
            
            // Count how many icecreams of 'cost' we can pick with our 'coins'.
            // Either we can pick all ice creams of 'cost' or we will be limited by remaining 'coins'.
            int count = Math.min(costsFrequency[cost], coins / cost);
            // We reduce price of picked ice creams from our coins.
            coins -= cost * count;
            icecreams += count;
        }

        return icecreams;
    }
}