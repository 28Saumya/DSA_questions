class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n=nums.length;
        int []res=new int[n];
        for(int i=0; i<n; i++){
            boolean found= false;
            for(int j=i+1; j<i+n; j++){
                int index=j%n;
                if(nums[index]>nums[i]){
                    res[i]=nums[index];
                    found=true;
                    break;
                }
            }
            if(!found){
                res[i]=-1;
            }
        }
        return res;
    }
}