class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i=0; i<nums.length; i++){
            
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
            
        }
        
         PriorityQueue<int[]> queue = new PriorityQueue<>((x, y) -> x[0] - y[0]);
    for (Integer num : map.keySet()) {
      queue.offer(new int[]{map.get(num), num});
        
      if (queue.size() > k) queue.poll();
    }
        int[] ans = new int[k];
       
    
       for (int i = 0; i < k; ++i){
            ans[i]= queue.poll()[1];
       }
     
        return ans;
    }
}