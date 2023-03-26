class Solution {
  private static boolean isPrime(int n) {
    for (var i=2; i*i <= n; i++)
      if (n % i == 0) return false;
 
    return true;
  }
  
  public boolean primeSubOperation(int[] nums) {
    var set = new TreeSet<Integer>();
    set.add(2);

    for (var i = 3; i <= 1000; i += 2)
      if (isPrime(i)) set.add(i);

    var n = nums.length;
    
    for (var i = n-2; i >= 0; i--) {
      if (nums[i] >= nums[i+1]) {
        var a = set.higher(nums[i] - nums[i+1]);

        if (a == null || a >= nums[i]) return false;
        
        nums[i] -= a;
      }
    }
    return true;
  }
}