class Solution {
      public int[] intersection(int[] nums1, int[] nums2) {
            Set<Integer> set1 = new HashSet<>();
            for (Integer n : nums1) {
                set1.add(n);
            } 
            Set<Integer> set2 = new HashSet<>();
            for (Integer n : nums2) {
                set2.add(n);
            }
            set1.retainAll(set2);
            int[] output = new int[set1.size()];
            int idx = 0;
            for (int s : set1) {
                output[idx++] = s;
            }
            return output;
      }
}