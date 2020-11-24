class Solution {
    public int[][] merge(int[][] intervals) {
        
        if(intervals.length==0)
            return new int[0][];
        
        List<int[]> ans = new ArrayList<>();
        
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        
        int left = intervals[0][0];
        int right = intervals[0][1];
        
        for(int i=1; i<intervals.length; i++){
            if(intervals[i][0] > right){
                
                ans.add(new int[]{left, right});
                left = intervals[i][0];
                right = intervals[i][1];
                
            } else {
                
                right = Math.max(right, intervals[i][1]);
            }
            
        }
        ans.add(new int[]{left, right});
        
        return ans.toArray(new int[][]{});
    }
}