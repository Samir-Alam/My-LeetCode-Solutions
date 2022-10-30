class Solution {
    public List<List<String>> mostPopularCreator(String[] creators, String[] ids, int[] views) {
        List<List<String>> res = new ArrayList();
    	HashMap<String, Long> total = new HashMap();
    	HashMap<String, Integer> highest = new HashMap();
    	HashMap<String, String> id = new HashMap();
    	long max=0;
    	for(int i=0; i<creators.length; i++){
    		long t = total.getOrDefault(creators[i], 0l);
    		t=t+views[i];
    		total.put(creators[i], t);
    		int h = highest.getOrDefault(creators[i], -1);
    		if(h==views[i]){
    			String exis = id.get(creators[i]);
    			if(exis.compareTo(ids[i])>0)
    				id.put(creators[i], ids[i]);
    		}
    		if(h<views[i]){
    			highest.put(creators[i], views[i]);
    			id.put(creators[i], ids[i]);
    		}
    		max = Math.max(t, max);
    	}
    	for(Map.Entry<String, Long> e: total.entrySet()){
    		if(e.getValue()==max){
    			List<String> one = new ArrayList<String>();
    			one.add(e.getKey());
    			one.add(id.get(e.getKey()));
    			res.add(one);
    		}
    	}
    	return res;
    }
}