class Solution {
    class Pair {
        String id;
        int views;
        Pair(String i, int v) {
            this.id = i;
            this.views = v;
        }
    }
    
    class Custom_comparator implements Comparator<Pair>{

        @Override
        public int compare(Pair p1, Pair p2) {
            if (p1.views == p2.views) return p1.id.compareTo(p2.id);
            return p2.views-p1.views;
        }
    }
    
    public List<List<String>> mostPopularCreator(String[] creators, String[] ids, int[] views) {
        Map<String, Integer> viewsMap = new HashMap<>();    // [creator, total_views]
        Map<String, List<Pair>> map = new HashMap<>();      // [creator, [(id, view)]]
        
        int n = ids.length;
        for (int i = 0; i < n; i++) {
            String creator = creators[i];
            viewsMap.put(creator, viewsMap.getOrDefault(creator, 0) + views[i]);   // calculate total views for a creator
            
            if (!map.containsKey(creator)) {
                map.put(creator, new ArrayList<Pair>()); 
            }
            map.get(creator).add(new Pair(ids[i], views[i]));                              // keep track of creator with [id, views]
        }
        
        int maxViews = (Collections.max(viewsMap.values()));                  // get max views
        List<String> popularCreators = new ArrayList<>();                      // stores creators with max views
        for (var entry : viewsMap.entrySet()) {
            if (entry.getValue()==maxViews) {
                popularCreators.add(entry.getKey());  
            }
        }
        
        List<List<String>> ans = new ArrayList<>();
        for (String creator : popularCreators) {
            List<Pair> list = map.get(creator);
            Collections.sort(list, new Custom_comparator());           // sort by views and if views are same for 2 ids, sort them lexicographically
            List<String> ansList = new ArrayList<>();
            ansList.add(creator);
            ansList.add(list.get(0).id);                                        // popular creator with movie id having highest views
            ans.add(ansList);
        }
        
        return ans;
    }
}