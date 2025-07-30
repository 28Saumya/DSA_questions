class Solution {
    public int maxSum(int[] nums) {
       Arrays.sort(nums);
        if(nums[nums.length-1]<=0)
            return nums[nums.length-1];
        int ans=nums[nums.length-1];
        for(int i=nums.length-2;i>=0;i--){
            if(nums[i]<0)
                break;
            if(nums[i]==nums[i+1])
                continue;
            ans+=nums[i];
        }
        return ans; 
    }
}