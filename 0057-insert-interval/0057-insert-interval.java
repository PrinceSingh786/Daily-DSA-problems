class Solution {
    public int[][] insert(int[][] it, int[] nI) {
        List<int[]> ans = new ArrayList<>();
        int i = 0 , n = it.length , st = nI[0] , en = nI[1];
        while(i<n && it[i][1]<st)ans.add(it[i++]);
        while(i<n && it[i][0]<=en){
            st = Math.min(st,it[i][0]);
            en = Math.max(en,it[i][1]);
            i++;
        }
        ans.add(new int[]{st,en});
        while(i<n)ans.add(it[i++]);
        return ans.toArray(new int[ans.size()][]);
    }
}