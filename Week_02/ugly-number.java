class Solution {
    public boolean isUgly(int num) {
        
        int[] arr = {2,3,5};
        for(int val:arr){
            
            while(num!=0 &&num%val ==0) num/=val;
            
           
        }
        
        return num ==1;
    }
}