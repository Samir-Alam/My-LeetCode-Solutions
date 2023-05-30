class MyHashSet {
    int num[];
    public MyHashSet() {
        num = new int[31251];
    }
	
	// set the bit if that element is present
    public void add(int key) {
        num[getIdx(key)]|=getMask(key);
    }
	
	//unset the bit if a key is not present
    public void remove(int key) {
        num[getIdx(key)] &= (~getMask(key));
    }
	
	//check if bit corresponding to the key is set or not
    public boolean contains(int key) {
        return (num[getIdx(key)]&getMask(key))!=0;
    }
	
	// idx of num[] to which this key belongs
	// for key = 37, it will give 1
    private int getIdx(int key)
    {
        return (key/32);
    }
	
	// get mask representing the bit inside num[idx] that corresponds to given key.
	// for key = 37, it will give 00000000000000000000000000100000
    private int getMask(int key)
    {
        key%=32;
        return (1<<key);
    }
}