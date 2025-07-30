class Solution {
    public int longestSubarray(int[] nums) {
        int maxLen = 0;
        int maxAnd = 0;

        int count = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                count++;
            } else {
                if (maxAnd <= nums[i]) {
                    if (maxAnd == nums[i]) {
                        maxLen = Math.max(maxLen, count);
                    } else {
                        maxLen = count;
                    }

                    maxAnd = nums[i];
                }
                count = 1;
            }
        }
        if (maxAnd <= nums[nums.length-1]) {
            if (maxAnd == nums[nums.length-1]) {
                maxLen = Math.max(maxLen, count);
            } else {
                maxLen = count;
            }

            maxAnd = nums[nums.length-1];
        }

        return maxLen;
    }
}