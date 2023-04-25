class SmallestInfiniteSet {

    private TreeSet<Integer> set;

    public SmallestInfiniteSet() {
        set = new TreeSet<>();
        for(int i = 1; i <= 1000; i++)
        set.add(i);
    }

    public int popSmallest() {
        int smallest = set.first(); // Get the smallest integer in the set
        set.remove(smallest); // Remove it from the set
        return smallest;
    }

    public void addBack(int num) {
        if (!set.contains(num)) { // Add the integer if it is not already in the set
            set.add(num);
        }
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */