class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        int[] ans = new int[2];
        HashMap<Integer, Integer> h = new HashMap<Integer, Integer>();
        for( int i=0; i<nums.length; i++){
            h.put(nums[i], i);
        }
        
        for(int i=0; i<nums.length; i++){
            int val = target - nums[i];
            if(h.containsKey(val) && h.get(val) !=i){
                ans[0] = i;
                ans[1] = h.get(val);
                break;
            }
        }
        
        return ans;
    }
}