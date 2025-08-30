class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
      int n= nums.length;
      int[] result=new int[n-k+1];
    //   for(int i=0; i<=n-k;i++){
    //     int maxi=nums[i];
    //     for(int j=i; j<i+k; j++){
    //         maxi=Math.max(maxi, nums[j]);

    //     }
    //     result[i]=maxi;
    //   }   
    //   return result;

    Deque<Integer>dq= new LinkedList<>();
    for(int i=0; i<n; i++){
        while(!dq.isEmpty() && dq.peekFirst()<=i-k){
            dq.pollFirst();
        }
        while(!dq.isEmpty() && nums[dq.peekLast()]<nums[i]){
            dq.pollLast();
        }
        dq.offerLast(i);
    
        if(i>=k-1){
            result[i-k+1]=nums[dq.peekFirst()];
        }
    }
    return result;
}
}