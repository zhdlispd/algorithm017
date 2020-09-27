class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        
    int i,j;
	i = m - 1;//nums1 last val
	j = n - 1;//nums2 last val
	while(i >= 0 && j >= 0){
		if(nums1[i] < nums2[j]){
			nums1[i+j+1] = nums2[j];
			j--;
		}
		else{
			nums1[i+j+1] = nums1[i];
			i--;
		}
	}
	while(j >= 0){
        //if more left in nums2, fill the blank
		nums1[j] = nums2[j];
		j--;
	}

    }
}