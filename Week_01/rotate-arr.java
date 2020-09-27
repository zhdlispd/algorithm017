class Solution {

    // first submit, exceed time limit
    public void rotate(int[] nums, int k) {
        
        for (int i=0;i<k;i++) {
		    for (int j=nums.length-1;j>0;j--) {
			    //swap
			    int temp = nums[j];
			    nums[j] = nums[j-1];
			    nums[j-1] = temp;
			}
		}
   
    }
}