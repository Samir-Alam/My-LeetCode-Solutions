class Solution {
    public int[] processQueries(int[] queries, int m) {
        List<Integer> m_arr = new ArrayList<>();
        int final_arr[] = new int[queries.length];
        for(int i=1;i<=m;i++) 
            m_arr.add(i);

        for(int i=0;i<queries.length;i++)
        {
            int temp = queries[i];

                if(m_arr.contains(temp)){
                    final_arr[i] = m_arr.indexOf(temp);
                    m_arr.remove(m_arr.indexOf(temp));
                    m_arr.add(0,temp);
            }
        }

        return final_arr;
    }
}