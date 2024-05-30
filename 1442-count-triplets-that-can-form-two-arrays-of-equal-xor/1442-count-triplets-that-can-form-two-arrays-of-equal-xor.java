class Solution {

    public int countTriplets(int[] arr) {
        int count = 0;

        // Iterate over each possible starting index i
        for (int start = 0; start < arr.length - 1; ++start) {
            // Initialize XOR value for the subarray from start to mid-1
            int xorA = 0;

            // Iterate over each possible middle index j
            for (int mid = start + 1; mid < arr.length; ++mid) {
                // Update xorA to include arr[mid - 1]
                xorA ^= arr[mid - 1];

                // Initialize XOR value for the subarray from mid to end
                int xorB = 0;

                // Iterate over each possible ending index k (starting from mid)
                for (int end = mid; end < arr.length; ++end) {
                    // Update xorB to include arr[end]
                    xorB ^= arr[end];

                    // found a valid triplet (start, mid, end)
                    if (xorA == xorB) {
                        ++count;
                    }
                }
            }
        }

        return count;
    }
}