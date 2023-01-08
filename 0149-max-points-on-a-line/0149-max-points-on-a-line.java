class Solution {
    public int maxPoints(int[][] points) {
        // int maxPoints = 0;
        // for (int i = 0; i < points.length; i++) {
        //     // Map to store the slope between point i and other points
        //     HashMap<String, Integer> slopeCount = new HashMap<>();
        //     // Count the number of points that have the same coordinates as point i
        //     int samePointCount = 1;
        //     for (int j = 0; j < points.length; j++) {
        //         if (i == j)
        //             continue;
        //         // Calculate the slope between point i and point j
        //         int dx = points[i][0] - points[j][0];
        //         int dy = points[i][1] - points[j][1];
        //         // If the points have the same coordinates, increase the samePointCount
        //         if (dx == 0 && dy == 0) {
        //             samePointCount++;
        //             continue;
        //         }
        //         // Calculate the slope as a fraction in reduced form
        //         int gcd = gcd(dx, dy);
        //         String slope = (dy / gcd) + "/" + (dx / gcd);
        //         // Increase the count for this slope
        //         slopeCount.put(slope, slopeCount.getOrDefault(slope, 0) + 1);
        //     }
        //     // Update the maxPoints by taking the maximum of the samePointCount and the count for each slope
        //     maxPoints = Math.max(maxPoints, samePointCount);
        //     for (int count : slopeCount.values()) {
        //         maxPoints = Math.max(maxPoints, count + samePointCount);
        //     }
        // }
        // return maxPoints;
        
        int maxPoints = 0;

    for (int i = 0; i < points.length; i++) {
        // Map to store the slope between point i and other points
        HashMap<String, Integer> slopeCount = new HashMap<>();

        // Count the number of points that have the same coordinates as point i
        int samePointCount = 1;
        int verticalCount = 0;

        for (int j = i + 1; j < points.length; j++) {
            // Calculate the slope between point i and point j
            int dx = points[i][0] - points[j][0];
            int dy = points[i][1] - points[j][1];

            // If the points have the same coordinates, increase the samePointCount
            if (dx == 0 && dy == 0) {
                samePointCount++;
                continue;
            }

            // If the points have the same x-coordinate, they are vertical to each other
            if (dx == 0) {
                verticalCount++;
                continue;
            }

            // Calculate the slope as a fraction in reduced form
            int gcd = gcd(dx, dy);
            String slope = (dy / gcd) + "/" + (dx / gcd);

            // Increase the count for this slope
            slopeCount.put(slope, slopeCount.getOrDefault(slope, 0) + 1);
        }

        // Update the maxPoints by taking the maximum of the samePointCount, the count for each slope, and the verticalCount
        maxPoints = Math.max(maxPoints, samePointCount);
        for (int count : slopeCount.values()) {
            maxPoints = Math.max(maxPoints, count + samePointCount);
        }
        maxPoints = Math.max(maxPoints, verticalCount + samePointCount);
    }

    return maxPoints;

    }
    // Method to calculate the greatest common divisor of two integers
    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}